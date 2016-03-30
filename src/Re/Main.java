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
import java.io.BufferedReader;

public class Main {

    public static String make(String name) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();
        File file = new File(name);
        if(!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
        try{
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try{
                String str;
                while ((str = in.readLine()) != null ){
                    builder.append(str);
                    builder.append("\n");
                    System.out.println(str);
                }
            } finally {
                in.close();
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    public static void task(String oldPattern, String newPattern, String read, String wright) throws FileNotFoundException{
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
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished");
    }

    public static void main(String[] args) throws IOException{
        String readFile = "C:\\Users\\Myself\\workspace\\Regular\\doc\\in";
        String wrightFile = "C:\\Users\\Myself\\workspace\\Regular\\doc\\out";
        String x= make(readFile);

    }

    private static final String FILE_DIRECTORY = "C:\\Users\\Myself\\workspace\\Regular\\doc\\in";

    protected static String stringCheckResult(String string) {
        Matcher patternMathcer = Pattern.compile("([A-Z][a-z]*)(\\ ?)([A-Z][a-z]*)(\\|)(-)(\\d+)(\\|)(\\+?)(\\s*)(\\d)(\\s*)(\\(?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\(?)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\s*)(\\d)(\\|)(\\w+)(@*)(@)(\\w+)", "$1\\$3$4$6$7$8$10\\ $22$24$26-$28-$30-$32_34$35$36$38$39", x, wrightFile);
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
        ///vdsvsdvsdvsdvdsefe
    }
*/
}
