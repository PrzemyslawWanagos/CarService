import java.util.ArrayList;
import java.util.List;

public class QuestionDataBase {
    private List<Question> listOfQuestions = new ArrayList<>();

    public QuestionDataBase() {
    }

    public QuestionDataBase(List<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    @Override
    public String toString() {
        return "QuestionDataBase{" +
                "listOfQuestions=" + listOfQuestions +
                '}';
    }

    public List<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public void addQuestion(Question question) {
        listOfQuestions.add(question);
    }
    public class QuestionAdd {

    }

}
