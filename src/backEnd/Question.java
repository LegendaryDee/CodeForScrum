package backEnd;
public class Question {
    private String questionID;
    private String text;
    private QuestionType questionType;
    private String correctAnswer;

    public Question(String questionID, String text, QuestionType questionType, String correctAnswer) {
        this.questionID = questionID;
        this.text = text;
        this.questionType = questionType;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }

    public String getQuestionID() {
        return questionID;
    }

    public String getText() {
        return text;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}
