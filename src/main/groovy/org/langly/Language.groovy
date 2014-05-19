package org.langly

import groovy.transform.CompileStatic

@CompileStatic
class Language {
    String name
    List<String> extensions
    List<String> related = []
    String type = "programming"
    String mimetype = "text/plain"
    List<String> filenames = []
    List<String> interpreters = []

    Language(Map<?, ?> map) {
        map.entrySet().each { Map.Entry<?, ?> entry ->
	    setProperty(entry.key as String, entry.value)
        }
    }

    boolean check(FileBlob file) {
        file.detect() == this
    }

    static Language getAt(String name) {
        Langly.language(name)
    }
}
