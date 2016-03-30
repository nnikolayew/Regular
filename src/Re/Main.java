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
import java.io.*;
import java.io.IOException.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String FILE_DIRECTORY = "C:\\Users\\Myself\\workspace\\Regular\\doc\\in";

    protected static String stringCheckResult(String string) {
        Matcher patternMathcer = Pattern.compile("(\\w+)(\\|)(-)(\\d+)(\\|)(\\+?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\|)(\\w+)").matcher(string);
        return patternMathcer.matches() ? "OK" : "ERROR";
    }

    public static void task2(String oldPattern, String newPattern, String read, String wright) throws FileNotFoundException{
        Pattern pattern = Pattern.compile(oldPattern);
        Matcher matcher = pattern.matcher(read);
        File newFile = new File(wright);
        if(!newFile.exists()){
            throw new FileNotFoundException(newFile.getName());
        }
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(newFile.getAbsoluteFile()));
            try{
                System.out.println(newPattern);
                out.write(matcher.replaceAll(newPattern));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(FILE_DIRECTORY));
        String currentFileString = "";
        while ((currentFileString = inputFileReader.readLine()) != null) {
            System.out.println(currentFileString + " - " + stringCheckResult(currentFileString));
        }
        inputFileReader.close();
        ///vdsvsdvsdvsdvds
    }

}
