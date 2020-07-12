/*
4.1.2 проверка контрольной суммы программы ПЗУ
 */

package HomeWork3;

import java.util.Random;

public class PZU extends Equipment {

    @Override
    public String getMessage() {
        if (test_result == false & count_start == 0) {
            Random random = new Random(); // для формирования кода ошибки
            int error_code = random.nextInt(1000) + 1; // код ошибки не может быть нулевым, ноль - это нет ошибок
            Mes = "Ошибка при выполнении теста программы ПЗУ \n" + "Код ошибки " + error_code;
            return Mes;
        } else if (test_result == true & count_start == 0) {
            Mes = "Тест программы ПЗУ пройден успешно";
            return Mes;
        } else if (test_result == true & count_start == 1 & run_result == false) {
            Mes = "Ошибка запуска программы ПЗУ";
            return Mes;
        } else {
            Mes = "Программа ПЗУ успешно запущена";
            return Mes;
        }
    }
}
