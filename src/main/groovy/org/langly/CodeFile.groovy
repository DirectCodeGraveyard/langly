package org.langly

import groovy.transform.CompileStatic

@CompileStatic
class CodeFile {
    private File file
    private String code
    private String name

    CodeFile(String filename) {
        this.name = filename
    }

    CodeFile(String filename, String code) {
        this.name = filename
        this.code = code
    }

    CodeFile(File file) {
        this.file = file
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
