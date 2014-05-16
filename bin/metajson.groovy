import org.codehaus.groovy.control.CompilerConfiguration
import groovy.util.DelegatingScript
import groovy.json.JsonBuilder

def cc = new CompilerConfiguration()
cc.scriptBaseClass = DelegatingScript.class.name

def shell = new GroovyShell(cc)
def script = shell.parse(new File("data/metadata.groovy")) as DelegatingScript
def metadata = [:]
script.setDelegate(metadata)
script.run()

def output = new JsonBuilder(metadata).toPrettyString()

if (args.size() != 0) {
    new File(args[0]).text = output
} else {
    println(output)
}