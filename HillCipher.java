import java.util.Arrays;

public class HillCipher {
    private static final int SIZE = 2; // Ukuran matriks kunci

    private static int[][] keyMatrix = {
            {1, 2},
            {3, 4}
    };

    private static int[][] inverseKeyMatrix = {
            {-2, 1},
            {3, -1}
    };

    private static int[][] stringToMatrix(String str) {
        int[][] matrix = new int[SIZE][1];
        for (int i = 0; i < SIZE; i++) {
            matrix[i][0] = str.charAt(i) - 'A';
        }
        return matrix;
    }

    private static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append((char) (matrix[i][0] + 'A'));
        }
        return sb.toString();
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[SIZE][1];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < SIZE; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] %= 26;
            }
        }
        return result;
    }

    public static String encrypt(String message) {
        message = message.replaceAll("[^A-Za-z]+", "").toUpperCase();
        StringBuilder encryptedMessage = new StringBuilder();

        while (message.length() % SIZE != 0) {
            message += 'X'; // Padding jika panjang pesan tidak kelipatan SIZE
        }

        for (int i = 0; i < message.length(); i += SIZE) {
            String block = message.substring(i, i + SIZE);
            int[][] blockMatrix = stringToMatrix(block);
            int[][] encryptedBlock = multiplyMatrices(keyMatrix, blockMatrix);
            encryptedMessage.append(matrixToString(encryptedBlock));
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i += SIZE) {
            String block = encryptedMessage.substring(i, i + SIZE);
            int[][] blockMatrix = stringToMatrix(block);
            int[][] decryptedBlock = multiplyMatrices(inverseKeyMatrix, blockMatrix);
            decryptedMessage.append(matrixToString(decryptedBlock));
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String message = "HELLO";

        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
