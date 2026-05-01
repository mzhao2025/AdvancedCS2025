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
		return 0;
	}

	// Given an int, returns the hexadecimal representation of that int as a String
	// Precondition: num >= 0
	public static String convertIntToHexadecimal(int num) {
		return "";
	}

	// Given a String of a hexadecimal representation of an int, returns that int
	// Precondition: hexadecimal string is not negative
	public static int convertHexadecimalToInt(String hex) {
		return 0;
	}

	// Given a String of a hexadecimal representation of an int,
	// returns the String of the binary representation
	// Precondition: hexadecimal string is not negative
	public static String convertHexadecimalToBinary(String hex) {
		return "";
	}

	// Given a String of a binary representation of an int,
	// returns the String of the hexadecimal representation
	// Precondition: hexadecimal string is not negative
	public static String convertBinaryToHexadecimal(String binary) {
		return "";
	}

	// Converts the String representation of the number to an int.
	// If the String starts with 0b, then convert the rest of the String as if it
	// were binary.
	// If the String starts with 0x, then convert the rest of the String as if it
	// were hexadecimal.
	// If the String starts with neither, then convert the rest of the String as if
	// it were decimal.
	public static int convertStringToInt(String numString) {
		return 0;
	}
}
