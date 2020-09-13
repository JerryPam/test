package HomeWork8_School;

import java.util.ArrayList;

public class Klass { // КЛАСС
    String nameKlass;
    Teacher classTeacher; // классный руководитель
    ArrayList<Pupil> pupils = new ArrayList<>(); // ученики
    ArrayList<Subject> subjects = new ArrayList<>(); // предметы

    public Klass(String nameKlass, Teacher classTeacher) {
        this.nameKlass = nameKlass;
        this.classTeacher = classTeacher;
    }
}
