package org.langly

import org.junit.Test
import org.junit.Ignore

class VendorFilesTest {
    @Test
    void testGitFiles() {
        assert new CodeFile(".gitignore").vendor()
        assert new CodeFile(".gitattributes").vendor()
    }

    @Test
    void testGradleFiles() {
        assert new CodeFile("gradle/wrapper/gradle-wrapper.properties").vendor()
    }

    @Test
    void testReadmeFiles() {
        assert new CodeFile("README.md").vendor()
    }

    @Test
    void testCodeNotVendored() {
        assert !(new CodeFile("Test.java").vendor())
    }
}
