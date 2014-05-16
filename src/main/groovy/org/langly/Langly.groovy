package org.langly

import org.codehaus.groovy.control.CompilerConfiguration

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
    
    boolean isLanguage(Language lang, CodeFile file) {
        for (String ext in lang.extensions) {
            if (file.name.endsWith(ext) {
                return true
            }
        }
        return false
    }
    
    Language detect(CodeFile file) {
        for (language in metadata.languages) {
            if (isLanguage(language, file)) {
                return language
            }
        }
        return null
    }
    
    Language language(String name) {
        for (language in metadata.languages) {
            if (language.name == name) {
                return true
            }
        }
        return false
    }
}