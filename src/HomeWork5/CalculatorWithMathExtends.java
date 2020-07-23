package HomeWork5;

import java.lang.Math;

public class CalculatorWithMathExtends extends CalculatorWithOperator{


        // вх параметры: а - число, b - степень
        public double stepen(double a, double b){ // возведение в целую степень
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
