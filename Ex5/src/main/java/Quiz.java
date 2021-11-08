import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz {
    public static QuestionDataBase questionDataBase = new QuestionDataBase();
    public static Set<Question> selectedQuestions = new HashSet<>();

    public static void main(String[] args) {
        questionDataBase.readProviderListFromFile();
        Menu.mainMenu();
        System.out.println(questionDataBase.getListOfQuestions().toString());
        questionDataBase.addQuestionsListToFile();
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
