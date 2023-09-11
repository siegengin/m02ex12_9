import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number as a string: ");
        String binaryString = input.nextLine();

        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.out.println("Not a binary number.");
        }

        input.close();
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        int decimalValue = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            char c = binaryString.charAt(i);
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("The string is not a binary string");
            }

            int digit = Character.getNumericValue(c);
            decimalValue += digit * Math.pow(2, length - 1 - i);
        }

        return decimalValue;
    }
}