package org.langly

import groovy.transform.CompileStatic

/**
 * Port of StringScanner that uses Scanner
 */
@CompileStatic
class StringScanner {
    private final Scanner scanner

    static StringScanner of(String input) {
        new StringScanner(input)
    }

    StringScanner(String input) {
        this.scanner = new Scanner(input)
    }

    String scan(String pattern) {
        scanner.hasNext(pattern) ? scanner.next(pattern) : null
    }

    void skip(String pattern) {
        scanner.skip(pattern)
    }

    void skipUntil(String pattern) {
        while (scanner.hasNext(pattern)) {
            scanner.skip(pattern)
        }
    }

    void close() {
        scanner.close()
    }
}
