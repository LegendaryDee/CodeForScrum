package backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class DictionaryTest {

    private Dictionary dictionary;

    @BeforeEach
    public void setUp() {
        dictionary = new Dictionary();
        Map<String, String> translationMap = new HashMap<String, String>();
        // Manually add some entries to the dictionary
        translationMap.put("hello", "hola");
        translationMap.put("goodbye", "adiós");
        dictionary.setTranslations(translationMap);
    }

    @Test
    public void testLookupWordExists() {
        // Test lookup for a word that exists in the dictionary
        dictionary = new Dictionary();
        Map<String, String> translationMap = new HashMap<String, String>();
        // Manually add some entries to the dictionary
        translationMap.put("hello", "hola");
        translationMap.put("goodbye", "adiós");
        dictionary.setTranslations(translationMap);
    assertEquals("hola", dictionary.lookupWord("hello"), "Expected 'hello' to translate to 'hola'");
        assertEquals("adiós", dictionary.lookupWord("goodbye"), "Expected 'goodbye' to translate to 'adiós'");
    }

    @Test
    public void testLookupWordDoesNotExist() {
        dictionary = new Dictionary();
        // Test lookup for a word that does not exist in the dictionary
        assertNull(dictionary.lookupWord("unknown"), "Expected translation for an unknown word to be null");
    }

    @Test
    public void testLookupNullInput() {
        // Test lookup with null input
        dictionary = new Dictionary();
        assertNull(dictionary.lookupWord(null), "Expected translation for null input to be null");
    }
}
