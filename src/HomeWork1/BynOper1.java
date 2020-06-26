package HomeWork1;

public class BynOper1 {
    public static void main(String[] args) {
        int a = 42;
        int b = 15;
        int res = 0; 


        System.out.println("Исходные числа:");

        System.out.println(" 42 = " + Integer.toBinaryString(a));
        System.out.println(" 15 = 00" + Integer.toBinaryString(b));
        System.out.println(" ");

        System.out.println("Операции с числами:");

        res = a | b;
        System.out.println("42 | 15 = " + Integer.toBinaryString(res));

        res = a & b;
        System.out.println("42 & 15 = " + Integer.toBinaryString(res));

        res = a ^ b;
        System.out.println("42 ^ 15 = " + Integer.toBinaryString(res));

        System.out.println("Инвертирование всех битов операнда:");
        System.out.println("~42 = " + Integer.toBinaryString(~a));
        System.out.println("~15 = " + Integer.toBinaryString(~b));

        System.out.println("Сдвиг на один бит влево:");
        System.out.println("42<< = " + Integer.toBinaryString(a<<1));
        System.out.println("15<< = " + Integer.toBinaryString(b<<1));

        System.out.println("Сдвиг на один бит влево с присваиванием:");
        System.out.println("42<<= = " + Integer.toBinaryString(a<<=1));
        System.out.println("15<<= = " + Integer.toBinaryString(b<<=1));
        
        System.out.println("Сдвиг на один бит вправо:");
        System.out.println("42>> = " + Integer.toBinaryString(a>>1));
        System.out.println("15>> = " + Integer.toBinaryString(b>>1));
        // В позицию старшего бита вставляется предыдущее значение старшего бита
        
        System.out.println("Сдвиг вправо без учета знака:");
        System.out.println("42>>> = " + Integer.toBinaryString(a>>>1));
        System.out.println("15>>> = " + Integer.toBinaryString(b>>>1));
        // При здвиге вправо в позицию старшего бита вставляется ноль

        System.out.println("Сдвиг вправо с заполнением нулями и присваиванием:");
        System.out.println("42>>>= = " + Integer.toBinaryString(a>>>=1));
        System.out.println("15>>>= = " + Integer.toBinaryString(b>>>=1));
        
        // Операции с отрицательными числами
        System.out.println(" ");
        System.out.println("*********************************");
        System.out.println("ОПЕРАЦИИ С ОТРИЦАТЕЛЬНЫМИ ЧИСЛАМИ");
        System.out.println("*********************************");
        System.out.println(" ");
        
        a = -42;
        b = -15;
        
        System.out.println("Исходные числа:");

        System.out.println("-42 = " + Integer.toBinaryString(a));
        System.out.println("-15 = 00" + Integer.toBinaryString(b));
        System.out.println(" ");

        System.out.println("Операции с числами:");

        res = a | b;
        System.out.println("-42 | -15 = " + Integer.toBinaryString(res));

        res = a & b;
        System.out.println("-42 & -15 = " + Integer.toBinaryString(res));

        res = a ^ b;
        System.out.println("-42 ^ -15 = " + Integer.toBinaryString(res));

        System.out.println("Инвертирование всех битов операнда:");
        System.out.println("~(-42) = " + Integer.toBinaryString(~a));
        System.out.println("~(-15) = " + Integer.toBinaryString(~b));

        System.out.println("Сдвиг на один бит влево:");
        System.out.println("-42<< = " + Integer.toBinaryString(a<<1));
        System.out.println("-15<< = " + Integer.toBinaryString(b<<1));

        System.out.println("Сдвиг на один бит влево с присваиванием:");
        System.out.println("-42<<= = " + Integer.toBinaryString(a<<=1));
        System.out.println("-15<<= = " + Integer.toBinaryString(b<<=1));
                
        
        System.out.println("Сдвиг на один бит вправо:");
        System.out.println("-42>> = " + Integer.toBinaryString(a>>1));
        System.out.println("-15>> = " + Integer.toBinaryString(b>>1));
        // В позицию старшего бита вставляется предыдущее значение старшего бита
        
        System.out.println("Сдвиг вправо без учета знака:");
        System.out.println("-42>>> = " + Integer.toBinaryString(a>>>1));
        System.out.println("-15>>> = " + Integer.toBinaryString(b>>>1));
        // При здвиге вправо в позицию старшего бита вставляется ноль

        System.out.println("Сдвиг вправо с заполнением нулями и присваиванием:");
        System.out.println("-42>>>= = " + Integer.toBinaryString(a>>>=1));
        System.out.println("-15>>>= = " + Integer.toBinaryString(b>>>=1));

        //ЗАДАНИЕ 2 
        //Выполнение некоторых арифметических операций

        /*
        System.out.println(" ");
        
        System.out.println("****************************");
        System.out.println("Некоторые арифметические операции:");
        System.out.println(" ");


        System.out.println("п 2.1  5 + 2 / 8 =  " + (5 + 2 / 8));
        */
    }

}
