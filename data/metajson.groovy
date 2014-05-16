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
println new JsonBuilder(metadata).toPrettyString()