package org.langly

import org.junit.Test

class DetectionTest {
    @Test
    void testSamplesDetection() {
        for (lang in Langly.languages) {
            def filename = "test${lang.extensions.first()}"
            def stream = getClass().classLoader.getResourceAsStream("samples/${lang.name}/${filename}")
            if (stream != null) {
                def code = stream.text
                def file = new CodeFile(filename, code)
                assert lang.check(file), "Failed to detect language '${lang.name}' from sample!"
            }
	}
    }
}
