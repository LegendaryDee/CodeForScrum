package backEnd;

import java.util.List;

/**
 * Represents a vocabulary exercise.
 * Extends the base Exercise class.
 */
public class VocabExercise extends Exercise 
{
    private List<String> vocabularyList;
    private List<String> definitions;
    /**
 * Constructs a VocabExercise with details
 * @param exerciseId the ID of exercise
 * @param type the type of exercise
 * @param difficulty the difficulty level
 * @param content the content of exercise
 * @param questions the list of questions
 * @param vocabularyList the list of vocabulary words
 * @param defintions the list of definitions of the vocabulary
 */
 public VocabExercise(String exerciseId, String type, String difficulty, String content, List<Question> questions, List<String> vocabularyList, List<String> defintions)
{
    super(exerciseId, type, difficulty, content, questions);
    this.vocabularyList = vocabularyList;
    this.definitions = defintions;
}

/**
 * Displays the vocabulary words with their definitions.
 */
public void displayVocabulary()
{
    for (int i = 0; i < vocabularyList.size(); i++)
    {
        System.out.println(vocabularyList.get(i) + " - " + definitions.get(i));
    }
}

/**
 * Gets the list of vocabulary words
 * @return the list of vocabulary words.
 */
public List<String> getVocabularyList()
{
    return vocabularyList;
}

/**
 * Sets the list of vocabulary words. 
 * @param vocabularyList the new list of vocabulary words
 */
public void setVocabularyList(List<String> vocabularyList)
{
    this.vocabularyList = vocabularyList;
}
/**
 * Gets list of definitions
 * @return the list of definitions
 */
public List<String> getDefinitions()
{
    return definitions;
}

/**
 * set the list of definitions the new list of definitions.
 * @param definitions
 */
public void setDefinitions(List<String> definitions)
{
    this.definitions = definitions;
}
}

