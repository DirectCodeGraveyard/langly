package org.langly

import org.junit.Test
import org.junit.Before
import static org.junit.Assert.*

class DetectionTest {
    Langly langly

    @Before
    void before() {
        this.langly = new Langly()
    }

    @Test
    void testGroovyDetection() {
        assertTrue(langly.detect(new CodeFile("test.groovy", """
            println "Hello World"
        """.stripIndent())) == langly.language("Groovy"))
    }

    @Test
    void testJavaScriptDetection() {
        assertTrue(langly.detect(new CodeFile("test.js", """
            console.log("Hello World");
        """.stripIndent())) == langly.language("JavaScript"))
    }
}
