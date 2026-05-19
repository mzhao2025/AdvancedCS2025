public class Cipher {

    public static String encode(String message) {
        if (message == null) {
            throw new IllegalArgumentException("message cannot be empty.");
        } else if (message.isEmpty()) {
            return "";
        }
        String encodedString = "";
        for (char c : message.toCharArray()) {
            encodedString += encodeChar(c);
        } return encodedString;
    }

    private static char encodeChar(char c) {
        if (Character.isLetter(c)) {
            char rootChar = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (rootChar + (c - rootChar + 3) % 26);
        } return c;
    }

    public static String decode(String encodedMessage) {
        if (encodedMessage == null) {
            throw new IllegalArgumentException("message cannot be empty.");
        } else if (encodedMessage.isEmpty()) {
            return "";
        }
        String decodedString = "";
        for (char c: encodedMessage.toCharArray()) {
            decodedString += decodeChar(c);
        } return decodedString;
    }

    private static char decodeChar(char c) {
        if (Character.isLetter(c)) {
            char rootChar = Character.isLowerCase(c) ? 'a' : 'A';
            return (char) (rootChar + (c - rootChar + 23) % 26);
        } return c;
    }

    public static String compress(String message) {
        if (message == null) {
            throw new IllegalArgumentException("message cannot be empty.");
        } else if (message.isEmpty()) {
            return "";
        }
        String compressedString = "";
        int count = 1;
        for (int i = 0; i < message.length(); i++) {
            if ((i + 1 < message.length()) && (message.charAt(i + 1) == message.charAt(i))) {
                count += 1;
            } else {
                compressedString += message.charAt(i);
                if (i + 1 < message.length() || count > 1) {
                    compressedString += count;
                }
                count = 1;
            }
        }
        return compressedString.toString();
    }

    public static String decompress(String compressedMessage) {
        if (compressedMessage == null) {
            throw new IllegalArgumentException("message cannot be empty.");
        } else if (compressedMessage.isEmpty()) {
            return "";
        }
    
        String decompressedString = "";
        for (int i = 0; i < compressedMessage.length(); i++) {
            char c = compressedMessage.charAt(i);

            String numberPart = "";
            int j = i + 1;
            while (j < compressedMessage.length() && Character.isDigit(compressedMessage.charAt(j))) {
                numberPart += compressedMessage.charAt(j);
                j++;
            }
            int count = 0;
            if (numberPart.length() == 0) {
                if (j < compressedMessage.length()) {
                    throw new IllegalArgumentException("Missing count for character at index " + i);
                }
                count = 1;
            } else {
                count = Integer.parseInt(numberPart.toString());
                if (count <= 0) {
                    throw new IllegalArgumentException("Count must be greater than zero.");
                }
            }
    
            for (int k = 0; k < count; k++) {
                decompressedString += c;
            }

            i = j - 1;
        }
        return decompressedString.toString();
    }
}
