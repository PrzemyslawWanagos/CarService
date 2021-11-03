import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QandA {
    public QandA() {
        System.out.println("wylosowane pytania:");
        for (Question question : Quiz.selectedQuestions) {
            System.out.println((question.getCurrentID()) + "." + question.getQuestion());
            for (int i = 0; i < question.getAnswers().length; i++) {
                System.out.println("   " + (i + 1) + "." + question.getAnswers()[i]);
            }
            List<Integer> providedAnswers = QuizUtils.scanInput("podaj odpowiedz. w pzypadku wielu odpowiezi rozdziel je przecinkiem", 1, question.getAnswers().length);
            Arrays.sort(question.getCorrectAnswers());
            Collections.sort(providedAnswers);
            Boolean isAnswerCorrect = true;
            for (int i = 0; i < question.getCorrectAnswers().length; i++) {
                if (question.getCorrectAnswers()[i] != providedAnswers.get(i)) {
                    isAnswerCorrect = false;
                }
            }
            System.out.println(question.getQuestion()+" answered correctly?"+ isAnswerCorrect);
        }
    }
}
