package org.langly

class CodeFile {
    private byte[] bytes
    String name
    
    CodeFile(String filename, byte[] bytes) {
        this.name = filename
        this.bytes = bytes
    }
    
    CodeFile(String filename, String code) {
        super(filename, code.bytes)
    }
    
    CodeFile(String filename, File file) {
        super(filename, file.bytes)
    }
}