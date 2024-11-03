package backend;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageTest {

    @Test
    public void testEnumValues() {
        // Verify the number of enum values
        Language[] values = Language.values();
        assertEquals(4, values.length, "Expected 4 languages");

        // Verify each enum value
        assertEquals(Language.ENGLISH, values[0], "Expected first language to be ENGLISH");
        assertEquals(Language.FRENCH, values[1], "Expected second language to be FRENCH");
        assertEquals(Language.GERMAN, values[2], "Expected third language to be GERMAN");
        assertEquals(Language.SPANISH, values[3], "Expected fourth language to be SPANISH");
    }

    @Test
    public void testEnumValueOf() {
        // Verify each enum value using valueOf
        assertEquals(Language.ENGLISH, Language.valueOf("ENGLISH"));
        assertEquals(Language.FRENCH, Language.valueOf("FRENCH"));
        assertEquals(Language.GERMAN, Language.valueOf("GERMAN"));
        assertEquals(Language.SPANISH, Language.valueOf("SPANISH"));
    }
}
