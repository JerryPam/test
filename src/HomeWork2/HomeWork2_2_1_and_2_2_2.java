/*
2.1 Вывести все элементы в консоль при помощи do....while, while, for, foreach.
Элементы массива вводить через консоль. Массив хранит в себе числа.
2.2 Вывести каждый второй элемент массива
 */
package HomeWork2;

import java.util.Scanner;

public class HomeWork2_2_1_and_2_2_2 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = scan1.nextInt();
        int i;
        if (n > 0) {
            // тело основного ядра программы
            int[] arr; // массив для цифр введённого числа
            arr = new int[n];
            for (i = 0; i < n; i++) {
                // заполним массив
                System.out.print("Введите элемент " + (i+1) + ": ");
                arr[i] = scan1.nextInt();
            }

            System.out.println();
            System.out.println("Вывод массива при помощи цикла for:");
            for (i = 0; i < n; i++) {
                // выведем массив
                System.out.print(arr[i] + " ");
            }

            System.out.println();
            System.out.println("Вывод массива при помощи цикла while:");
            i = 0;
            while (i < n) {
                System.out.print(arr[i] + " ");
                i++;
            }

            System.out.println();
            System.out.println("Вывод массива при помощи цикла do while:");
            i = 0;
            do {
                System.out.print(arr[i] + " ");
                i++;
            } while (i < n);

            System.out.println();
            System.out.println("Вывод массива при помощи цикла foreach:");
            for (int a :arr) {
                System.out.print(a + " ");
            }

            /*
            Задача 2.2 Вывести каждый второй элемент массива
             */

            System.out.println();
            if (n == 1) { // Если в массиве только один элемент
                System.out.println("Вывод каждого второго элемента невозможен, т.к. в массиве только один элемент");
            } else { // Если в массиве два элемента и более
                System.out.println("Вывод каждого второго элемента массива:");
                i = 1;
                do {
                    System.out.print(arr[i] + " ");
                    i = i + 2; // вывод каждого второго элемента
                } while (i < n);
            }

        } else {
            System.out.println("Количество элементов массива не может быть отрицательным или нулевым");
        }

    }
}
