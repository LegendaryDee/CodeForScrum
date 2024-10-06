import java.util.List;

public class LanguageLearning {
<<<<<<< HEAD
    Language selectedLanguage;
=======
    public Language selectedLanguage;
>>>>>>> 95323397a1ac27d1b198df0b8cce3dbe72b6d40e
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
