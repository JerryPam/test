
// пока не реализован метод вычисления корня из числа без использования библиотеки Math
// всё остальное выполнено и работает

package HomeWork5;

public class CalculatorWithOperator {

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
        double st = a;
        for (int i = 1; i < b; i++) {
            st = st * a;
        }
        return st;
    }

    public double modul(double a){ // модуль
        if (a < 0) return a * (-1);
          else return a;
    }




}
