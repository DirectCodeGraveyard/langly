package org.langly

class CodeFile {
    private byte[] bytes
    String name
    
    CodeFile(String filename, byte[] bytes) {
        this.name = filename
        this.bytes = bytes
    }
    
    CodeFile(String filename, String code) {
        this.name = filename
        this.bytes = code.bytes
    }
    
    CodeFile(String filename, File file) {
        this.name = filename
        this.bytes = file.bytes
    }

    String getCode() {
        new String(bytes)
    }
}
