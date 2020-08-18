package HomeWork7_Str;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RegExSearchMain {
    public static void main(String[] args) {
        String filePath = "d:/Java/WarAndPeace.txt";
        String book = readAllBytesJava7(filePath);
        RegExSearch regex = new RegExSearch();
        //String book = "Миру мир. Мирный, мир! Мир? Да, мир, и еще раз мир. Война - не мир.";
        //String book = "Миру мир. lfjsls sldjfjjfsl  csdslsdf  sжопа!";
        int c;
        
        System.out.println("Посчитаем количество слов \"война\", \"мир\" и союза \"и\" в романе \"Война и мир\" при помощи класса \"RegExSearch\":");
        
        c = regex.search(book, "война");
        System.out.println("Слово \"война\" встречается " + c + " раз");

        c = regex.search(book, "мир");
        System.out.println("Слово \"мир\" встречается " + c + " раз");

        c = regex.search(book, "и");
        System.out.println("Союз \"и\" встречается " + c + " раз");
        
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
