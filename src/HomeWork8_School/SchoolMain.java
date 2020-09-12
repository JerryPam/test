package HomeWork8_School;

import java.util.ArrayList;

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
        subNameList.add(8,"DRAWING");
        subNameList.add(9,"TRAINING");

        ArrayList<Subject> subList = new ArrayList<>(); // списочный массив типа Предмет

        //заполним списочный массив объектов типа Предмет
        for (int i = 0; i < subList.size(); i++) {
            subList.add(0,new Subject(subNameList.get(i)));
        }

        ArrayList<Teacher> teacherArrayList = new ArrayList<>(); // список учителей
        ArrayList<Family> familyArrayList = new ArrayList<>(); // список семей
        ArrayList<Parent> parentArrayList = new ArrayList<>(); // список родителей
        ArrayList<Pupil> pupilArrayList = new ArrayList<>(); // список учеников
        ArrayList<Klass> klassArrayList = new ArrayList<>(); // список классов

/*
    Создадим 100 учеников. Для связности объектов (отношений людей) и фио семей,
    будем создавать семьи и сразу родителей и детей семьи, контролируя количество учеников.
 */
    int countPupils = 100;   // сколько учеников будем создавать
    int childrenInStep; // сколько детей будем создавать за шаг цикла.
    int childrenCreated = 0; // сколько детей создано

    while (childrenCreated < countPupils) {
        childrenInStep = RandomS.countChildrenInFamily(); // определим количество детей в новой семье
        if (countPupils - childrenCreated > childrenInStep) { // если количество детей попадает в оставшуюся квоту
            createFamily(childrenInStep);

        } else { // создадим последнюю семью, с оставшимся от квоты количеством детей
            childrenInStep = countPupils - childrenCreated;
            createFamily(childrenInStep);

        }
        childrenCreated += childrenInStep;
    }
    }

    public static void createFamily(int children){
        // создание семьи, а вместе с ней родителей и детей семьи



    }

}




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