/*
2.1 Вывести все элементы в консоль при помощи do....while, while, for, foreach.
Элементы массива вводить через консоль. Массив хранит в себе числа.
2.2 Вывести каждый второй элемент массива
 */
package HomeWork2;

import java.util.Scanner;

public class HomeWork2_3 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan1.nextInt();
        int i; // счётчик цикла

        if (n > 1) { //если количество элементов больше одного
            // тело основного ядра программы
            int[] arr; // массив для цифр введённого числа
            arr = new int[n];
            for (i = 0; i < n; i++) {
                // заполним массив через консоль
                System.out.print("Введите элемент " + (i+1) + ": ");
                arr[i] = scan1.nextInt();
            }

            System.out.println();
            System.out.println("Вы ввели массив: ");
            for (i = 0; i < n; i++) {
                // выведем массив
                System.out.print(arr[i] + " ");
            }

            // непосредственно пузырьковая сортировка
            // т.е. максимальный элемент, найденный в массиве при текущем проходе,
            // "выталкиваем" на место последнего элемента массива
            // далее опять проходим весь массив от первого элемента уже до предпоследнего
            // и на место предпоследнего записываем максимальный найденный и т.д.,
            // т.е. формируем упорядоченный массив по возрастанию

            int n2 = n - 1; // кол-во итераций для очередного прохода сортировки. После каждого прохода уменьшается на 1.
            int j;
            int s; // промежуточная переменная для цикла сортировки

            for (i = 0; i < n - 1; i++) { // кол-во проходов по массиву
                for (j = 0; j < n2; j++) { // непосредственно сама сортировка
                   if (arr[j] > arr[j+1]) {
                       s = arr[j+1];
                       arr[j+1] = arr[j];
                       arr[j] = s;
                   }
                }
                n2 = n2 - 1;
            }

            System.out.println();
            System.out.println("Отсортированный массив: ");
            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }

        } else if (n == 1) { // если ввели только один элемент массива
            int[] arr; // массив для цифр введённого числа
            arr = new int[1];
            System.out.print("Введите элемент 1: ");
            arr[0] = scan1.nextInt();
            System.out.println("Вы ввели массив: " + arr[0]);
            System.out.println("В массиве только один элемент. Нечего сортировать");
        } else { // если ввели отрицательное или нулевое количество элементов
            System.out.println("Количество элементов массива не может быть отрицательным или нулевым");
        }

    }
}