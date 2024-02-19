package utilities;

public class SharedContext {
    private static ThreadLocal<String> generatedEmail = new ThreadLocal<>();
    private static ThreadLocal<String> generatedPassword = new ThreadLocal<>();

    public static String getGeneratedEmail() {
        return generatedEmail.get();
    }

    public static String getGeneratedPassword() {
        return generatedPassword.get();
    }

    public static void setGeneratedData(String email, String password) {
        generatedEmail.set(email);
        generatedPassword.set(password);
    }
}
