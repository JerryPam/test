package HomeWork1;

/*
Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main,
данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
В метод будет передаваться массив из 10 цифр (от 0 до 9). Данные цифры должны быть помещены
в строку формата: (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
возвращаемый результат: (123) 456-7890.
 */
// ИТОГОВАЯ РЕАЛИЗАЦИЯ с методом createPhoneNumber (если я правильно понял смысл задачи)

public class HomeWork1_6_3 {
    public static void main(String[] args) {
        int[] mas = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        System.out.println(createPhoneNumber(mas));

    }

    public static String createPhoneNumber(int[] n){

        String p0, p1, p2, p3, p4 , p5, p6, p7, p8, p9;
        String phone; // для формирования возвращаемой строки

        p0 = Integer.toString(n[0]); // нельзя ли здесь было Integer преобразовать в Char?
        p1 = Integer.toString(n[1]); // если нельзя преобразовать int в char,
        p2 = Integer.toString(n[2]); // то заводим ряд переменных String
        p3 = Integer.toString(n[3]); // чтобы ими удобно было в дальнейшем оперировать
        p4 = Integer.toString(n[4]);
        p5 = Integer.toString(n[5]);
        p6 = Integer.toString(n[6]);
        p7 = Integer.toString(n[7]);
        p8 = Integer.toString(n[8]);
        p9 = Integer.toString(n[9]);

        phone = "(" + p0+p1+p2 + ") " + p3+p4+p5 + "-" + p6+p7+p8+p9;
        return phone;
    }

}
