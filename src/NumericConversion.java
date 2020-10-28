import java.util.Scanner;
public class NumericConversion {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int menuChoice;
        String usersInput;

        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println("\n");
        System.out.println("Please enter an option: ");
        menuChoice = scnr.nextInt();

        while(menuChoice >= 0 && menuChoice <= 3) {

            switch (menuChoice) {
                case 1:
                    System.out.println("Please enter the numeric string to convert: ");
                    usersInput = scnr.next();
                    if (usersInput.startsWith("0x")) {
                        usersInput = usersInput.substring(2);
                    }

                    System.out.println("Result: " + hexStringDecode(usersInput) + "\n");
                    break;

                case 2:
                    System.out.println("Please enter the numeric string to convert: ");
                    usersInput = scnr.next();
                    if (usersInput.startsWith("0b")) {
                        usersInput = usersInput.substring(2);
                    }
                    System.out.println("Result: " + binaryStringDecode(usersInput) + "\n");
                    break;

                case 3:
                    System.out.println("Please enter the numeric string to convert: ");
                    usersInput = scnr.next();
                    if (usersInput.startsWith("0x")) {
                        usersInput = usersInput.substring(2);
                    }
                    System.out.println("Result: " + binaryToHex(usersInput) + "\n");
                    break;

            }
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println("\n");
            System.out.println("Please enter an option: ");
            menuChoice = scnr.nextInt();
        }
        System.out.println("Goodbye!");
        System.out.println("\n");
    }

    public static long hexStringDecode(String hex) {
        long dec = 0;
        for (int i = 0; i < hex.length(); i++) {
            dec = 16 * dec;
            dec = dec + hexCharDecode(hex.charAt(i));
        }
        return dec;
    }

    public static long binaryStringDecode(String binary) {
        long dec = 0;
        for (int i = binary.length() - 1, j = 0; i >= 0; i--, j++) {
            dec += Integer.parseInt(String.valueOf(binary.charAt(i))) * (long) Math.pow(2, j);
        }
        return dec;
    }

    public static String binaryToHex(String binary) {
        String hex = "";
        for (int i = binary.length() - 4, j = binary.length(); j >= 0; i -= 4, j -= 4) {
            String group = binary.substring(i < 0 ? 0 : i, j);
            int groupDec = 0;
            for (int k = group.length() - 1, m = 0; k>= 0; k--, m++) {
                groupDec += Integer.parseInt(String.valueOf(group.charAt(k))) * (int) Math.pow(2, m);
            }
            char groupHex;
            if (groupDec > 9) {
                groupHex = (char) ((char) (groupDec - 10) + 'A');
            } else {
                groupHex = (char) ((char) groupDec + '0');
            }
            hex = groupHex + hex;
        }
        return hex;
    }

    public static short hexCharDecode(char digit) {
        short value = 0;
        if (digit >= '0' && digit <= '9') {
            value = (short) (digit - '0');
        } else if (digit >= 'A' && digit <= 'F') {
            value = (short) (digit - 'A' + 10);
        } else if (digit >= 'a' && digit <= 'f') {
            value = (short) (digit - 'a' + 10);
        }
        return value;
    }
}


















