import org.codehaus.groovy.control.CompilerConfiguration
import groovy.util.DelegatingScript

utils = [:]

class CodeFile {
    String code
    String name
    
    CodeFile(File file) {
        this.name = file.name
        this.code = file.text
    }
    
    CodeFile(String filename, String code) {
        this.name = filename
        this.code = code
    }
}

utils.fileHasExtension = { String filename, String... extensions ->
    for (extension in extensions) {
        if (filename.endsWith(extension)) {
            return true
        }
    }
    return false
}

load_metadata = { ->
    def cc = new CompilerConfiguration()
    cc.scriptBaseClass = DelegatingScript.class.name
    def shell = new GroovyShell(cc)
    def script = shell.parse(new File("data/metadata.groovy")) as DelegatingScript
    def metadata = [:]
    script.setDelegate(metadata)
    script.run()
    metadata
}

def metadata = load_metadata() 

detect = { CodeFile file ->
    for (language in metadata.languages) {
        if (utils.fileHasExtension(file.name, language.extensions as String[])) {
            return language
        }
    }
    return null
}

testDetection = { CodeFile file ->
    def detected = detect(file)
    if (!detected) {
        println "Failed to detect the file '${file.name}'"
        System.exit(1)
    } else {
        println "Detected the file '${file.name}' to be the language '${detected.name}'"
    }
}

testDetection(new CodeFile("test.groovy", """
println 'Hello World'
"""))
testDetection(new CodeFile("Example.java", """\
public class Example {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
"""))
testDetection(new CodeFile("test.py", """\
print('Hello World')
"""))
testDetection(new CodeFile("test.rb", """\
puts 'Hello World'
"""))
testDetection(new CodeFile("test.scala", """\
println("Hello World!")
"""))
testDetection(new CodeFile("test.json", """\
{
    "test": "Hello World"
}
"""))
testDetection(new CodeFile("test.coffee", """\
console.log "Hello World"
"""))
testDetection(new CodeFile("test.js", """\
console.log("Hello World");
"""))