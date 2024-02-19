package utilities;

public class SharedContext {
    private static ThreadLocal<String> generatedEmail = new ThreadLocal<>();
    private static ThreadLocal<String> generatedPassword = new ThreadLocal<>();

    // Retrieves the generated email
    public static String getGeneratedEmail() {
        return generatedEmail.get();
    }

    // Retrieves the generated password
    public static String getGeneratedPassword() {
        return generatedPassword.get();
    }

    // Sets the generated email and password
    public static void setGeneratedData(String email, String password) {
        generatedEmail.set(email);
        generatedPassword.set(password);
    }
}
