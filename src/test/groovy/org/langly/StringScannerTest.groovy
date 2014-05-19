package org.langly

import org.junit.Test

class StringScannerTest {
    @Test
    void testScanning() {
        def input = "Hello World"
        def scanner = StringScanner.of(input)
        assert scanner.scan("(H|h)ello") == "Hello"
        assert scanner.scan("[W|w]orld") == "World"
    }
}
