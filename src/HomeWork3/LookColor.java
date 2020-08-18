/*
3. В отдельном классе, создать мэйн метод. Внутри данного метода создать экземпляр Color.
В конструктор передать число 3. Далее вывести в консоль номер цвета и его названия
используя результат выполнения методов getNumber и getName.
 */

package HomeWork3;

public class LookColor {
    public static void main(String[] args) {
        Color A = new Color(3);
        System.out.println(A.getNumber());
        System.out.println(A.getName());
    }
}
