/*
Ханойские башни. Ручной режим.
*/

package HomeWork4;
//package HomeWorkTest.HomeWork4;

import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        //char[][] mas;
        boolean win  = false; // признак окончания игры
        boolean move = false; // признак успешности перемещения кольца
        
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число колец (не меньше 3-х): ");
        int count = scanner.nextInt();
        int columnCount = 3;
        int ring = 0; 

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
            st_get--; // первая колонка на экране - это нулевая колонка в java
            
            System.out.print("Куда вешаем кольцо? ");
            int st_to = scanner.nextInt();
            st_to--; // n-я колонка на экране - это (n-1) колонка в java
            
            ring = take_ring(st_get, map); // возьмём кольцо с указанного стержня
            if (ring == 0) { // если метод вернул ноль, значит колец на стержне нет
                System.out.println("На " + (st_get+1) + "стержне колец нет");
                System.out.println("Введите правильный номер стержня, откуда брать кольцо");
            } else{ // если мы нашли и взяли кольцо - попробуем его повесить на выбранный стержень
                // (int ring, int st1, int st2, int[][] map2)
                move = hang_ring(ring, st_get, st_to, map);
                if (move == true){ // если кольцо успешно перенесено
                    win = proverka(st_get, map);
                } else {
                    System.out.println("Перемещение кольца с " + (st_get+1) + "на " + (st_to+1) + "стержень невозможно");
                    System.out.print("Нажмите любую клавишу для продолжения . . . ");
                    s.nextLine();
                }
            }
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

    // метод, который вешает кольцо на указанный стержень-приёмник
    // в метод передаётся кольцо, номер стержня-источника, номер стержня-приёмника, указатель на массив
    // в случае успеха операции возвращает true
    public static boolean hang_ring(int ring, int st1, int st2, int[][] map2) {
        int j = 0; // для прохода по стержню, куда вешаем кольцо
        boolean result = false; // результат операции по переносу кольца

        if (map2[map2.length - 1][st2] == 0) { // если стержень-назначения пустой (свободная самая нижняя ячейка)
            map2[map2.length - 1][st2] = ring; // перенесём кольцо и вернём успех результата переноса
            rec_nul(st1, map2); // запишем ноль на стержень-источник вместо "взятого кольца"
            result = true; //для отладки
            return true;
        } else { // если самая нижняя ячейка занята, то начнём стандартный поиск свободной ячейки на стержне
            // начнём цикл поиска кольца
            do{
                if (map2[j][st2] == 0 & map2[j+1][st2] > 0 ){ // если текущая ноль, а в следующей кольцо
                    // то мы нашли место, куда повесить кольцо, но надо определить, можно ли его туда вообще размещать
                    if (ring < map2[j+1][st2]){ // проверяем, можно ли вешать кольцо (чтоб оно было меньше находящегося на стержне)
                        map2[j][st2] = ring;
                        rec_nul(st1, map2); // запишем ноль на стержень-источник вместо "взятого кольца"
                        result = true; // для отладки
                        return true;
                    } else { // кольцо вешать нельзя, оно больше, чем то, которое на стержне
                        result = false; // возможно эта строчка лишняя
                        return false;
                        //break;
                    }
                } else j++;

            }while (j < (map2.length -1)); // цикл работает до предпоследней ячейки

            System.out.println("Служебное сообщение: цикл размещения кольца работает неправильно");
            return false; // заглушка, которая при правильной работе программы не должна никогда срабатывать
        }
    }

    // возвращает кольцо (номер), если вернёт ноль, значит на стержне-источнике колец больше нет
    // передаём в метод номер стержня-источника и массив
    public static int take_ring(int st1, int[][] map2){
        int ring = 0;
        int i = 0;
        do { // идём вниз по стержню-источнику, пока не напоремся на кольцо:
            if (map2[i][st1] > 0) { // если ячейка не пустая
                ring = map2[i][st1]; // запомним размер кольца, которое берём
                return ring;
            } else i++;
        }while (i < map2.length);
        return ring; 
    }

    // метод идёт вниз по стержню, находит кольцо и записывает на его место ноль, т.е. пустое место
    // типа как "взять кольцо со стержня-источника"
    public static void rec_nul(int st1, int[][] map2){
        //int ring = 0;
        int i = 0;
        do { // идём вниз по стержню-источнику, пока не напоремся на кольцо:
            if (map2[i][st1] > 0) { // если ячейка не пустая
                map2[i][st1] = 0; // запишем туда ноль
                break;
            } else i++;
        }while (i < map2.length);
    }


/*
    static char pull(int ring1){ // метод взятия кольца с указанного стержня

    }

    static char push(int ring2){ // поместить кольцо на указанный стержень

    }
*/

    static boolean proverka(int st1, int[][] map){ // проверка на заполненность третьего стержня, т.е. на окончание игры
        // если хотя-бы один из стержней приёмников заполнен - возвращаем true
        // st1- номер стержня-источника
        // st2, st3 - номера стержней-приёмников
        int st2, st3;

        boolean theEnd = false; // признак окончания игры
        switch (st1){ // в зависимости от стержня-источника, определим столбцы-назначеня (для проверки на заполненность)
            case 0: st2 = 1; st3 = 2;
                    break;
            case 1: st2 = 0; st3 = 2;
                    break;
            case 2: st2 = 0; st3 = 1;
                    break;
            default: 
                // при корректной работе программы, данная ветка никогда не выполнится
                System.out.println("Не совсем корректно работает метод PROVERKA. Сообщите разработчику!");
                st2 = 1; st3 = 2;
                break;
        }

        if (map[0][st2] > 0 || map[0][st3] > 0) {
            theEnd = true;
        }
        return theEnd;
    }

/*
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
*/

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
