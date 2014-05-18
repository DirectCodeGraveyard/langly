package org.langly

import org.codehaus.groovy.control.CompilerConfiguration
import groovy.transform.CompileStatic
import java.util.regex.*

@CompileStatic
class Langly {
    static Map<String, Object> metadata

    private static Pattern vendorPattern

    static {
        loadMetadata()
    }

    static List<Language> languages

    private static void loadMetadata() {
        def cc = new CompilerConfiguration()
        cc.scriptBaseClass = DelegatingScript.class.name
        def shell = new GroovyShell(cc)
        def script = shell.parse(Langly.classLoader.getResourceAsStream("metadata.groovy").newReader() as Reader) as DelegatingScript
        def meta = [:]
        script.setDelegate(meta)
        script.run()
        metadata = meta
        languages = { ->
	    def l = []
            metadata.languages.each { Map it ->
		l << new Language(it)
            }
            l
        }()
        vendorPattern = Pattern.compile(vendor().join("|"))
    }

    static boolean isLanguage(Language lang, CodeFile file) {
        for (String ext in lang.extensions) {
            if (file.name().endsWith(ext)) {
                return true
            }
        }

        for (String filename in lang.filenames) {
            if (filename == file.name()) {
                return true
            }
        }

        def reader = file.code()

        def firstLine = reader.readLine()

        reader.close()

        /* First Line is a Shebang, will parse it */
        if (firstLine.startsWith("#!")) {
            /* Find Interpreter and Compare */
            def interpreter = parseShebang(firstLine)
            if (interpreter && interpreter in lang.interpreters) {
                return true
            }
        }

        return false
    }

    static Language detect(CodeFile file) {
        for (language in languages) {
            if (isLanguage(language, file)) {
                return language
            }
        }
        return null
    }

    static Language language(String name) {
        for (language in languages) {
            if (language.name == name) {
                return language
            }
        }
        return null
    }

    static List<String> vendor() {
        metadata.vendor as List<String>
    }

    static List<String> binaryExtensions() {
        metadata.binary_extensions as List<String>
    }

    static String parseShebang(String line) {
        def scanner = new Scanner(line)
        String script = null
        String path
        if ((path = scanner.next(/^#!\s*\S+/))) {
            script = path.split("/").last()
            if (script == "env") {
                scanner.skip(/\s+/)
                script = scanner.next(/\S+/)
            }
        }
        scanner.close()
        return script
    }

    static boolean isVendorFile(CodeFile file) {
        file.name() ==~ vendorPattern
    }
}
