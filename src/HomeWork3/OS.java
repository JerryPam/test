/*
 Операционная система
 */
package HomeWork3;

import java.util.Random;

public class OS {

    Random random = new Random(); // для формирования кода ошибки
    int error_code;

    // метод запуска операционной системы:
    // если запуск ОС успешен, код ошибки будет равен нулю
    // в любом другом случае запуск ОС считается неудачным
    int run() {
        int chance = random.nextInt(10);
        if (chance < 5) { // "подкрутим" вероятность на 50% успешного запуска ОС
            error_code = 0;
        } else {
            error_code = random.nextInt(1000); // сформируем код воображаемой ошибки при загрузке ОС
        }
        return error_code;
    }
}