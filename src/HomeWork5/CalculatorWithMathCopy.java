


package HomeWork5;

import java.lang.Math;

public class CalculatorWithMathCopy{

    public double sum(double a, double b){
        double summa = a + b;
        return summa;
    }

    public double razn(double a, double b){
        double c = a - b;
        return c;
    }

    public double umn(double a, double b){
        return a*b;
    }

    public double del(double a, double b){
        return a/b;
    }

    public double stepen(double a, int b){ // возведение в целую степень
        // вх параметры: а - число, b - степень
        return Math.pow(a, b);
    }

    public double modul(double a){ // модуль
        return Math.abs(a);
    }

    public double kor(double x){ // квадратный корень
        return Math.sqrt(x);
    }




}
