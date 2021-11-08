import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Play {
    public Play() {
        int countOfCorrectAnswers = 0;
        System.out.println("Wylosowane pytania: ");
        for (Question question : Quiz.selectedQuestions) {
            printQuestion(question);
            Boolean isAnswerCorrect = checkAnswer(question);
            if (isAnswerCorrect) {
                System.out.println("Odpowiedz poprawna :)");
                countOfCorrectAnswers++;
            } else {
                System.out.println("Odpowiedz niepoprawna:( \n Poprawna odpowiedz to:");
                StringBuilder msg = new StringBuilder();
                for (Integer correctAnswer : question.getCorrectAnswers()) {
                    msg.append(correctAnswer).append(".").append(question.getAnswers()[correctAnswer - 1]);
                }
                System.out.println(msg);
            }
        }
        System.out.println("Odpowiedziales poprawnie na " + countOfCorrectAnswers + " z " + Quiz.selectedQuestions.size() + " odpowiedzi.\n\n");
        Menu.mainMenu();
    }

    private void printQuestion(Question question) {
        System.out.println((question.getCurrentID()) + "." + question.getQuestion());
        for (int i = 0; i < question.getAnswers().length; i++) {
            System.out.println("   " + (i + 1) + "." + question.getAnswers()[i]);
        }
    }

    private Boolean checkAnswer(Question question) {
        boolean isAnswerCorrect = true;
        List<Integer> providedAnswers = QuizUtils.scanForInt("podaj nr odpowiedzi. W pzypadku wielu odpowiedzi rozdziel je przecinkiem", 1, question.getAnswers().length, false);
        Arrays.sort(question.getCorrectAnswers());
        Collections.sort(providedAnswers);
        if (question.getCorrectAnswers().length != providedAnswers.size()) {
            isAnswerCorrect = false;
        } else {
            for (int i = 0; i < question.getCorrectAnswers().length; i++) {
                if (!Objects.equals(question.getCorrectAnswers()[i], providedAnswers.get(i))) {
                    isAnswerCorrect = false;
                }
            }
        }
        return isAnswerCorrect;
    }
}
