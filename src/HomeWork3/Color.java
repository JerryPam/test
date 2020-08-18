/*
2. Создать класс Color:
 2.0 Все поля должны быть приватными, все методы должны быть публичны, конструктор должен быть публичным.
 Статических методов быть не должно. Внимание никакой печати в консоль ВНУТРИ класса Color быть не должно.
 2.1 Создать конструктор который будет принимать параметр int. Туда мы будем передавать номер цвета.
 2.2 Внутри класса создать константы цветов радуги которые будут содержать номера цветов.
 Например RED = 1, ORANGE = 2;
 2.3 Создать методы getNumber() и getName(). Данные методы не принимают никаких парамаметров.
 2.4 Метод getNumber должен вернуть int (номер цвета который мы передали в конструктор).
 2.5 Метод getName должен возвращать (String) название цвета на русском,
 если цвет нам не известен возвращать строку "неизвестно" .
 2.6 В методе getName должен использоваться switch и константы объявленные при выполнении первого пункта,
 ЦИФР в свитче быть НЕ ДОЛЖНО БЫТЬ.
 */

package HomeWork3;

public class Color {
    private final int RED    = 1;
    private final int ORANGE = 2;
    private final int YELLOW = 3;
    private final int GREEN  = 4;
    private final int LIGHTBLUE = 5;
    private final int BLUE   = 6;
    private final int VIOLET = 7;

    private int num_color = 0; // переменная цвета внутри класса

    public Color(int a){
        num_color = a;
    } // конструктор, куда будет передаваться номер цвета

    public int getNumber() {
        return num_color;
    } // возвращает номер цвета, который мы передали в конструктор

    public String getName() {
        switch (num_color){
            case RED: return "Красный";
            case ORANGE: return "Оранжевый";
            case YELLOW: return "Жёлтый";
            case GREEN: return "Зелёный";
            case LIGHTBLUE: return "Голубой";
            case BLUE: return "Синий";
            case VIOLET: return "Фиолетовый";
            default: return "неизвестно";
        }
    } // возвращает название цвета на русском. Если цвет неизвестен, возвращать "неизвестно".

}
