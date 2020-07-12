/*
 4.1.4 контроллер графического адаптера
 */
package HomeWork3;

import java.util.Random;

public class CGAdapter extends Equipment{
    // метод, вовзращающий сообщение от оборудования
    public String getMessage() {
        if (test_result == false & count_start == 0) { // если тест не пройден и попыток запуска оборудования еще не было
            Random random = new Random(); // для формирования кода ошибки
            int error_code = random.nextInt(1000) + 1; // код ошибки не может быть нулевым, ноль - это нет ошибок
            Mes = "Ошибка при выполнении теста контроллера графического адаптера \n" + "Код ошибки " + error_code;
            return Mes;
        } else if (test_result == true & count_start == 0) {
            Mes = "Тест контроллера графического адаптера пройден успешно";
            return Mes;
        } else if (test_result == true & count_start == 1 & run_result == false) {
            Mes = "Ошибка запуска контроллера графического адаптера";
            return Mes;
        } else {
            Mes = "Контроллер графического адаптера успешно запущен";
            return Mes;
        }
    }
}