import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text1 = "The price of the product is $19.99";
        String text2 = "abc";
        String text3 = "";
        
        try {
            findAndPrintNumbers(text1);
            findAndPrintNumbers(text2);
            findAndPrintNumbers(text3);
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static void findAndPrintNumbers(String text) {
        Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d{1,2})?\\b");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Предложение: " + text);
        
        if (!matcher.find()) {
            System.out.println("В данном предложении нет чисел.\n");
            return;
        }
        
        System.out.print("Найденные числа: ");

        // поиск и вывод всех чисел
        do {
            System.out.print(matcher.group() + " ");
        } while (matcher.find());

        System.out.println("\n");
    }
}
