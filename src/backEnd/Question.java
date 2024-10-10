package backEnd;
public class Question {
    public String questionID;
    public String text;
    public QuestionType questionType;

    public Question(String questionFromJson) {
    }

    public boolean checkAnswer(String answer) {
        // Logic to check if the answer is correct
        return true;
    }

    public Object getText() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getText'");
    }
}
