/*
4.1.3 первые 64 байта ОЗУ (для рагрузки резидентных программ)
 */

package HomeWork3;

import java.util.Random;

public class RezidentOZU extends Equipment {

    @Override
    public String getMessage() {
        if (test_result == false & count_start == 0) {
            Random random = new Random(); // для формирования кода ошибки
            int error_code = random.nextInt(1000) + 1; // код ошибки не может быть нулевым, ноль - это нет ошибок
            Mes = "Ошибка при выполнении теста памяти ОЗУ для резидентных программ \n" + "Код ошибки " + error_code;
            return Mes;
        } else if (test_result == true & count_start == 0) {
            Mes = "Тест памяти ОЗУ для резидентных программ пройден успешно";
            return Mes;
        } else if (test_result == true & count_start == 1 & run_result == false) {
            Mes = "Ошибка памяти ОЗУ для резидентных программ";
            return Mes;
        } else {
            Mes = "Память ОЗУ для резидентных программ доступна";
            return Mes;
        }
    }
}
