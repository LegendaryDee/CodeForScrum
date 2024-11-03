package backend;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProficiencyTest {

    @Test
    public void testEnumValues() {
        // Verify the number of enum values
        Proficiency[] values = Proficiency.values();
        assertEquals(5, values.length, "Expected 5 proficiency levels");

        // Verify each enum value
        assertEquals(Proficiency.NOVICE, values[0], "Expected first level to be NOVICE");
        assertEquals(Proficiency.BEGINNER, values[1], "Expected second level to be BEGINNER");
        assertEquals(Proficiency.COMPETENT, values[2], "Expected third level to be COMPETENT");
        assertEquals(Proficiency.PROFICIENT, values[3], "Expected fourth level to be PROFICIENT");
        assertEquals(Proficiency.EXPERT, values[4], "Expected fifth level to be EXPERT");
    }

    @Test
    @SuppressWarnings("unused")
    public void testEnumValueOf() {
        // Verify each enum value using valueOf
        assertEquals(Proficiency.NOVICE, Proficiency.valueOf("NOVICE"));
        assertEquals(Proficiency.BEGINNER, Proficiency.valueOf("BEGINNER"));
        assertEquals(Proficiency.COMPETENT, Proficiency.valueOf("COMPETENT"));
        assertEquals(Proficiency.PROFICIENT, Proficiency.valueOf("PROFICIENT"));
        assertEquals(Proficiency.EXPERT, Proficiency.valueOf("EXPERT"));
    }
}
