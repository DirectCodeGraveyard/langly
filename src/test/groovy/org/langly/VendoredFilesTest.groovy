package org.langly

import org.junit.Test
import org.junit.Ignore

@Ignore("Not Ready Yet")
class VendoredFilesTest {
    @Test
    void testGitFiles() {
        assert new CodeFile(".gitignore").vendored()
        assert new CodeFile(".gitattributes").vendored()
    }

    @Test
    void testGradleFiles() {
        assert new CodeFile("gradle/wrapper/gradle-wrapper.properties").vendored()
    }

    @Test
    void testReadmeFiles() {
        assert new CodeFile("README.md").vendored()
    }

    @Test
    void testCodeNotVendored() {
        assert new CodeFile("Test.java").vendored()
    }
}
