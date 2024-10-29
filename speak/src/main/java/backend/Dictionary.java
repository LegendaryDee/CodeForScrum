package backend;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> translations = new HashMap<>();

    public String lookupWord(String word) {
        // Logic to look up word in dictionary
        return translations.get(word);
    }
}
