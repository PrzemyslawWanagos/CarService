package com.infoshareacademy;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public abstract class Utils {

    public static File findFile(String path, String fName) {
        File f = new File(path);
        if (fName.equalsIgnoreCase(f.getName())) return f;
        if (f.isDirectory()) {
            for (String aChild : f.list()) {
                File ff = findFile(path + File.separator + aChild, fName);
                if (ff != null) return ff;
            }
        }
        return null;
    }
    public static List<Integer> scanForInt(String prompt, int min, int max, boolean singleSelection) {
        System.out.println(prompt);
        List<Integer> toReturn = new ArrayList<>();
        String[] fromScannerDelimited;
        String fromScanner;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                fromScanner = scanner.nextLine();
                fromScannerDelimited = fromScanner.split(",");
                if (singleSelection && fromScannerDelimited.length > 1) {
                    throw new Exception("too many argumets entered");
                }
                for (String s : fromScannerDelimited) {
                    int answerInt = Integer.parseInt(s);
                    if (answerInt >= min && answerInt <= max) {
                        toReturn.add(answerInt);
                    } else {
                        throw new Exception("out of specified range");
                    }
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn.clear();
            }
        } while (toReturn.size() == 0);
        return toReturn;
    }

    public static String scanForString(String prompt) {
        System.out.println(prompt);
        String toReturn = "";
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                scanForString(prompt);
            }
        } while (Objects.equals(toReturn, ""));
        return toReturn;
    }

    public static String scanForString(String prompt, String... allowedAnswers) {
        String toReturn;
        do {
            System.out.println(prompt);
            System.out.println("Dopuszczalne wartosci to: ");
            System.out.println(Arrays.toString(allowedAnswers));
            try {
                Scanner scanner = new Scanner(System.in);
                toReturn = scanner.nextLine();
                boolean isAnswerCorrect = false;
                for (String allowedAnswer : allowedAnswers) {
                    if (toReturn.equals(allowedAnswer)) {
                        isAnswerCorrect = true;
                        break;
                    }
                }
                if (!isAnswerCorrect) {
                    throw new Exception("not in the list of allowed answers");
                }
            } catch (Exception e) {
                System.out.println("nieodpowiedia wartosc.");
                toReturn = "";
            }
        } while (toReturn.equals(""));
        return toReturn;
    }

    public static <T> String arrayToString(T[] array, Boolean printNumbers) {
        String toReturn = "";
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (printNumbers) {
                    toReturn = toReturn + (i + 1) + "." + array[i] + "\n";
                } else {
                    toReturn = toReturn + array[i] + "\n";
                }
            }
        }
        return toReturn;
    }

    public static <T> String listToString(List<T> list, Boolean printNumbers) {
        String toReturn = "";
        for (int i = 0; i < list.size(); i++) {
            if (printNumbers) {
                toReturn = toReturn + (i + 1) + ". " + list.get(i) + "<br>";
            } else {
                toReturn = toReturn + list.get(i) + "<br>";
            }
        }
        return toReturn;
    }
    public static List<String> findStringInList(List<String> list, String stringToFind) {

        return list.stream()
                .filter(s -> s
                        .toLowerCase(Locale.ROOT)
                        .contains(stringToFind.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

}

