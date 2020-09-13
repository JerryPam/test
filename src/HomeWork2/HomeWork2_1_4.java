/*
1.4. Возведение в степень. Через консоль пользователь вводит два числа.
Первое число это число которое мы будем возводить,
Второе число это степень в которую возводят первое число
 */

package HomeWork2;
import java.util.Scanner;

public class HomeWork2_1_4 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Будем возводить число в степень.");
        System.out.println("Введите число: ");
        int x = scan1.nextInt();
        System.out.println("Введите степень: ");
        int st = scan2.nextInt(); // пока не догоняю, как работает этот Scanner. можно ли работать через один объект или нужно два, как в данном случае. Создал два, всё работает. Пока так и оставил. Надеюсь при прохождении "объектов" всё дойдёт.
        int i;
        int res = 1;

        if (x == 0) { // для предотвращения деления на ноль, если будет задана отрицательная степень
            System.out.println("Число " + 0 + " в степени " + st + " = 0" );
        } else if (st == 0) {
            System.out.println("Число " + x + " в степени " + st + " = 1" );
        } else if (st == 1) {
            System.out.println("Число " + x + " в степени " + st + " = " + x);
        } else if (st > 1) { // если степень больше 1
            res = x;
            for (i=2; i <= st; i++) {
                res = res * x;
            }
            System.out.println("Число " + x + " в степени " + st + " = " + res);
        } else if (st < 0) { // если степень отрицательная
            // System.out.println("Отрицательная степень"); // отладка
            st = st * (-1); // восстановим положительную величину st для цикла
            for (i=1; i <= st; i++) {
                res = res * x;
            }
            float res2;
            res2 = 1 / (float)res;
            System.out.println("Число " + x + " в степени -" + st + " = " + res2);
        }
    }
}
