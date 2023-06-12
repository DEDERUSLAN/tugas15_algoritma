public class VigenereCipher {
    public static String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (((int) ch - 'A' + (int) key.charAt(j) - 'A') % 26 + 'A');
                encryptedMessage.append(encryptedChar);

                j = (j + 1) % key.length();
            } else {
                encryptedMessage.append(ch);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, String key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0, j = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);

            if (Character.isLetter(ch)) {
                char decryptedChar = (char) (((int) ch - 'A' - ((int) key.charAt(j) - 'A') + 26) % 26 + 'A');
                decryptedMessage.append(decryptedChar);

                j = (j + 1) % key.length();
            } else {
                decryptedMessage.append(ch);
            }
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String message = "HELLO";
        String key = "KEY";

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}