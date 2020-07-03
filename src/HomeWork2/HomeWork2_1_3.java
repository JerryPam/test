/*
 1.3. Все цифры из числа введенного через аргумент к исполняемой программе перемножить между собой
 и вывести ход вычислений в консоль. Пример: Ввели 181232375, 1 * 8 * 1 * 2 * …. * 5 = ответ
*/
package HomeWork2;
import java.util.Scanner;

public class HomeWork2_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = scanner.nextInt();
        int c = a; // временная переменная для операций над полученным числом
        int n = 0; // счётчик разрядов введённого числа
        int proizved = 1;  // единица, чтобы при первоначальном умжножении не влиять на результат

        while (c > 0) { // определим количество разрядов введённого числа
            c = c / 10;
            n++;
        }
        c = a; // восстановим "с"

        // System.out.println("В числе " + n + " разрядов");  // для отладки
        int[] num_r; // массив для цифр введённого числа
        num_r = new int[n];
        System.out.println();

        int i;
        for (i=0; i < n; i++) { // заполним наш массив цифрами введенного числа
            num_r[i] = c % 10;
            c = c / 10;
            // System.out.print(num_r[i] + " "); // для отладки2
        }
        // System.out.println(); // при отладке

        for (i=n-1; i >= 0 ; i--) { // выведем цифры числа, начиная со старшего разряда (как указано в задаче)
            proizved = proizved * num_r[i]; // одновременно посчитаем произведение
            if (i > 0) {
                System.out.print(num_r[i] + " + ");
            } else {
                System.out.print(num_r[i] + " = " + proizved);
            }
        }
    }
}
