package org.langly

import org.junit.Test

class DetectionTest {
    @Test
    void testSamplesDetection() {
        def samplesDir = new File("data/samples")
        samplesDir.eachFile { langDir ->
           def lang = Langly.language(langDir.name)
           langDir.eachFile { file ->
               def cfile = new CodeFile(file)
               assert cfile.language() == lang, "'${file.name}' with language '${lang.name}' was not able to be detected"
           }
        }
    }
}
