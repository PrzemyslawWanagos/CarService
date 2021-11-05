import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class QuestionDataBase {
    private List<Question> listOfQuestions = new ArrayList<>();
   // private static final String PROVIDERS_PATH = "C:\\Users\\PRZWAN\\IS\\jjdzr4-homeworks\\Ex5\\src\\main\\resources\\providers.json";
    private static final String PROVIDERS_PATH = System.getProperty("user.dir") + "/src/main/resources/providers.json";

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
        ObjectMapper mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(PROVIDERS_PATH), listOfQuestions);
            System.out.println(PROVIDERS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void readProviderListFromFile() {
        ObjectMapper mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            listOfQuestions = mapper.readValue(new File(PROVIDERS_PATH), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
