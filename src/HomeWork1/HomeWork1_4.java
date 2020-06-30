package HomeWork1;

import java.util.Scanner;

public class HomeWork1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите день недели, 1 - 7");
        int dayOfWeek = scanner.nextInt();

        if(dayOfWeek < 1 || dayOfWeek > 7){
            System.out.println("Вы ввели неправильный день недели");
            return;
        }

        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        if(month < 1 || month > 12){
            System.out.println("Вы ввели неправильный номер месяца");
            return;
        }

        if (sleepIn1(isWeekDay(dayOfWeek), isVacationMonth(month))) {
            System.out.println("Можно спать");
        } else {
            System.out.println("Нужно вставать на работу");
        };

        System.out.println("Всего доброго");
        scanner.close();
    }

    /**
     * Возвращает признак рабочего/не рабочего дня
     * @param day номер дня
     * @return true - день рабочий, false - день не рабочий
     */
    public static boolean isWeekDay(int day){
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true; // перывве пять дней недели - рабочие
            case 6:
            case 7:
                return false; // оставшиеся два - выходные
        }
        return false;
    }

    /**
     * Возвращает признак отпуска/каторги
     * @param month номер месяца
     * @return true - отпуск, false - каторга
     */
    public static boolean isVacationMonth(int month){
        switch (month){
            case 8:
                return true; // считаем, что отпуск в августе
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 1:
            case 10:
            case 11:
            case 12:
                return false; // все остальные месяцы - рабочие
        }
        return false; // тут так не должно быть, это ошибка. разберёмся когда будем проходить EXCEPTION
    }

    /**
     * Отдаёт информацию можно ли дальше спать
     * @param weekday true - рабочий день, false - выходной
     * @param vacation true - отпуск, false - не отпуск
     * @return true - если можно спать, false - если пора вставать
     */
    public static boolean sleepIn1(boolean weekday, boolean vacation){
        if(!weekday || vacation){
            return true; // можно спать
        } else {
            return false; // нужно вставать
        }
    }

}