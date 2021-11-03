import java.util.List;

public class Menu {
    public static void mainMenu() {
        System.out.println("Witaj w aplikacji 'Quiz'.");
        System.out.println("Dostepne opcje to:");
        System.out.println("1. Szybka gra bez wyboru kategorii");
        System.out.println("0. wyjscie z programu");
        List<Integer> menuSelection = QuizUtils.scanInput("wybierz opcje", 0, 1, true);
        switch (menuSelection.get(0)) {
            case 0:
                break;
            case 1:
                Quiz.questionSelection(3);
                Play play = new Play();
                break;
            case 2:
                break;
        }
    }
}
