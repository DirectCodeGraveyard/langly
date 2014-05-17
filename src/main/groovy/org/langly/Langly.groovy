package org.langly

import org.codehaus.groovy.control.CompilerConfiguration

class Langly {
    private Map<String, Object> metadata
    private List<Language> languages

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
        def script = shell.parse(this.class.classLoader.getResourceAsStream("metadata.groovy").newReader()) as DelegatingScript
        def meta = [:]
        script.setDelegate(meta)
        script.run()
        metadata = meta
        languages = { ->
	    def l = []
            metadata.languages.each { it ->
		l << new Language(it)
            }
            l
        }()
    }

    boolean isLanguage(Language lang, CodeFile file) {
        for (String ext in lang.extensions) {
            if (file.name.endsWith(ext)) {
                return true
            }
        }
        return false
    }

    Language detect(CodeFile file) {
        for (language in languages) {
            if (isLanguage(language, file)) {
                return language
            }
        }
        return null
    }

    Language language(String name) {
        for (language in languages) {
            if (language.name == name) {
                return language
            }
        }
        return null
    }

    List<String> ignoredFiles() {
        return metadata.ignored_files
    }

    List<String> binaryExtensions() {
        return metadata.binary_extensions
    }

    boolean isIgnoredFile(File file) {
        for (i in ignoredFiles()) {
            if (file.path.matches(i)) {
                 return true
            }
        }
        return false
    }
}
