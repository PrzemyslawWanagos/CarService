import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void addAnswer(String answer) {
        List<String> listOfAnswers;
        if (answers == null) {
            listOfAnswers = new ArrayList<>();
        } else {
            listOfAnswers = new ArrayList<>(Arrays.asList(answers));
        }
        try {
            listOfAnswers.add(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        answers = listOfAnswers.toArray(new String[0]);
        System.out.println(Arrays.toString(answers));
    }

    public void createQuestion() {
        List<Category> listOfCategories = Arrays.asList(Category.values());
        System.out.println("Dostepne kategorie pytan to:");
        for(int i=0;i<listOfCategories.size();i++){
            System.out.println(i+1+"."+listOfCategories.get(i));
        }
        category=listOfCategories.get(QuizUtils.scanForInt("Wybiez kategorie od 1 do "+listOfCategories.size(),1,listOfCategories.size(),true).get(0)-1);

        question=QuizUtils.scanForString("Podaj pytanie?");
        String answer = "";
        while (!answer.equals("q")) {
            answer = QuizUtils.scanForString("Podaj odpowiedz. Aby zakonczyc podaj 'q'");
            if (!answer.equals("q")) {
                addAnswer(answer);
            }
        }
        System.out.println("Nowe pytanie to:"+question);
        System.out.println("Nowe odpowiedzi to:");
        for(int i=0;i< answers.length;i++){
            System.out.println((i+1)+"."+answers[i]);
        }
        correctAnswers=QuizUtils.scanForInt("Wybierz poprawna odpowiedz w zakresie :1 do "+answers.length+". W przypadku wielu odpowiedzi rozdziel je przecinkiem.",1,answers.length,false).toArray(new Integer[0]);
        System.out.println(Arrays.toString(correctAnswers));
    }

    public Integer[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }


}
