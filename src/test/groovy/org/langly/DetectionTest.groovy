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
    void testSamplesDetection() {
        for (lang in langly.languages) {
            def filename = "test.${lang.extensions.first()}"
            def stream = this.class.classLoader.getResourceAsStream("samples/${lang.name}/${filename}")
            if (stream != null) {
                def code = stream.text
                def file = new CodeFile(filename, code)
                assertTrue(langly.detect(file) == lang, "Failed to detect language '${lang.name}' from sample!")
            }
	}
    }
}
