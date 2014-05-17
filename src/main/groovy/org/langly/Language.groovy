package org.langly

import groovy.transform.CompileStatic

@CompileStatic
class Language {
    String name
    List<String> extensions
    List<String> related
    String type
    String mimetype

    Language(Map map) {
        map.entrySet().each { Map.Entry entry ->
	    setProperty(entry.key as String, entry.value)
        }
    }

    boolean check(CodeFile file) {
        file.detect() == this
    }
}
