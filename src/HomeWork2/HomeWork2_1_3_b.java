/*
 1.3. Все цифры из числа введенного через аргумент к исполняемой программе 
перемножить между собой и вывести ход вычислений в консоль. 
Пример: Ввели 181232375, 1 * 8 * 1 * 2 * …. * 5 = ответ
*/
package HomeWork2;
import java.util.Scanner;


public class HomeWork2_1_3_b {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = scanner.nextInt();
        System.out.println("Введено число " + a);
 
        int x = a; 
        int r; // цифра первого или предыдущего разряда
        //int r2; // цифра очередного разряда
        int y = 0; // результат от перемноженных цифр числа
        //int i = 1; // счётчик разрядов
        
        r = x % 10; // выделим первую цифру от числа
        x = x / 10; // целый остаток от очередного деления на 10
        y = r;
        
        if (x == 0){ // если у числа только один разряд (одна цифра)
            // печатаем эту цифру и завершаем работу программы
            System.out.println("Число содержит только одну цифру " + r);
            System.out.println("Перемножать нечего");
        }
        else { // если разрядов больше одного, то запускаем цикл
            while (x > 0){ 
              r = x % 10; // выделим очередную цифру от числа
              x = x / 10; // целое от очередного деления на 10
              y = y * r;  // произведение предыдущих цифр и очередной цифры
              System.out.println("Очередной шаг: y=y*r; y= " + y + " r= " + r);
              //i++;  
            }
            System.out.println("Результат перемножения равен " + y);
        }
    }    
    
}