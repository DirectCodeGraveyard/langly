package org.langly

class Langly {
    private Metadata metadata
    
    static Langly create() {
        return new Langly()
    }
    
    Langly() {
        loadMetadata()
    }
    
    private void loadMetadata() {
        def cc = new CompilerConfiguration()
        cc.scriptBaseClass = DelegatingScript.class.name
        def shell = new GroovyShell(cc)
        def script = shell.parse(this.class.classLoader.getResourceAsStream("metadata.groovy")) as DelegatingScript
        def meta = [:]
        script.setDelegate(meta)
        script.run()
        this.metadata = meta as Metadata
    }
    
    Language detect() { null }
}