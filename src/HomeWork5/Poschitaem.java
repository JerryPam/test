/*
Калькуляторы
 */

package HomeWork5;

public class Poschitaem {
    public static void main(String[] args) {
        CalculatorWithOperator calc1 = new CalculatorWithOperator();
        double res1;
        System.out.println("CalculatorWithOperator");

        res1 = calc1.sum(calc1.sum(4.1, calc1.umn(15,7)),calc1.stepen(calc1.del(28,5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5)^2 = " + res1);

        //double rez2 = 4.1 + 15 * 7 + (28 / 5);  // проверим себя
        //System.out.println("Проверка: " + rez2);

        //resultat1 = resultat1 / 0;
        res1 = calc1.del(res1, 0);
        System.out.println("Результат поделим на ноль: " + res1);
        /*
        На экране получили:
        Результат поделим на ноль: Infinity
        Т.е. при попытке поделить на ноль получили неопределённость типа "бесконечность"
         */

        res1 = calc1.del(res1, 0.0d);
        System.out.println("Результат поделим на 0.0d: " + res1);
        /*
        На экране получили:
        Результат поделим на ноль: Infinity
        Т.е. при попытке деления на дробное число типа double - также получаем неопределённость типа "бесконечность"
         */

        CalculatorWithMathCopy calc2 = new CalculatorWithMathCopy();
        double res2;
        System.out.println();
        System.out.println("CalculatorWithMathCopy");

        res2 = calc2.sum(calc2.sum(4.1, calc2.umn(15,7)),calc2.stepen(calc2.del(28,5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5)^2 = " + res2);

        //double rez2 = 4.1d + 15d * 7d + (28d / 5d) * (28d / 5d);  // проверим себя
        //System.out.println("Проверка: " + rez2);

        res2 = calc2.del(res2, 0);
        System.out.println("Результат поделим на ноль: " + res2);

        res2 = calc2.del(res2,0.0d);
        System.out.println("Результат поделим на 0.0d: " + res2);


        CalculatorWithMathExtends calc3 = new CalculatorWithMathExtends();
        double res3;
        System.out.println();
        System.out.println("CalculatorWithMathExtends");

        res3 = calc3.sum(calc3.sum(4.1, calc3.umn(15,7)),calc3.stepen(calc3.del(28,5), 2));
        System.out.println("4.1 + 15 * 7 + (28 / 5)^2 = " + res3);

        res3 = calc3.del(res3, 0);
        System.out.println("Результат поделим на ноль: " + res3);

        res3 = calc3.del(res3,0.0d);
        System.out.println("Результат поделим на 0.0d: " + res3);
    }
}
