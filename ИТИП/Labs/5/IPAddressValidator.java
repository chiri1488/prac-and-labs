import java.util.regex.*;

public class IPAddressValidator {

    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";  // корректный IP адрес
        System.out.println(isValidIPAddress(ipAddress));
    }

    public static boolean isValidIPAddress(String ipAddress) {
        if (ipAddress.isEmpty()) {
            System.out.println("Строка пуста.");
            return false;
        }

        // регулярка для проверки IP адреса
        String regex = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";

        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ipAddress);

            // проверка соответствия IP адреса регулярке
            if (!matcher.matches()) {
                System.out.println("Неверный формат IP-адреса.");
                return false;
            }
            return true;
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return false;
        }
    }
}
