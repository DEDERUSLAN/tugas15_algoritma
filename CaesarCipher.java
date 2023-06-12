public class CaesarCipher {
    public static String encrypt(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (((int) ch - 'A' + shift) % 26 + 'A');
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(ch);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();
        shift = 26 - shift; // Inverse shift

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);

            if (Character.isLetter(ch)) {
                char decryptedChar = (char) (((int) ch - 'A' + shift) % 26 + 'A');
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(ch);
            }
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String message = "HELLO";
        int shift = 3;

        String encryptedMessage = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}