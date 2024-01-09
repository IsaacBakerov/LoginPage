public class PasswordOperations {
    public static String encrypt(StringBuilder password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char letter = (char) (password.charAt(i) + 1);
            encryptedPassword.append(letter);
        }

        return encryptedPassword.toString();
    }

    public static String decrypt(String password) {
        StringBuilder inputPassword = new StringBuilder(password);
        StringBuilder decryptedPassword = new StringBuilder();

        for (int i = 0; i < inputPassword.length(); i++) {
            char letter = (char) (inputPassword.charAt(i) - 1);
            decryptedPassword.append(letter);
        }

        return decryptedPassword.toString();
    }
}
