/*
3. Написать класс с RandomString в котором будет один статический метод String random(int stringLength):
	3.1. Параметр метода это количество символов которые должно быть в строке
	3.2. Буквы в строке: Латиница, Кирилица, Пробел
 */

package HomeWork7;

import java.util.Random;

public class RandomString {

        static String random(int stringLength){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        StringBuilder sb = new StringBuilder(stringLength);
        Random random = new Random();
        for (int i = 0; i < stringLength; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        //System.out.println(output);
        return output;
    }

}
