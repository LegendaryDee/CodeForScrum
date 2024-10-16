package backEnd;

import java.util.ArrayList;

public class PictureExercise extends Exercise
{
    private String imagePath;
    private String description;

    /**
     * Constructs a PictureExercise with details
     * @param exerciseID the ID of exercise
     * @param type the type of exercise
     * @param difficulty  the difficulty level
     * @param content the content of the exercise
     * @param questions the list of questions
     * @param imagePath the file path of the image resource.
     * @param description the description of the image.
     */
    public PictureExercise(String exerciseID, String type, String difficulty, String content, ArrayList<Question> questions, String imagePath, String description)
    {
       super(exerciseID, type, difficulty, content, questions);
       this.imagePath = imagePath;
       this.description = description; 
    }
    
    /**
     * Displays the image for the exercise.
     */
    public void displayImage()
    {
        System.out.println("Displaying image from: " + imagePath);
    }

    /**
     * Shows the description of the image.
     */
    public void showDescription()
    {
        System.out.println("Description: " + description);
    }

    /**
     *  Gets the image file path.
     * @return the file path of the image.
     */
    public String getImagePath()
    {
        return imagePath;
    }

    /**
     * Sets the image file path.
     * @param imagePath
     */
    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    /**
     * Gets the description of the image
     * @return description text
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * sets the description of the image
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
}


