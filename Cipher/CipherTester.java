public class CipherTester {

    public static void main(String[] args) {
        // Test encode method
        String message = "Hello World!";
        String encodedMessage = Cipher.encode(message);
        assert encodedMessage.equals("Khoor Zruog!") : "Encoding failed";
        System.out.println("Encoding test passed.");

        // Test decode method
        String decodedMessage = Cipher.decode(encodedMessage);
        assert decodedMessage.equals(message) : "Decoding failed";
        System.out.println("Decoding test passed.");

        // Test compress method
        String compressedMessage = Cipher.compress(message);
        assert compressedMessage.equals("H1e1l2o1 1W1o1r1l1d1!") : "Compression failed";
        System.out.println("Compression test passed.");

        // Test decompress method
        String decompressedMessage = Cipher.decompress(compressedMessage);
        assert decompressedMessage.equals(message) : "Decompression failed";
        System.out.println("Decompression test passed.");

        // All tests passed
        System.out.println("All tests passed successfully!");
    }
}

