package backend;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTypeTest {

    @Test
    public void testEnumValues() {
        // Verify the number of enum values
        QuestionType[] values = QuestionType.values();
        assertEquals(3, values.length, "Expected 3 question types");

        // Verify each enum value
        assertEquals(QuestionType.MULTIPLE_CHOICE, values[0], "Expected first type to be MULTIPLE_CHOICE");
        assertEquals(QuestionType.TRUE_FALSE, values[1], "Expected second type to be TRUE_FALSE");
        assertEquals(QuestionType.FILL_IN_THE_BLANK, values[2], "Expected third type to be FILL_IN_THE_BLANK");
    }

    @Test
    public void testEnumValueOf() {
        // Verify each enum value using valueOf
        assertEquals(QuestionType.MULTIPLE_CHOICE, QuestionType.valueOf("MULTIPLE_CHOICE"));
        assertEquals(QuestionType.TRUE_FALSE, QuestionType.valueOf("TRUE_FALSE"));
        assertEquals(QuestionType.FILL_IN_THE_BLANK, QuestionType.valueOf("FILL_IN_THE_BLANK"));
    }

    @Test
    public void testGetTypeDescription() {
        // Verify the descriptions returned by getTypeDescription()
        assertEquals("A question with multiple choice answers.", QuestionType.MULTIPLE_CHOICE.getTypeDescription());
        assertEquals("A question that can be answered with true or false.", QuestionType.TRUE_FALSE.getTypeDescription());
        assertEquals("A question where the answer is entered as text.", QuestionType.FILL_IN_THE_BLANK.getTypeDescription());
    }
}
