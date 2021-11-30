import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDataBase {
    private static final String RESULT_FILE = System.getProperty("user.dir") + "/src/main/resources/questions.json";
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


    public void addQuestionsListToFile() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(RESULT_FILE), listOfQuestions);
            System.out.println(RESULT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readListFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            listOfQuestions = mapper.readValue(new File(RESULT_FILE), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
