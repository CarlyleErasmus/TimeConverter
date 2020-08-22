import java.util.Scanner;


public class TimeConverter {
    public static void main(String[] args) {
        System.out.print("Enter a time ([h]h:mm [am|pm]): ");
        Scanner scanner = new Scanner(System.in);
        String timeInput = scanner.nextLine();
        char lastCharacter = timeInput.charAt(timeInput.length() - 1);
        char secondLastCharacter =  timeInput.charAt(timeInput.length() - 2);
        String lastCharacterToString = Character.toString(lastCharacter);
        String secondLastCharacterToString = Character.toString(secondLastCharacter);

        if (lastCharacterToString.equals("m")) {
            //timeInput is in 12-hour format.
            if (secondLastCharacterToString.equals("p")) {
                //first two numbers of time change
                String h1 = Character.toString(timeInput.charAt(0));
                h1 = h1 + Character.toString(timeInput.charAt(1));
                int hh = Integer.parseInt(h1);
                int hhNew = hh + 12;

                if(hhNew == 24) hhNew = 12;

                System.out.println(hhNew + timeInput.substring(2, 5));
            } else {
                //time is in the hour of 12:00 am or first two numbers of time do not change
                char firstCharacter = timeInput.charAt(0);
                char secondCharacter = timeInput.charAt(1);
                String firstCharacterToString = Character.toString(firstCharacter);
                String secondCharacterToString = Character.toString(secondCharacter);
                String h1 = firstCharacterToString + secondCharacterToString;

                if (h1.equals("12")) {
                    System.out.println("00" + timeInput.substring(2, 5));
                }
                else {
                    System.out.println(timeInput.substring(0, 5));
                }
            }
        } else {
            //timeInput is in 24-hour format
            char firstCharacter = timeInput.charAt(0);
            char secondCharacter = timeInput.charAt(1);
            String firstCharacterToString = Character.toString(firstCharacter);
            String secondCharacterToString = Character.toString(secondCharacter);
            String h1 = firstCharacterToString + secondCharacterToString;

            if (h1.equals("00")) {
                h1 = "12";
                System.out.println(h1 + timeInput.substring(2, 5) + " am");
            } else {
                int hh = Integer.parseInt(h1);
                if (hh < 12) {
                    //first two numbers of timeInput do not change and the output string ends in "am"
                    System.out.println(timeInput + " am");
                } else if (hh == 12) {
                    //first two numbers of timeInput do not change but the output string ends in "pm"
                    System.out.println(timeInput + " pm");
                } else if (hh > 12) {
                    //first two numbers of timeInput change and the output string ends in "pm"
                    hh = hh - 12;
                    System.out.println(hh + timeInput.substring(2, 5) + " pm");
                } else {}
            }
        }
    }
}
