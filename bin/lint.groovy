import org.codehaus.groovy.control.CompilerConfiguration
import groovy.util.DelegatingScript
import groovy.json.JsonBuilder
import java.util.regex.Pattern

def error = { message ->
    println "[Metadata Linter] ERROR: " + message
    System.exit(1)
}

def warning = { message ->
    println "[Metadata Linter] WARNING: " + message
}

def mfile = new File("data/metadata.groovy")

def cc = new CompilerConfiguration()
cc.scriptBaseClass = DelegatingScript.class.name

def shell = new GroovyShell(cc)

def script

try {
    script = shell.parse(mfile) as DelegatingScript
} catch(e) {
    println "[Metadata Linter] ERROR: failed to load metadata"
    e.printStackTrace()
    System.exit(0)
}
def metadata = [:]
script.setDelegate(metadata)

try {
    script.run()
} catch(e) {
    error "unable to load metadata: ${e.class.name}: '${e.message}'"
}

if (metadata.languages == null) {
    error "'languages' is not defined"
}

if (!(metadata.languages instanceof List)) {
    error "'languages' is not a list"
}

def langnames = []

metadata.languages.each { lang ->
    if (lang.name == null) {
        error "languages: a language is missing a name (cannot be identified due to no name)"
    }
    
    if (lang.name in langnames) {
        error "languages: '${lang.name}' was defined more than once"
    } else {
        langnames << lang.name
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
    def filenames = lang.filenames
    if (filenames != null && filenames.empty) {
        warning "language '${lang.name}': empty 'filenames' is superfluous"
    }
}

def binaryExt = metadata.binary_extensions

if (binaryExt == null) {
    error "'binary_extensions' not defined"
}

if (!binaryExt) {
    error "'binary_extensions' is empty"
}

def vendor = metadata.vendor

if (vendor == null) {
     error "'vendor' not defined"
}

if (!vendor) {
     error "'vendor' is empty"
}

def vendorRegex = { ->
    def p = []
    vendor.each { v ->
        try {
            Pattern.compile(v)
        } catch(e) {
            error "vendor '${v}': invalid regular expression"
        }
        p << v
    }
    p.join("|")
}()



try {
    Pattern.compile(vendorRegex)
} catch(e) {
    error "vendor: generated expression '${vendorRegex}' is invalid"
}

if (metadata.keySet().size() != 3) {
    def newm = metadata.clone()
    newm.remove("vendor")
    newm.remove("languages")
    newm.remove("binary_extensions")
    warning "found unused definitions: ${newm.keySet().join(', ')}"
}

