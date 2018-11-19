package View;

import java.util.Scanner;

public class UITools {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumber(String s) {

        int svar = 9;

        System.out.print(s);
        try {
            svar = Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            e.printStackTrace();
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
