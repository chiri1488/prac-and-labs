import java.util.regex.*;

public class HyperlinkReplacer {

    public static void main(String[] args) {
        String text = "https://www.youtube.com/"; 
        String replacedText = replaceLinksWithHyperlinks(text);
        System.out.println(replacedText);
    }

    public static String replaceLinksWithHyperlinks(String text) {
        if (text.isEmpty()) {
            return "Строка пуста.";
        }

        // ругулярка для поиска ссылок
        String regex = "\\bhttps?://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*[-A-Za-z0-9+&@#/%=~_|]";
        
        try {
            // метод патерн.компил компилирует регулярку
            // матчер это движок чтобы сравнивать исходный текст и регулярку
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            
            // проверка на наличие ссылок
            if (!matcher.find()) {
                return "Строка не содержит ссылок.";
            }
            
            // так-как движок матчер запоминает позиция последнего совпадения
            // надо ресетить его значение чтобы он игнорировал предыдущую ошибку
            
            matcher.reset();
            
            // заменяем каждое найденное совпадение
            // на заданную строку 
            StringBuffer result = new StringBuffer();
            while (matcher.find()) {
                String replacement = "<a href=\"" + matcher.group() + "\">" + matcher.group() + "</a>";
                matcher.appendReplacement(result, replacement);
            }
            // добавляем оставшуюся часть строки через метод appendTail
            matcher.appendTail(result);
            
            return result.toString();
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в синтаксисе регулярного выражения: " + e.getMessage());
            return null;
        }
    }
}
