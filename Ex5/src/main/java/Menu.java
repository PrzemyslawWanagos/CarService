import java.util.List;

public class Menu {
    public static void mainMenu() {
        System.out.println("Witaj w aplikacji 'Quiz'.");
        Boolean exit = false;
        while (!exit) {
            System.out.println("Dostepne opcje to:");
            System.out.println("1. Szybka gra bez wyboru kategorii");
            System.out.println("2. Dodawanie pytania");
            System.out.println("0. wyjscie z programu");
            List<Integer> menuSelection = QuizUtils.scanForInt("wybierz opcje", 0, 2, true);
            switch (menuSelection.get(0)) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    Quiz.questionSelection(3);
                    Play play = new Play();
                    break;
                case 2:
                    Question newQuestion = new Question();
                    newQuestion.createQuestion();
                    Quiz.questionDataBase.addQuestion(newQuestion);
                    break;
            }
        }
    }
}
