import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz {
    public static QuestionDataBase questionDataBase = new QuestionDataBase();
    public static Set<Question> selectedQuestions = new HashSet<>();


    public static void main(String[] args) {


        populateInitialQuestions();
        System.out.println("Full list");
        System.out.println(questionDataBase);
        System.out.println("selected list of questions");
        questionSelection(2);
        System.out.println(selectedQuestions);

        QandA qandA = new QandA();
    }

    private static void populateInitialQuestions() {
        questionDataBase.addQuestion(new Question(Category.MOVIES, "What is the title of latest James Bond movie?", new Integer[]{3}, "Casino Royale", "Doctor No", "No time to die"));
        questionDataBase.addQuestion(new Question(Category.MOVIES, "How many trilogies are there in StarWars saga", new Integer[]{2}, "six", "three", "one"));
        questionDataBase.addQuestion(new Question(Category.MOVIES, "Which characters are present in Hobbit movies", new Integer[]{1, 3}, new String[]{"Bilbo", "Frodo", "Gandalf"}));


    }

    public static void questionSelection(Integer numberOfQuestionsToBeSelected) {


        do {
            Random random = new Random();
            int selectedQuestionNumber = random.nextInt(questionDataBase.getListOfQuestions().size());
            selectedQuestions.add(questionDataBase.getListOfQuestions().get(selectedQuestionNumber));
        } while (selectedQuestions.size() < numberOfQuestionsToBeSelected);
    }
}
