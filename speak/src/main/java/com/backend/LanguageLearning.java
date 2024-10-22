package com.backend;

import java.util.List;

public class LanguageLearning {

    public Language selectedLanguage;

    private List<String> availableLanguages;
    private String proficiencyLevel;

    public List<String> displayLanguageOptions() {
        // Logic to display language options
        return availableLanguages;
    }

    public void chooseLanguage(String language) {
        // Logic to select a language
        this.selectedLanguage = Language.valueOf(language);
    }

    public String takeInitialAssessment() {
        // Logic for initial assessment
        return proficiencyLevel;
    }
}
