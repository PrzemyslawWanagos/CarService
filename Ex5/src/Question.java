import java.util.Arrays;

public class Question {
    public static Integer incrementalID = 0;
    private Integer currentID;
    private Category category;
    private String question;
    private String[] answers;
    private Integer[] correctAnswers;

    public Question() {
        incrementalID++;
        currentID = incrementalID;
    }

    public Question(Category category, String question, Integer[] correctAnswers, String... answers) {
        this.category = category;
        this.question = question;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
        incrementalID++;
        currentID = incrementalID;
    }

    @Override
    public String toString() {
        return "Question{" +
                "ID=" + currentID +
                ", category=" + category +
                ", question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctAnswers=" + Arrays.toString(correctAnswers) +
                "}\n";
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getCurrentID() {
        return currentID;
    }

    public void setCurrentID(Integer currentID) {
        this.currentID = currentID;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public Integer[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }


}
