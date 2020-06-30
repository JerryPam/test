package HomeWork1;

/*
Создать СТАТИЧЕСКИЙ метод createPhoneNumber рядом с методом main,
данный метод будет принимает один параметр и будет возвращать строку в отформатированном виде.
В метод будет передаваться массив из 10 цифр (от 0 до 9). Данные цифры должны быть помещены
в строку формата: (XXX) XXX-XXXX. Например передан массив: {1,2,3,4,5,6,7,8,9,0},
возвращаемый результат: (123) 456-7890.
 */
// ОТРАБОТКА МАССИВА (тренировка идеи)

public class HomeWork1_6_2 {
    public static void main(String[] args) {
        int[] n = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phone;

        String p0, p1, p2, p3, p4 , p5, p6, p7, p8, p9;
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


        //System.out.println("P0 = " + p0);
        System.out.println("Вывод через переменную String");
        System.out.println("(" + p0+p1+p2 + ") " + p3+p4+p5 + "-" + p6+p7+p8+p9);


        System.out.println("(" + n[0]+n[1]+n[2] + ") " + n[3]+n[4]+n[5] + "-" + n[6]+n[7]+n[8]+n[9]);

    }

    // public static String createPhoneNumber(int[] numbers); {

    //}

}
