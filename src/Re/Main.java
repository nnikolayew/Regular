package Re;

/**
 Вариант №2, 8, 14, 20, 26
 В программу подается текст из файла, состоящего из строчек формата
 Имя Фамилия|Возраст|ТелефонныйНомер|ЭлектроннаяПочта
 Необходимо проверить данные на корректность, и по возможности, исправленную версию
 поместить в другой файл. Если данные ошибочные, то часть строки оставить пустой. К примеру, из строки
 ИванИванов|27|+
 7999000 1 1 11|example@@yandex..ru
 может после исправления получиться строка
 Иван Иванов|27|+7 (999) 0001111|
 example@yandex.ru
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String FILE_DIRECTORY = "C:\\Users\\Myself\\workspace\\Regular\\doc\\in";

    protected static String stringCheckResult(String string) {
        Matcher patternMathcer = Pattern.compile("[А-ЯА-Я\\w]+ [\\d]+ [^[:word:]]|[\\d]+ [[:word:]]|[^[:word:]]").matcher(string);
        return patternMathcer.matches() ? "OK" : "ERROR";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(FILE_DIRECTORY));
        String currentFileString = "";
        while ((currentFileString = inputFileReader.readLine()) != null) {
            System.out.println(currentFileString + " - " + stringCheckResult(currentFileString));
        }
        inputFileReader.close();
    }

}
