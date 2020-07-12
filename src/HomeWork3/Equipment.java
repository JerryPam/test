package HomeWork3;

import java.util.Random;

public class Equipment implements IHard {
    // общий класс оборудования,
    // в котором предусмотрим дополнительный метод getMessage()
    // для получения сообщения от оборудования и кода ошибки при неудачном тесте

    //String Equip = ""; // в классах потомках здесь пропишем наименования оборудования
    int count_start = 0; // количество попыток запуска оборудования
    boolean test_result = true; // результат прохода теста
    // по умолчанию выставим в true, подразумевая, что тест прошёл успешно

    boolean run_result = true; // результат запуска оборудования

    @Override
    public boolean test(){ // запуск и выполнение теста
        if (test_result == true) return true;
        else return false;
    }

    @Override
    public boolean run() { // попытка запуска оборудования
        count_start++;
        if (test_result == false ) return false; // пока не пройдем тест, запуск невозможен
        else { //run_result = true; // иначе, можем попробовать запустить оборудование: предполагаем, что запустили
            if (run_result == true) return true; // если запустили - возвращаем true
            else return false;
        }
    }
    String Mes = new String(); // строка для формирования сообщения от оборудования

    // метод, вовзращающий сообщение от оборудования
    public String getMessage() {
        if (test_result == false & count_start == 0) { // если тест не пройден и попыток запуска оборудования еще не было
            Random random = new Random(); // для формирования кода ошибки
            int error_code = random.nextInt(1000) + 1; // код ошибки не может быть нулевым, ноль - это нет ошибок
            Mes = "Ошибка при выполнении теста оборудования \n" + "Код ошибки " + error_code;
            return Mes;
        } else if (test_result == true & count_start == 0) {
            Mes = "Тест оборудования пройден успешно";
            return Mes;
        } else if (test_result == true & count_start == 1 & run_result == false) {
            Mes = "Ошибка запуска оборудования";
            return Mes;
        } else {
            Mes = "Оборудование успешно запущено";
            return Mes;
        }
    }
}
