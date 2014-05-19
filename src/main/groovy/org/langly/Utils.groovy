package org.langly

import groovy.io.FileType
import groovy.transform.CompileStatic

@CompileStatic
class Utils {
    static List<File> filesIn(File directory) {
        def files = []
        directory.eachFileRecurse(FileType.FILES) { File file ->
            files << file
        }
        return files
    }

    static String parseShebang(String line) {
        def s = StringScanner.of(line)
        String script = null
        String path
        if ((path = s.scan(/^#!\s*\S+/))) {
            script = path.split("/").last()
            if (script == "env") {
                s.skip(/\s+/)
                script = s.scan(/\S+/)
            }
            if (script) {
                script = (script =~ /[^\d]+/)[0]
            }
        }
        s.close()
        return script
    }
}
