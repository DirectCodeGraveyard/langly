package org.langly

class LanguageScanResult {
    Language language
    double score

    @Override
    String toString() {
        "${language.name}: ${score}"
    }
}
