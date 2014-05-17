import org.codehaus.groovy.control.CompilerConfiguration
import groovy.util.DelegatingScript
import groovy.json.JsonBuilder
import java.util.regex.Pattern

def mfile = new File("data/metadata.groovy")

def cc = new CompilerConfiguration()
cc.scriptBaseClass = DelegatingScript.class.name

def shell = new GroovyShell(cc)
def script = shell.parse(mfile) as DelegatingScript
def metadata = [:]
script.setDelegate(metadata)
script.run()

def error = { message ->
    println "[Metadata Linter] ERROR: " + message
    System.exit(1)
}

def warning = { message ->
    println "[Metadata Linter] WARNING: " + message
}

if (metadata.languages == null) {
    error "'languages' is not defined"
}

if (!(metadata.languages instanceof List)) {
    error "'languages' is not a list"
}

metadata.languages.each { lang ->
    if (lang.name == null) {
        error "languages: a language is missing a name (cannot be identified due to no name)"
    }

    if (lang.extensions == null) {
        error "language '${lang.name}': 'extensions' is not defined"
    }

    if (!lang.extensions) {
        error "language '{lang.name}': no extensions given"
    }

    lang.extensions.each { ext ->
        if (!ext.startsWith(".")) {
             warning "language '${lang.name}': extension '${ext}': does not start with a '.', possible typo"
        }
    }

    def sample = new File("data/samples/${lang.name}/test${lang.extensions.first()}")

    if (!sample.exists()) {
        warning "language '${lang.name}': no test sample exists"
    } else {
       if (sample.text.trim() == "") {
           warning "language '${lang.name}': test sample is empty"
       }
    }
}

def binaryExt = metadata.binary_extensions

if (binaryExt == null) {
    error "'binary_extensions' not defined"
}

def vendored = metadata.vendored

if (vendored == null) {
     error "'vendored' not defined"
}

if (!vendored) {
     error "'vendored' is empty"
}

def vendoredRegex = { ->
    def p = []
    vendored.each { v ->
        p << Pattern.quote(v)
    }
    p.join("|")
}()

try {
    Pattern.compile(vendoredRegex)
} catch(e) {
    error "vendored: generated expression '${vendoredRegex}' is invalid"
}
