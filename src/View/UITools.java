package View;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UITools {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumber(String s) {

        String regExPattern = "\\b\\d{1,2}\\b"; // et-to-cifret tal
        int svar = 9;
        boolean matches;

        do {
            System.out.print(s);
            String inputText = scanner.nextLine();
            matches = Pattern.matches(regExPattern, inputText);
            if (matches) {
                svar = Integer.parseInt(inputText);
            } else {
                System.out.println("Fejl i indtastning. Prøv igen.");
            }
        } while (!matches);

        return svar;
    }

    public static String getInputString(String s) {
        String svar;
        System.out.print(s);
        svar = scanner.nextLine();
        return svar;
    }

    public static LocalDateTime getInputTime(String s) {

        String regExPattern = "([0-9]{1,2}):([0-9]{1,2})"; // hh:mm
        Pattern pattern = Pattern.compile(regExPattern);
        ZoneId zoneDK = ZoneId.of("Europe/Berlin");
        LocalDateTime svarTid = LocalDateTime.now(zoneDK);
        Matcher matcher = null;

        do {
            System.out.print(s);
            String inputText = scanner.nextLine();
            matcher = pattern.matcher(inputText);
            if (matcher.matches()) {
                int hours = Integer.parseInt(matcher.group(1));
                int minutes = Integer.parseInt(matcher.group(2));
                int year = svarTid.getYear();
                int month = svarTid.getMonthValue();
                int day = svarTid.getDayOfMonth();
                svarTid = LocalDateTime.of(year, month, day, hours, minutes);
            } else {
                System.out.println("Fejl i indtastning. Prøv igen.");
            }
        } while (!matcher.matches());

        return svarTid;
    }
}
