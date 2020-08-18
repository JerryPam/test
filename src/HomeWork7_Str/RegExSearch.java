/*
2. Написать интерфейс ISearchEngine. Это будет функциональный интерфейс 
в котором будет метод search который будет принимать два параметра 
(строку в котором мы ищем наше слово (книга), слово которое мы будем в нём искать), 
а возвращать число (количество найденных совпадений).
 4*. Написать класс RegExSearch реализующий интерфейс ISearchEngine. 
Реализовать поиск по строкам при помощи класса Matcher.
 */

package HomeWork7_Str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSearch implements ISearchEngine {
    public int search(String book, String search_word){
        // И текст и переданное слово для поиска приведём в нижный регистр
        // Ищем слово, а не выхождение выражения в слово, 
        // поэтому искомое слово отделим пробелами и будем искать слово между пробелами
        search_word = " " + search_word.toLowerCase() + " "; 
        book = book.toLowerCase();
        int count_words = 0; // количество найденных вхождений искомого слова (выражения)

        // все ненужные символы заменим пробелами
        // необходимо для корректного поиска союза "и", который ищем по выражению " и "
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
        // после всех замен ужимаем пробелы, до одного между словами (делать это необязательно, корректность работы метода не влияет)
        book = book.replaceAll(" +"," "); 
        
        
        String input = book;
        Pattern pattern = Pattern.compile(search_word);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) count_words++;
        return count_words;
    }
}
