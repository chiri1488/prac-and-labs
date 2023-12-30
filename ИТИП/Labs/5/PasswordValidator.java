import java.util.regex.*;

public class PasswordValidator {

    public static void main(String[] args) {
        String password = "Pod13242323";
        System.out.println(isValidPassword(password));
    }

    public static boolean isValidPassword(String password) {
        if (password.isEmpty()) {
            System.out.println("Вы не ввели пароль.");
            return false;
        }
        // проверка длины пароля
        if (password.length() < 8 || password.length() > 16) {
            System.out.println("Пароль должен быть от 8 до 16 символов.");
            return false;
        }

        // регулярка для проверки пароля
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        // проверка соответствует ли пароль регулярному выражению
        if (!matcher.matches()) {
            System.out.println("Пароль должен содержать хотя бы одну заглавную букву и одну цифру.");
            return false;
        }

        return true;
    }
}
