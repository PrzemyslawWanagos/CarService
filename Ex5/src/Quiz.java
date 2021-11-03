import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz {
    public static QuestionDataBase questionDataBase = new QuestionDataBase();
    public static Set<Question> selectedQuestions = new HashSet<>();


    public static void main(String[] args) {
        populateInitialQuestions();
        Menu.mainMenu();
    }

    private static void populateInitialQuestions() {
        questionDataBase.addQuestion(new Question(Category.MOVIES, "What is the title of latest James Bond movie?", new Integer[]{3}, "Casino Royale", "Doctor No", "No time to die"));
        questionDataBase.addQuestion(new Question(Category.MOVIES, "How many trilogies are there in StarWars saga", new Integer[]{2}, "six", "three", "one"));
        questionDataBase.addQuestion(new Question(Category.MOVIES, "Which characters are present in Hobbit movies", new Integer[]{1, 3}, new String[]{"Bilbo", "Frodo", "Gandalf"}));
        questionDataBase.addQuestion(new Question(Category.JAVA, "Which statement is true for Java Arrays", new Integer[]{2}, "The elements of Array are always sorted", "Arrays have defined size, which cannot be changed", "You can expand Array using expand() method"));
        questionDataBase.addQuestion(new Question(Category.GEOGRAPHY, "Which city is the capital of France", new Integer[]{1}, "Paris", "Berlin", "Rome"));
    }

    public static void questionSelection(Integer numberOfQuestionsToBeSelected) {
        selectedQuestions.clear();
        do {
            Random random = new Random();
            int selectedQuestionNumber = random.nextInt(questionDataBase.getListOfQuestions().size());
            selectedQuestions.add(questionDataBase.getListOfQuestions().get(selectedQuestionNumber));
        } while (selectedQuestions.size() < numberOfQuestionsToBeSelected);
    }
}
