package HomeWork1;

/*
Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main,
данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
В метод будет передаваться массив из 10 цифр (от 0 до 9). Данные цифры должны быть помещены
в строку формата: (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
возвращаемый результат: (123) 456-7890.
 */

public class HomeWork1_6 {
    public static void main(String[] args) {
        int[] n = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println("(" + n[0]+n[1]+n[2] + ") " + n[3]+n[4]+n[5] + "-" + n[6]+n[7]+n[8]+n[9]);

    }

    // public static String createPhoneNumber(int[] numbers); {

    //}

}
