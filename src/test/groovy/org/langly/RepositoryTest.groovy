package org.langly

import org.junit.Test

class RepositoryTest {
    @Test
    void testLanglyRepository() {
        assert new Repository(".").language() == Langly.language("Groovy")
    }
}
