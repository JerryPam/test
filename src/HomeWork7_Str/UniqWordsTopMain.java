package HomeWork7_Str;

/*
6. В книге "Война и мир" найти все уникальные слова и поместить их в коллекцию используя Set. Знаки препинания, пробелы и 
переводы строк - это не слова.
7. В книге "Война и мир" найти топ 10 слов и вывести количество количество этих слов используя Map. Отсортировать по 
количеству. Распечатать в консоль. Пример: Война - 200 раз, Мир - 100 раз и так далее. Знаки препинания, пробелы и переводы 
строк - это не слова.
*/
//package HomeWork7_Str;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;


public class UniqWordsTopMain {
    public static void main(String[] args){
        String filePath = "d:/Java/WarAndPeace.txt";
        String book = readAllBytesJava7(filePath);

        //String book = "Миру мир.. Мирный,     мир! Мир? Да, мир, и еще раз мир. Война - не мир.  и раз и два ! -ff dfdf f-";

        //System.out.println("Исходная строка:");
        //System.out.println(book);

        book = book.toLowerCase(); // все слова приведём в нижний регистр
        // далее все ненужные символы заменим пробелами
        book = book.replaceAll("\\.+"," ");
        book = book.replaceAll("\\,+"," ");
        book = book.replaceAll("\\!+"," ");
        book = book.replaceAll("\\?+"," ");
        book = book.replaceAll("\\-\\-"," "); // двойное тире
        book = book.replaceAll(" \\- "," ");// тире с двумя пробелами по бокам
        book = book.replaceAll(" \\-"," "); // тире с пробелом впереди
        book = book.replaceAll("\\- "," "); // тире с пробелом после себя
        book = book.replaceAll("\\:"," ");
        book = book.replaceAll("\\;"," ");
        book = book.replaceAll("\""," ");
        book = book.replaceAll("\'"," ");
        book = book.replaceAll("\n"," ");
        book = book.replaceAll("\r"," ");
        book = book.replaceAll("\t"," ");
        book = book.replaceAll(" +"," "); // после всех замен ужимаем пробелы, до одного между словами
        // оставшийся набор букв между пробелами считаем словами
        // создадим массив из слов
        //System.out.println("Нормализованная строка:");
        //System.out.println(book);

        String[] allWords;
        String delimeter = " "; // Разделитель
        allWords = book.split(delimeter); //создадим массив слов
/*
        System.out.println("Массив всех слов:");
        for(int i = 0; i < allWords.length; i++) {
            System.out.print(allWords[i] + " "); // массив слов
        }
*/
        List<String> listWords = new ArrayList<>(); // список всех слов

        for (int i = 0; i < allWords.length; i++) {
            listWords.add(allWords[i]);
        }

        Set<String> uWords = new HashSet<>(listWords); // создадим список уникальных слов

        Iterator iter = uWords.iterator();
        /*
        System.out.println();
        System.out.println("Список уникальных слов:");

        Iterator iter = uWords.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
*/
        // создадим список Мар, с парой ключ-значение
        // где ключ - слово, значение - количество этого слова в строке
        HashMap<String, Integer> countWords = new HashMap<>();
        iter = uWords.iterator();
        while (iter.hasNext()){
            countWords.put(String.valueOf(iter.next()), 0); // почему iter.next() не String?
        }

/*        //iter = uWords.iterator();
        System.out.println();
        System.out.println("Массив Map:");

        for (Map.Entry entry : countWords.entrySet()) {
            System.out.println("Key: " + entry.getKey() + "   Value: "
                    + entry.getValue());
        }
*/

        int value = 0;
        for(int i = 0; i < allWords.length; i++) {
            // Заполним список Мар значениеми (посчитаем количество каждого слова)
            value = countWords.get(allWords[i]);
            countWords.put(allWords[i], value + 1); 
        }
/*
        System.out.println();
        System.out.println("Массив Map после подсчёта количества слов:");

        for (Map.Entry entry : countWords.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }
*/
        // Выполним сортировку списка по значаениям
        List list = new ArrayList(countWords.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
        
            @Override
        public int compare(Entry<String, Integer> a, Entry<String, Integer> b) {
            return b.getValue() - a.getValue();
        }
        });
        
        System.out.println();
        System.out.println("ТОП 10 слов из романа \"Война и мир\": ");

        for(int i = 0; i< 10; i++) {
            System.out.println(list.get(i));
        }
    }

        private static String readAllBytesJava7(String filePath) {
        String content = "";
        try {
            content = new String (Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
        }

}
