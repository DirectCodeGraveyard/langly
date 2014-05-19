package org.langly

import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
class Repository {
    private File location

    Repository(String path) {
        this.location = new File(path)
    }

    Repository(File location) {
        this.location = location
    }

    Language language() {
        languages()?.first()?.language
    }

    @CompileDynamic
    List<LanguageScanResult> languages() {
        def results = []
        def counts = [:]
        def total = 0
        for (File file in Utils.filesIn(location)) {
            def blob = new FileBlob(file)
            def path = (file.path - location.path).substring(1)
            if (path ==~ Langly.vendorPattern) {
                continue
            }
            def language = blob.language()
            if (language == null) {
                continue
            }
            counts[language.name] = ((counts[language.name] ?: 0) as int) + 1
            total++
        }
        counts.entrySet().each { Map.Entry<?, ?> entry ->
            def result = new LanguageScanResult(language: Langly.language(entry.key as String), score: ((entry.value as double) / total) * 100)
            results << result
        }
        results.sort { LanguageScanResult it -> 0 - it.score }
    }
}
