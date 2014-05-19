package org.langly

import org.junit.Test

class APITest {
    @Test
    void testLanguageIndex() {
        assert Language['Groovy'] == Langly.language('Groovy')
    }
}
