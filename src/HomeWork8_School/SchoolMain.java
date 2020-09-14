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
        System.out.println("Вот они:");

        for (int i = 0; i < countTeachers; i++) {
            System.out.print(i + ") ");
            System.out.print(teacherArrayList.get(i).fam + " ");
            System.out.print(teacherArrayList.get(i).name + " ");
            System.out.print(teacherArrayList.get(i).ot + " - ");
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
            System.out.println(subList.get(i).name + "   ведёт   " + subList.get(i).teacher.fam + " " + subList.get(i).teacher.name + " " + subList.get(i).teacher.ot);
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

        System.out.println("...");




    } // закрывает psvm
}  // SchoolMain




/*
    MATH,
    RUS,
    ENG,
    LITERATURE,
    GEOGRAPHY,
    BIOLOGY,
    ASTRONOMY,
    CHEMISTRY,
    DRAWING, // черчение
    TRAINING  // физкультура

 */