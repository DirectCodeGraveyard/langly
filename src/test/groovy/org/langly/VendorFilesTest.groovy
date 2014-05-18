package org.langly

import org.junit.Test
import org.junit.Ignore

class VendorFilesTest {
    @Test
    void testGitFiles() {
        assert new FileBlob(".gitignore").vendor()
        assert new FileBlob(".gitattributes").vendor()
    }

    @Test
    void testGradleFiles() {
        assert new FileBlob("gradle/wrapper/gradle-wrapper.properties").vendor()
    }

    @Test
    void testReadmeFiles() {
        assert new FileBlob("README.md").vendor()
    }

    @Test
    void testCodeNotVendored() {
        assert !(new FileBlob("Test.java").vendor())
    }
}
