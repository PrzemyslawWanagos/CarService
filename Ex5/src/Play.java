import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Play {
    public Play() {
        System.out.println("wylosowane pytania:");
        for (Question question : Quiz.selectedQuestions) {
            printQuestion(question);
            Boolean isAnswerCorrect = checkAnswer(question);
            System.out.println(question.getQuestion()+" answered correctly?"+ isAnswerCorrect);
        }
    }

    private void printQuestion(Question question) {
        System.out.println((question.getCurrentID()) + "." + question.getQuestion());
        for (int i = 0; i < question.getAnswers().length; i++) {
            System.out.println("   " + (i + 1) + "." + question.getAnswers()[i]);
        }
    }

    private Boolean checkAnswer(Question question) {
        Boolean isAnswerCorrect = true;
        List<Integer> providedAnswers = QuizUtils.scanInput("podaj odpowiedz. w pzypadku wielu odpowiezi rozdziel je przecinkiem", 1, question.getAnswers().length);
        Arrays.sort(question.getCorrectAnswers());
        Collections.sort(providedAnswers);
        //if(Arrays.equals(Arrays.asList(question.getCorrectAnswers()),providedAnswers ));
        if(question.getCorrectAnswers().length!=providedAnswers.size()){
            isAnswerCorrect = false;
        }
        for (int i = 0; i < question.getCorrectAnswers().length; i++) {
            if (question.getCorrectAnswers()[i] != providedAnswers.get(i)) {
                isAnswerCorrect = false;
            }
        }
        return isAnswerCorrect;
    }
}
