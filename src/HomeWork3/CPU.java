/*
 4.1.1 центральный процессор.
 */
package HomeWork3;

import java.util.Random;

public class CPU extends Equipment{
    // метод, вовзращающий сообщение от оборудования
    public String getMessage() {
        if (test_result == false & count_start == 0) { // если тест не пройден и попыток запуска оборудования еще не было
            Random random = new Random(); // для формирования кода ошибки
            int error_code = random.nextInt(1000) + 1; // код ошибки не может быть нулевым, ноль - это нет ошибок
            Mes = "Ошибка при выполнении теста ЦПУ \n" + "Код ошибки " + error_code;
            return Mes;
        } else if (test_result == true & count_start == 0) {
            Mes = "Тест ЦПУ пройден успешно";
            return Mes;
        } else if (test_result == true & count_start == 1 & run_result == false) {
            Mes = "Ошибка запуска ЦПУ";
            return Mes;
        } else {
            Mes = "ЦПУ успешно запущено";
            return Mes;
        }
    }
}