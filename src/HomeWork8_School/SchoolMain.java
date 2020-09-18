package HomeWork8_School;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolMain {
    public static void main(String[] args) {
        ArrayList<String> subNameList = new ArrayList<>(); // список названий предметов, используем в дальнейшем при создании объектов типа Предмет
        subNameList.add(0,"MATH");
        subNameList.add(1,"RUS");
        subNameList.add(2,"ENG");
        subNameList.add(3,"LITERATURE");
        subNameList.add(4,"GEOGRAPHY");
        subNameList.add(5,"BIOLOGY");
        subNameList.add(6,"ASTRONOMY");
        subNameList.add(7,"CHEMISTRY");
        subNameList.add(8,"DRAWING");  // черчение
        subNameList.add(9,"TRAINING"); // физкультура

        ArrayList<Subject> subList = new ArrayList<>(); // списочный массив типа Предмет

        //заполним списочный массив объектов типа Предмет (СОЗДАДИМ ПРЕДМЕТЫ)
        for (int i = 0; i < subNameList.size(); i++) {
            subList.add(i, new Subject(subNameList.get(i)));
        }

        int countTeachers = 10; // количество учителей

        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра ШКОЛА и Вы в ней ДИРЕКТОР!");
        System.out.println("Выберите сложность игры 1, 2 или 3, где:");
        System.out.println("1 - легко (25 преподавателей) ");
        System.out.println("2 - средне (17 преподавателей) ");
        System.out.println("3 - сложно (10 преподавателей) ");
        int gameLevel = 0;

        do {
            System.out.println("Введите 1, 2 или 3:");
            gameLevel = scanner.nextInt();
        } while (gameLevel != 1 & gameLevel != 2 & gameLevel != 3 );

        switch (gameLevel) {
            case (1):
                countTeachers = 25;
                break;
            case (2):
                countTeachers = 17;
                break;
            case (3):
                countTeachers = 10;
                break;
        }

        System.out.println("Вы выбрали уровень " + gameLevel + ". У Вас будет выбор из "+ countTeachers + " преподавателей");

        ArrayList<Teacher> teacherArrayList = new ArrayList<>(); // список учителей

        for (int i = 0; i < countTeachers; i++) { // СОЗДАДИМ УЧИТЕЛЕЙ
            if (i < subNameList.size()) {
                // пока предметов меньше, чем созданных учителей - первый предмет у учителя создадим гарантированно, второй уже случайно
                // чтобы гарантированно были учителя для каждого предмета
                teacherArrayList.add(i, new Teacher(subNameList.get(i), subNameList.get(RandomS.random.nextInt(subNameList.size()))));
            } else {
                // если учителей уже больше, чем созданных предметов - дальше и первый и второй предмет у учителя создаём случайным образом
                teacherArrayList.add(i, new Teacher(subNameList.get(RandomS.random.nextInt(subNameList.size())), subNameList.get(RandomS.random.nextInt(subNameList.size()))));
            }
        }
        System.out.println();
        //System.out.println("Создано " + teacherArrayList.size() + " учителей:");
        int lengthFIO; // длина ФИО, учитывается для выравнивания выводимого списка

        System.out.println("Вот они:");

        for (int i = 0; i < countTeachers; i++) {
            System.out.print(i + ") ");
            System.out.print(teacherArrayList.get(i).fam + " ");
            System.out.print(teacherArrayList.get(i).name + " ");
            System.out.print(teacherArrayList.get(i).ot + " - ");

            lengthFIO = teacherArrayList.get(i).fam.length() + teacherArrayList.get(i).name.length() + teacherArrayList.get(i).ot.length();
            System.out.print(addSpaces(30 - lengthFIO)); // добавим несколько пробелов после фио для выравнивания столбцов

            System.out.print("Ср.балл: " + teacherArrayList.get(i).ball + ", ");
            System.out.print("Ст-ть/сут: " + teacherArrayList.get(i).price + ", Предметы: ");
            System.out.print(teacherArrayList.get(i).subs.get(0) + " ");
            System.out.print(teacherArrayList.get(i).subs.get(1) + " ");
            System.out.println();
        }
        System.out.println();

        // выведем для наглядности список предметов, которые преподаются в школе
        System.out.println("Предметы, которые преподаются в школе:");
        for (int i = 0; i < subList.size(); i++) {
            System.out.print(subList.get(i).name);
            if (i != subList.size() - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("Для каждого из этих предметов необходимо выбрать преподавателя, который будет вести этот предмет");
        System.out.println();
        System.out.println("ВЫБОР - (введите порядковый номер преподавателя из списка сверху, который будет вести предмет): ");

        int numTeacher;  // номер преподавателя из списка
        int priznakVybora; // признак выбора преподавателя для предмета
        for (int i = 0; i < subList.size(); i++) {
            priznakVybora = 0;
            do {
                System.out.print(subList.get(i).name + ": №? ");
                numTeacher = scanner.nextInt();
                if (numTeacher < 0 & numTeacher > teacherArrayList.size()) {
                    System.out.println("Введён некорректный номер. Выберите номер из диапазона списка");
                }
                else if (subList.get(i).name != teacherArrayList.get(numTeacher).subs.get(0) & subList.get(i).name != teacherArrayList.get(numTeacher).subs.get(1)) {
                    System.out.println("Выбранный преподаватель не может преподавать предмет " + subList.get(i).name + "!");
                    System.out.println("Выберите другого преподавателя для этого предмета");
                } else {
                    subList.get(i).teacher = teacherArrayList.get(numTeacher);
                    priznakVybora = 1;
                }
            } while (priznakVybora == 0);
        }

        System.out.println();
        System.out.println("Вы выбрали преподавателей! Вот список предметов и кто их будет вести: ");

        for (int i = 0; i < subList.size(); i++) { // выводим список предметов и преподавателей, которые их будут вести
            lengthFIO = subList.get(i).name.length(); // посчитаем длину строки наименования предмета
            System.out.println(subList.get(i).name + " ведёт " + addSpaces(10 - lengthFIO) + subList.get(i).teacher.fam + " " + subList.get(i).teacher.name + " " + subList.get(i).teacher.ot);
        }
        System.out.println();

        ArrayList<Family> familyArrayList = new ArrayList<>(); // список семей
        //ArrayList<Parent> parentArrayList = new ArrayList<>(); // список родителей - не нужен, т.к. родители привязаны к семьям
        ArrayList<Pupil> pupilArrayList = new ArrayList<>(); // список учеников
        ArrayList<Klass> klassArrayList = new ArrayList<>(); // список классов

/*
    Создадим 100 учеников. Для связности объектов (отношений людей) и фио семей,
    будем создавать семьи и сразу родителей и детей семьи, контролируя количество учеников.
 */
    int countPupils = 100;   // количество учеников, которое будем создавать
    int childrenInStep = 3; // количество детей, которое будем создавать за шаг цикла. В процессе создания семьи эта цифра будет случайной
    int childrenCreated = 0; // сколько детей создано

    while (childrenCreated < countPupils) {
        childrenInStep = RandomS.countChildrenInFamily(); // определим количество детей в новой семье
        familyArrayList.add(new Family()); // создаём семью (родители в семье создаются при создании семьи)

        if (countPupils - childrenCreated > childrenInStep) { // если количество детей попадает в оставшуюся квоту
            for (int i = 0; i < childrenInStep; i++) { // создаём учеников
                // создаём ученика и привязываем его к последней созданной семье
                pupilArrayList.add(new Pupil(familyArrayList.get(familyArrayList.size() - 1)));
            }
        } else { // создадим последнюю семью, с оставшимся от квоты количеством детей
            childrenInStep = countPupils - childrenCreated;
            for (int i = 0; i < childrenInStep; i++) { // создаём учеников
                // создаём ученика и привязываем его к последней созданной семье
                pupilArrayList.add(new Pupil(familyArrayList.get(familyArrayList.size() - 1)));
            }
        }
        childrenCreated += childrenInStep; // учёт, сколько учеников создано
    }
        System.out.println("Создано " + pupilArrayList.size() + " учеников");
        System.out.println();

    // Создадим КЛАССЫ, сразу с классными руководителями
        klassArrayList.add(new Klass("10А", teacherArrayList.get(0)));
        klassArrayList.add(new Klass("10Б", teacherArrayList.get(1)));
        klassArrayList.add(new Klass("10В", teacherArrayList.get(2)));
        klassArrayList.add(new Klass("10Г", teacherArrayList.get(3)));

        System.out.println("Создано " + klassArrayList.size() + " школьных класса:");
        for (int i = 0; i < klassArrayList.size(); i++) {
            System.out.print("Класс " + klassArrayList.get(i).nameKlass + " ");
            System.out.print("Кл. руководитель: " + klassArrayList.get(i).classTeacher.fam + " " + klassArrayList.get(i).classTeacher.name + " " + klassArrayList.get(i).classTeacher.ot);
            System.out.println();
        }

        //**********************************************
        // посортируем учеников
        System.out.println();
        System.out.println("Ученики школы (несортированные):");

        for (int i = 0; i < countPupils; i++) {
            System.out.print(i + ") ");
            System.out.print(pupilArrayList.get(i).fam + " ");
            System.out.print(pupilArrayList.get(i).name + " ");
            System.out.print(pupilArrayList.get(i).ot + " - ");
            lengthFIO = pupilArrayList.get(i).fam.length() + pupilArrayList.get(i).name.length() + pupilArrayList.get(i).ot.length();
            System.out.print(addSpaces(30 - lengthFIO)); // добавим несколько пробелов после фио для выравнивания столбцов
            System.out.print("Поведение: " + pupilArrayList.get(i).povedenie + ", ");
            System.out.print("Усп-ть: " + pupilArrayList.get(i).uspevaimost + ", ");
            System.out.print("IQ: " + pupilArrayList.get(i).iq + ", ");
            System.out.print("Доход/сут: " + pupilArrayList.get(i).sutDohod);
            System.out.println();
        }
        System.out.println();

        System.out.println("ФОРМИРУЕМ КЛАССЫ (наполняем их учениками)");
        System.out.println("Пожалуйста, выберите, каким образом распределить учеников по классам!");
        System.out.println("Критерий выбора: 0, 1, 2, 3 или 4 - где:");
        System.out.println("0 - случайным образом;");
        System.out.println("1 - по среднему баллу по поведению;");
        System.out.println("2 - по среднему баллу по успеваемости;");
        System.out.println("3 - по базовому IQ;");
        System.out.println("4 - по сумме дохода в сутки.");

        ArrayList<Pupil> pupilArrayListForSort = new ArrayList<>(pupilArrayList); // заведём отдельный список учеников для различных сортировок

        int kritSortOfPupil = 0; // критерий сортировки учеников
        do {
            System.out.println("Введите 0, 1, 2, 3 или 4:");
            kritSortOfPupil = scanner.nextInt();
        } while (kritSortOfPupil != 1 & kritSortOfPupil != 2 & kritSortOfPupil != 3 & kritSortOfPupil != 4 & kritSortOfPupil != 0);

        System.out.println("Вы выбрали критерий \"" + kritSortOfPupil + "\"!");
        System.out.print("Ученики будут распределены по классам ");
        switch (kritSortOfPupil) {
            case (1):
                System.out.print("по среднему баллу по поведению");
                PupilBehaviorComparator pupilBehaviorComparator = new PupilBehaviorComparator();
                pupilArrayListForSort.sort(pupilBehaviorComparator);
                break;
            case (2):
                System.out.print("по среднему баллу по успеваемости");
                PupilScoreComparator pupilScoreComparator = new PupilScoreComparator();
                pupilArrayListForSort.sort(pupilScoreComparator);
                break;
            case (3):
                System.out.print("по базовому IQ");
                PupilBaseIqComparator pupilBaseIqComparator = new PupilBaseIqComparator();
                pupilArrayListForSort.sort(pupilBaseIqComparator);
                break;
            case (4):
                System.out.print("по сумме дохода в сутки");
                PupilIncomeComparator pupilIncomeComparator = new PupilIncomeComparator();
                pupilArrayListForSort.sort(pupilIncomeComparator);
                break;
            default:
                System.out.print("случайным образом (согласно начально сформированного списка учеников)");
                // default (0) - для случайного заполнения классов пока ничего не делаем
                // т.к. у нас уже есть исходный список, случайно созданных учеников, его и вносим подряд в классы
                // или позже можно и реализовать случайный выбор из этого общего списка и уже есть мысли как это сделать
                break;
        }
        System.out.println();
        System.out.println();

        int countPupilsInKlass = 25; // количество учеников в классе примем 25
        int nextPupil = 0;  // следующий ученик из списка учеников
        for (int nextKlass = 0; nextKlass < klassArrayList.size(); nextKlass++) {
            for (int j = 0; j < countPupilsInKlass; j++) {
                klassArrayList.get(nextKlass).pupils.add(pupilArrayListForSort.get(nextPupil));
                nextPupil +=1;
            }
        }
        System.out.println("КЛАССЫ СФОРМИРОВАНЫ!");

        nextPupil = 0;
        int numPP; // номер по порядку в списке учеников
        //int lengthFIO; // длина ФИО, учитывается для выравнивания выводимого списка
        //int addSpaces;
        for (int nextKlass = 0; nextKlass < klassArrayList.size(); nextKlass++) { // цикл для классов
            System.out.println("КЛАСС \"" + klassArrayList.get(nextKlass).nameKlass + "\"");
            System.out.println("Классный руководитель: " + klassArrayList.get(nextKlass).classTeacher.fam + " " + klassArrayList.get(nextKlass).classTeacher.name + " " + klassArrayList.get(nextKlass).classTeacher.ot);
            System.out.println("Список учеников класса: ");
            for (int j = 0; j < countPupilsInKlass; j++) { // цикл для вывода списка учеников в конкретном классе
                numPP = j + 1; // чтобы список учеников класса начанался в человеческом виде, т.е. с "1", а не с нуля
                System.out.print(numPP + ") ");
                System.out.print(klassArrayList.get(nextKlass).pupils.get(j).fam + " ");
                System.out.print(klassArrayList.get(nextKlass).pupils.get(j).name + " ");
                System.out.print(klassArrayList.get(nextKlass).pupils.get(j).ot + " ");
                lengthFIO = klassArrayList.get(nextKlass).pupils.get(j).fam.length() + klassArrayList.get(nextKlass).pupils.get(j).name.length() + klassArrayList.get(nextKlass).pupils.get(j).ot.length();
                System.out.print(addSpaces(31 - lengthFIO)); // добавим пробелы до 31 символа от начала, чтобы выровнять столбцы с данными
                System.out.print("Поведение: " + klassArrayList.get(nextKlass).pupils.get(j).povedenie + ", ");
                System.out.print("Усп-ть: " + klassArrayList.get(nextKlass).pupils.get(j).uspevaimost + ", ");
                System.out.print("IQ: " + klassArrayList.get(nextKlass).pupils.get(j).iq + ", ");
                System.out.print("Доход/сут: " + klassArrayList.get(nextKlass).pupils.get(j).sutDohod);
                System.out.println();
                nextPupil +=1;
            }
            System.out.println(); // отделим классы пустой строкой
        }

/*      // test
        System.out.println("Сортированынй список учеников:");
        for (int i = 0; i < countPupils; i++) {
            System.out.print(i + ") ");
            System.out.print(pupilArrayListForSort.get(i).fam + " ");
            System.out.print(pupilArrayListForSort.get(i).name + " ");
            System.out.print(pupilArrayListForSort.get(i).ot + " - ");
            System.out.print("Поведение: " + pupilArrayListForSort.get(i).povedenie + ", ");
            System.out.print("Усп-ть: " + pupilArrayListForSort.get(i).uspevaimost + ", ");
            System.out.print("IQ: " + pupilArrayListForSort.get(i).iq + ", ");
            System.out.print("Доход/сут: " + pupilArrayListForSort.get(i).sutDohod);
            System.out.println();
        }
*/
        System.out.println("To be continued...");

    } // закрывает psvm

    public static String addSpaces(int spaces) { // возврат строки с нужным количеством пробелов
        StringBuilder builder = new StringBuilder();
        for (int a = 0; a < spaces; a++) {
            builder.append(' ');
        }
        return builder.toString();
    }

}  // SchoolMain

