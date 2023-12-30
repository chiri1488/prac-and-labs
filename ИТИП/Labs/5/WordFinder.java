import java.util.regex.*;

public class WordFinder {

    public static void main(String[] args) {
        String text = "Apple apricot banana cherry date.";
        char startingLetter = 'b';
        findWords(text, startingLetter);
    }

    public static void findWords(String text, char startingLetter) {
        if (text.isEmpty()) {
            System.out.println("Строка пуста.");
            return;
        }

        // ругулярка для поиска слов, начинающихся с заданной буквы
        String regex = "\\b" + Pattern.quote(String.valueOf(startingLetter)) + "\\w*\\b";

        try {
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            // поиск и вывод всех слов начинающихся с заданной буквы
            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }
            
            if (!found) {
                System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "', не найдены.");
            }
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
        }
    }
}
