package org.langly

import org.junit.Test

class ShebangTest {

    @Test
    void testBashShebang() {
        assert Utils.parseShebang("#!/bin/bash") == "bash"
    }

    @Test
    void testGroovyShebang() {
        assert Utils.parseShebang("#!/usr/bin/env groovy") == "groovy"
    }

    @Test
    void testPythonShebang() {
        assert Utils.parseShebang("#!/usr/bin/env python") == "python"
    }
}
