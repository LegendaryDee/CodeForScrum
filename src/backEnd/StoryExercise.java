package backEnd;
import java.util.List;

public class StoryExercise extends Exercise
{
    private String storyText;
    private String narrationFilePath;

    /**
     * Constructs a StoryExercise with details
     * @param exerciseID
     * @param type
     * @param difficulty
     * @param content
     * @param questions
     * @param storyText
     * @param narrationFilePath
     */
    public StoryExercise(String exerciseID, String type, String difficulty, String content, List<Question> questions, String storyText, String narrationFilePath)
    {
        super(exerciseID, type, difficulty, content, questions);
        this.storyText = storyText;
        this.narrationFilePath = narrationFilePath;
    }

    /**
     * Reads the story text
     */
    public void readStory()
    {
        System.out.println("Story: " +storyText);
    }

    /**
     * Gets the story text
     * @param storyText
     * @return
     */
    public String getStoryText(String storyText)
    {
        return this.storyText = storyText;
    }

    /**
     * Gets the narration path
     * @return
     */
    public String getNarrationFilePath()
    {
        return narrationFilePath;
    }

    /**
     * Sets the narration file path.
     * @param narrationFilePath
     */
    public void setNarrationFilePath(String narrationFilePath)
    {
        this.narrationFilePath = narrationFilePath;
    }
}
