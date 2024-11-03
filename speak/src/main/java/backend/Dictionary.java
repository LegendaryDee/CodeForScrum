package backend;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	
    private Map<String, String> translations = new HashMap<>();
    
    public String lookupWord(String word) {
        // Logic to look up word in dictionary
        return translations.get(word);
    }

	/**
	 * @return the translations
	 */
	public Map<String, String> getTranslations() {
		return translations;
	}

	/**
	 * @param translations the translations to set
	 */
	public void setTranslations(Map<String, String> translations) {
		this.translations = translations;
	}
    
}
