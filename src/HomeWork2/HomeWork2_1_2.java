/*
 1.2. Перемножить числа от 1 до числа (включительно) введенного через аргумент 
к исполняемой программе. Пример: Ввели 5, 
должно получиться 1 * 2 * 3 * 4 * 5 = ответ
*/
package HomeWork2;
import java.util.Scanner;

public class HomeWork2_1_2 {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int a = scanner.nextInt(); 
        int x = 1; 
        int i; 
        
        for (i = 1; i <= a; i++){ // посчитаем ответ
            x = x * i;
        }
        
        for (i = 1; i <= a; i++){ // сформируем вывод операндов и результата
            if (i < a){
                System.out.print(i + " * ");
            } else {
                System.out.print(i + " = " + x);
            }   
        }
        System.out.println(" ");
    }    
    
}
