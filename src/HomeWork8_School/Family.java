package HomeWork8_School;

import HomeWork7.Person;

import java.util.ArrayList;

public class Family { // СЕМЬЯ
    public Person mam; // мама
    public Person pap; // папа
    ArrayList<Pupil> children = new ArrayList<Pupil>();

    public int family_budzhet = 0; // бюджет
    public int prirost_in_day = 0; // Прирост бюджета в день

    public void setFamily_budzhet(int family_budzhet) {
        if (family_budzhet >= 0)
            this.family_budzhet = family_budzhet;
    }
}
