/*
1.5 Умножать число long a = 1; на 3 пока не произойдёт переполнение.
В конце в консоль вывести сообщение со значением до переполнения и после переполнения
 */

package HomeWork2;

public class HomeWork2_1_5 {
    public static void main(String[] args) {
        long a = 1L;
        long pred_a;
        int i = 0; // просто для интереса, посчитаем сколько раз выполнится цикл

        System.out.println("Начнём умножение на 3 переменной типа long.");

        do {
            pred_a = a; // запомним последнее нормальное значение "a"
            a = a * 3;
            i++;
        } while (pred_a < a);

        System.out.println("Цикл прошел " + i + " итераций.");
        System.out.println("Последнее (max) значение переменной \"а\" перед переполнением переменной типа long: ");
        System.out.println(pred_a);
        System.out.println("Переполненное значение переменной \"а\":");
        System.out.println(a);
    }
}
