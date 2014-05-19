package org.langly

import groovy.transform.CompileStatic
import groovy.io.FileType

@CompileStatic
class Utils {
    static List<File> filesIn(File directory) {
        def files = []
        directory.eachFileRecurse(FileType.FILES) { File file ->
            files << file
        }
        return files
    }
}
