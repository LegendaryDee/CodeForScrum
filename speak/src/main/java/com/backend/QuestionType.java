package com.backend;

public enum QuestionType {
    MULTIPLE_CHOICE,
    TRUE_FALSE,
    FILL_IN_THE_BLANK;

    // Optionally, you can add methods for further description
    public String getTypeDescription() {
        switch(this) {
            case MULTIPLE_CHOICE:
                return "A question with multiple choice answers.";
            case TRUE_FALSE:
                return "A question that can be answered with true or false.";
            case FILL_IN_THE_BLANK:
                return "A question where the answer is entered as text.";
            default:
                return "Unknown type";
        }
    }
}
