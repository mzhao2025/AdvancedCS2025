public class BinaryAndHexadecimalConversion {

	// Given an int, returns the binary representation of that int as a String
	// Precondition: num >= 0
	public static String convertIntToBinary(int num) {
        if (num == 0) return "0";
        if (num == 1) return "1";
        return convertIntToBinary(num / 2) + (num % 2);
    }

	// Given a String of a binary representation of an int, returns that int
	// Precondition: binary string is not negative
	public static int convertBinaryToInt(String binary) {
        int total = 0;
        for (int i = 0; i < binary.length(); i++) {
            total = total * 2 + (binary.charAt(i) - '0');
        }
        return total;
    }

	// Given an int, returns the hexadecimal representation of that int as a String
	// Precondition: num >= 0
	public static String convertIntToHexadecimal(int num) {
        if (num == 0) return "0";
        String hexChars = "0123456789abcdef";
        
        if (num / 16 > 0) {
            return convertIntToHexadecimal(num / 16) + hexChars.charAt(num % 16);
        } return "" + hexChars.charAt(num % 16);
    }

	// Given a String of a hexadecimal representation of an int, returns that int
	// Precondition: hexadecimal string is not negative
	public static int convertHexadecimalToInt(String hex) {
		int total = 0;
        String hexChars = "0123456789abcdef";
        hex = hex.toLowerCase();
        for (int i = 0; i < hex.length(); i++) {
            total = total * 16 + (hexChars.indexOf(hex.charAt(i)));
        }
        return total;
	}

	// Given a String of a hexadecimal representation of an int,
	// returns the String of the binary representation
	// Precondition: hexadecimal string is not negative
	public static String convertHexadecimalToBinary(String hex) {
		return convertIntToBinary(convertHexadecimalToInt(hex));
	}

	// Given a String of a binary representation of an int,
	// returns the String of the hexadecimal representation
	// Precondition: hexadecimal string is not negative
	public static String convertBinaryToHexadecimal(String binary) {
		return convertIntToHexadecimal(convertBinaryToInt(binary));
	}

	// Converts the String representation of the number to an int.
	// If the String starts with 0b, then convert the rest of the String as if it
	// were binary.
	// If the String starts with 0x, then convert the rest of the String as if it
	// were hexadecimal.
	// If the String starts with neither, then convert the rest of the String as if
	// it were decimal.
	public static int convertStringToInt(String numString) {
        if (numString.length() < 2) {
            return Integer.parseInt(numString);
        }
        String lowerNumString = numString.toLowerCase();
        if (lowerNumString.startsWith("0b")) {
            // Use binary converter for 0b
            return convertBinaryToInt(numString.substring(2));
        } else if (lowerNumString.startsWith("0x")) {
            // Use hexadecimal converter for 0x
            return convertHexadecimalToInt(numString.substring(2));
        } else {
            return Integer.parseInt(numString);
        }
    }
}
