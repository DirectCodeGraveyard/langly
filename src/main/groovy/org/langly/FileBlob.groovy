package org.langly

import java.nio.file.Path
import groovy.transform.CompileStatic

@CompileStatic
class FileBlob {
    private File file
    private String code
    private String name

    FileBlob(String filename) {
        this.name = filename
    }

    FileBlob(String filename, String code) {
        this.name = filename
        this.code = code
    }

    FileBlob(File file) {
        this.file = file
    }

    FileBlob(Path path) {
        this.file = path.toFile()
    }

    Reader code() {
        code ? new StringReader(code) : file.newReader()
    }

    String name() {
        name ?: file.name
    }

    boolean vendor() {
        Langly.isVendorFile(this)
    }

    Language detect() {
        Langly.detect(this)
    }

    String mimetype() {
        def detected = detect()
        if (detected) {
            return detected.mimetype ?: "text/plain"
        } else {
            return null
        }
    }

    boolean binary() {
        mimetype() ? true : false
    }

    Language language() {
        detect()
    }
}
