package org.langly

import org.junit.Test

class DetectionTest {
    @Test
    void testSamplesDetection() {
        def samplesDir = new File("samples/")
        samplesDir.eachFile { langDir ->
           assert Language[langDir.name] != null, "Sample Directory '${langDir.name}' could not be matched to a language"
           langDir.eachFile { file ->
               def blob = new FileBlob(file)
               assert blob.language() == Language[langDir.name], "'${file.name}' with language '${langDir.name}' was not able to be detected"
           }
        }
    }
}
