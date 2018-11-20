package View;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UITools {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumber(String s) {

        String regExPattern = "\\b\\d{1,2}\\b"; // et-cifret tal
        int svar;
        boolean matches;

        System.out.print(s);
        String inputText = scanner.nextLine();
        matches = Pattern.matches(regExPattern,inputText);
        if (matches){
            svar = Integer.parseInt(inputText);
        } else {
            svar = 9;
        }
        return svar;
    }

    public static String getInputString(String s) {
        String svar;
        System.out.print(s);
        svar = scanner.nextLine();
        return svar;
    }

}
