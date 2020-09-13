/*
1. По заданному массиву найдите число, которое встречается нечетное количество раз
(Всегда будет только одно число, которое встречается нечетное количество раз)
(взято с https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java):
 1.1. {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}
 1.2. {1,1,2,-2,5,2,4,4,-1,-2,5}
 1.3. {20,1,1,2,2,3,3,5,5,4,20,4,5}
 1.4. {10}
 1.5. {1,1,1,1,1,1,10,1,1,1,1}
 1.6. {5,4,3,2,1,5,4,3,2,10,10}
 */
package HomeWork3;

public class HomeWork_3_1 {
    public static void main(String[] args) {

        int[] arr = {20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        serch_element(arr);
        int[] arr2 = {1,1,2,-2,5,2,4,4,-1,-2,5};
        serch_element(arr2);
        int[] arr3 = {20,1,1,2,2,3,3,5,5,4,20,4,5};
        serch_element(arr3);
        int[] arr4 = {10};
        serch_element(arr4);
        int[] arr5 = {1,1,1,1,1,1,10,1,1,1,1};
        serch_element(arr5);
        int[] arr6 = {5,4,3,2,1,5,4,3,2,10,10};
        serch_element(arr6);
        //int[] arr7 = {}; // зададим ноль элементов массива
        //serch_element(arr7);
    }

    public static void serch_element(int[] arr) {

        int n; // кол-во элементов массива
        n = arr.length;
        int i, j; // счётчики цикла
        int count; // колчество вхождений элемента в массив
        int finded_element = 0; // искомое число массива
        boolean pr_finded = false; // признак того, что нужное число найдено

        if (n > 0) { //если количество элементов больше одного
            System.out.println();
            System.out.println("Вы ввели массив: ");
            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            for (i = 0; i < n; i++) {
                count = 0;
                for (j = 0; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++; // количество данного числа в массиве
                    }
                }
                if (!(count%2 == 0)) { // если число входило в массив нечётное количество раз
                    finded_element = arr[i]; // запомним это число
                    pr_finded = true;
                    break;
                }
            }
            if (pr_finded) {
                System.out.println("Нечётное число раз в массиве встречается число \"" + finded_element + "\"");
            } else {
                System.out.println("В массиве нет искомого числа. Ошибка входных данных.");
            }
        }
        else { // если в массиве нет элементов
            System.out.println("В массиве нет элементов для поиска");
        }

    }
}
