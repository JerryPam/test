package HomeWork1;
import java.util.Scanner;
/*
 5.2 Если имя будет равно имени Вася тогда в консоль должно вывести сообщение
"Привет!" на одной строке, а на второй "Я тебя так долго ждал".
 5.3 Если имя будет равно имени "Анастасия" тогда в консоль должно вывести сообщение
 "Я тебя так долго ждал".
 5.4 В случае если это будет другое имя то вывести сообщение
 "Добрый день, а вы кто?".
 Реализация при помощи switch
 */

public class HomeWork1_5_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = sc.next();

        switch (name){
            case "Вася":
                System.out.println("Привет!");
                System.out.println("Я тебя так долго ждал");
                break;
            case "Анастасия":
                System.out.println("Я тебя так долго ждал");
                break;
            default:
                System.out.println("Добрый день, а вы кто?");
                break;
        }
/*
        if (name.equals("Вася")) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал");
        };

        if (name.equals("Анастасия")){
            System.out.println("Я тебя так долго ждал");
        };
        if (!name.equals("Вася") && !name.equals("Анастасия")){
            System.out.println("Добрый день, а вы кто?");
        }
*/
    }


}
