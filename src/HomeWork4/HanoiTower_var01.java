/*
Ханойские башни. Ручной режим.
ПРОГРАММА СЫРАЯ, ПОКА НЕ ОТЛАЖЕНА
*/

package HomeWork4;


import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        //char[][] mas;
        boolean win = false; // признак выигрыша
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число колец (не меньше 3-х): ");
        int count = scanner.nextInt();
        int columnCount = 3;

        if (count < 3){
            System.out.println("Колец должно быть не менее 3-х");
            return;
        }

        int[][] map = new int [count][columnCount];

        for (int i = 0; i < map.length; i++){
            map[i][0] = i + 1;
        }

        printMap(map);

        do{
            cls();
            printMap(map);
            System.out.print("Откуда берём кольцо? ");
            int st_get = scanner.nextInt();
            System.out.print("Куда вешаем кольцо? ");
            int st_to = scanner.nextInt();
            if (jump(st_get, st_to, map)) {
                // если перенос кольца удачный
                win = proverka(map); // проверка на окончание игры
            } else {
                System.out.println("Перемещение кольца с " + st_get + "на " + st_to + "стержень невозможно");
                System.out.print("Нажмите любую клавишу для продолжения . . . ");
                s.nextLine();
            }
            //break;
        }while (win == false);

        cls();
        printMap(map);
        System.out.println("ИГРА ЗАВЕРШЕНА!");

    } // *** ОКОНЧАНИЕ ОСНОВНОГО ТЕЛА ПРОГРАММЫ

    public static void printMap(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int value = map[i][j];
                if (value == 0){
                    System.out.print("* ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static boolean jump(int st1, int st2, int[][] map2){
        // метод возвращает true при успешном перемещении кольца, false - при невозможности это сделать (согласно правил)
        // st1 - с какого стержня взять
        // st2 - на какой стержень повесить
        int ring = 0; // наше кольцо, первоначально ноль (для порядка)
        int i = 0; // для прохода по стержню, откуда берём кольцо
        int j = 0; // для прохода по стержню, куда вешаем кольцо
        boolean result = false; // результат операции по переносу кольца
        do { // идём вниз по стержню-источнику, пока не напоремся на кольцо:
            if (map2[i][st1] > 0) { // если ячейка не пустая
                ring = map2[i][st1]; // запомним размер кольца, которое берём
                
                if (map2[0][st2] == 0 & map2[1][st2] > 0) { // если свободна только верхняя ячейка в столбце
                    map2[0][st2] = ring; // вешаем последнее кольцо
                    map2[i][st1] = 0; // ставим пустую ячейку, из которой взяли кольцо
                    result = true;  // возможно это лишнее
                    return true;
                } else { // если свободных ячеек больше, чем одна
                    j = 1; // начнём со второй ячейки, т.к. первую уже проверили выше
                    do { // цикл поиска ячейки, куда разместить кольцо
                       if (map2[j][st2] == 0 & map2[j+1][st2] > 0 ){ // если текущая ноль, а в следующей кольцо
                           if (ring < map2[j+1][st2]){ // проверяем, можно ли вешать кольцо (чтоб оно было меньше находящегося на стержне)
                               map2[j][st2] = ring;
                               map2[i][st1] = 0;
                               result = true; 
                               return true; 
                           } else { // кольцо вешать нельзя, оно больше, чем то, которое на стержне
                               result = false; // возможно эта строчка лишняя
                               return false;
                               //break;
                           }
                       } else j++;
                    }while (j < map2.length || result == false);
                
                } // посл скобка else - где исполнялся код, если свободная ячейка не только верхняя
                
                // здесь надо проверить можем ли мы, согласно правил игры, повесить взятое кольцо на выбранный стержень
                // если можем - вешаем, в нужную ячейку заносим ring
                // map2[i][st1] = 0; // если забрали кольцо, то в ячейку запишем 0
            } else {
                i++; // если в ячейке оказался ноль, т.е. она со звёздочкой
                // пойдём вниз на следующую, в поисках кольца, т.е. цифры
                // для этого i++
            }
        } while (i < map2.length || ring > 0);
        
        if (ring == 0) { // если мы вышли из цикла и ring ==0, значит колец на стержне нет
            System.out.println("На " + st1 + "стержне колец нет");
            System.out.println("Введите правильный номер стержня, откуда брать кольцо");
        }
        return result; // требовало возврат на этой скобке, не уверен, что это правильно
    }


/*
    static char pull(int ring1){ // метод взятия кольца с указанного стержня

    }

    static char push(int ring2){ // поместить кольцо на указанный стержень

    }
*/
    
    static boolean proverka(int[][] map){ // проверка на заполненность третьего стержня, т.е. на окончание игры
        boolean theEnd = false; // признак окончания игры
        for (int i = 0; i < map.length; i++){
            if (!(map[i][2] == i + 1)){ 
                theEnd = false;
                return theEnd;
            } else theEnd = true;
        }
        return theEnd;
    }


    static void cls() { // метод для очистки экрана
        for (int i=0; i < 20; i++){
            System.out.println();
        }
    }

/*
    static void Read()
    {
        System.out.print("Press any key to continue . . . ");
        s.nextLine();
    }
*/
}
