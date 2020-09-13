package HomeWork7_Str;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EasySearchMain {
    public static void main(String[] args) {
        String filePath = "d:/Java/WarAndPeace.txt";
        String test_book = readAllBytesJava7(filePath);
        EasySearch es = new EasySearch();
        //String test_book = "Миру мир. Мирный, мир! Мир? Да, мир, и еще раз мир. Война - не мир.";
        int count;

        count = es.search(test_book, "война");
        System.out.println("Слово \"война\" встречается " + count + " раз");

        count = es.search(test_book, "мир");
        System.out.println("Слово \"мир\" встречается " + count + " раз");

        count = es.search(test_book, "и");
        System.out.println("Союз \"и\" встречается " + count + " раз");

    }


    private static String readAllBytesJava7(String filePath)
    {
        String content = "";
        try {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
