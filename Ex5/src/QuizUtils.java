import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizUtils {
    public static List<Integer> scanInput(String prompt, int min, int max) {
        System.out.println(prompt);
        List<Integer> toReturn = new ArrayList<>();
        String[] fromScannerDelimited;
        String fromScanner;
        try {
            Scanner scanner = new Scanner(System.in);
            fromScanner = scanner.nextLine();
            fromScannerDelimited = fromScanner.split(",");
            for (int i = 0; i < fromScannerDelimited.length; i++) {
                Integer answerInt = Integer.parseInt(fromScannerDelimited[i]);
                if (answerInt >= min && answerInt <= max) {
                    toReturn.add(answerInt);
                }
            }
        } catch (Exception e) {
            System.out.println("nieodpowiedia wartosc");
            scanInput(prompt, min, max);
        }
        return toReturn;
    }
}
