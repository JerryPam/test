package HomeWork7_Str;

public class EasySearch implements ISearchEngine{
    public int search(String book, String search_word){
        // В метод передаём слово для поиска в нижнем регистре.
        // Весь текст также приведём в нижний регистр.
        String book_low = book.toLowerCase();

        int count_words = 0; // количество найденных вхождений искомого слова (выражения)
        int num_pos; // номер позиции найденного слова в book

        /*
        int num_pos = 0; // номер позиции найденного слова в book
        String str = search_word;
        do {
            num_pos = book_Lower.indexOf(str, num_pos);
            if (num_pos > -1) count_words++;
        } while (num_pos < book_Lower.length() - search_word.length());
 */
        // проверяем вхождение слова, которое начинается пробелом и 
        // оканчивается на пробел ,.!?
        // 
        String str = search_word;
        num_pos = 0;
        num_pos = book_low.indexOf(str, 0);
        // проверим наличие искомого слова буквально с первой позиции (частный случай)
        // вначале текста возможен вариант, что слово будет прямо с первого символа строки
        if (book_low.indexOf(str + " ", 0) == 0) count_words = 1;
        else if (book_low.indexOf(str + ",", 0) == 0) count_words = 1;
        else if (book_low.indexOf(str + ".", 0) == 0) count_words = 1;
        else if (book_low.indexOf(str + "!", 0) == 0) count_words = 1;
        else if (book_low.indexOf(str + "?", 0) == 0) count_words = 1;
        
        else if (book_low.indexOf(str + ":", 0) == 0) count_words = 1;
        else if (book_low.indexOf(str + ";", 0) == 0) count_words = 1;
        //на закрывающую скобку и кавычку в конце искомого слово не проверяю,
        // т.к. при этих символах по логике будет открывающая скобка и кавычка вначале слова, 
        // а это уже проверяется в циклах ниже
        
        // далее проверяем искомое слово уже по всему тексту
        
        char[] first = {' ', '"', '(',    '\\', '\'', '\t', '-'}; // первыве символы для подстановки к слову
        char[] last  = {' ', '.', ',', '!', '?', ')', '"', ':', ';',    '\n', '\t', '\\', '\'', '-'}; // последние символы для подстановки к слову
        
        for(int i = 0; i < first.length; i++) {
            for (int j = 0; j < last.length; j++) {
            str = first[i] + search_word + last[j];
            num_pos = 1; // 1, чтобы искали с символа №1, т.к. с символа №0 проверяли вначале, в отдельном условии  (частный случай)
                do {
                    num_pos = book_low.indexOf(str, num_pos);
                    if (num_pos > -1) {
                        count_words++;
                        num_pos = num_pos + str.length();
                    }
                } while (num_pos < book_low.length() - str.length() & num_pos > -1);
            
            }
        }
        //num_pos = book_low.
/*
        num_pos = 1;
        String str1 = " " + search_word + " ";
        do {
            num_pos = book_low.indexOf(str1, num_pos);
            if (num_pos > -1) {
                count_words++;
                num_pos = num_pos + str1.length();
            }
        } while (num_pos < book_low.length() - str1.length() & num_pos > -1);

        num_pos = 1;
        String str2 = " " + search_word + ",";
        do {
            num_pos = book_low.indexOf(str2, num_pos);
            if (num_pos > -1) {
                count_words++;
                num_pos = num_pos + str2.length();
            }
        } while (num_pos < book_low.length() - str2.length() & num_pos > -1);

        num_pos = 1;
        String str3 = " " + search_word + ".";
        do {
            num_pos = book_low.indexOf(str3, num_pos);
            if (num_pos > -1) {
                count_words++;
                num_pos = num_pos + str3.length();
            }
        } while (num_pos < book_low.length() - str3.length() & num_pos > -1);

        num_pos = 1;
        String str4 = " " + search_word + "!";
        do {
            num_pos = book_low.indexOf(str4, num_pos);
            if (num_pos > -1) {
                count_words++;
                num_pos = num_pos + str4.length();
            }
        } while (num_pos < book_low.length() - str4.length() & num_pos > -1);

        num_pos = 1;
        String str5 = " " + search_word + "?";
        do {
            num_pos = book_low.indexOf(str5, num_pos);
            if (num_pos > -1) {
                count_words++;
                num_pos = num_pos + str5.length();
            }
        } while (num_pos < book_low.length() - str5.length() & num_pos > -1);
*/
        return count_words;
        
    }
     
}
