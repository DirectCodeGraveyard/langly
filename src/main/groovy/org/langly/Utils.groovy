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
}
