package HomeWork8_School;

//import HomeWork7.Person;

import java.util.ArrayList;

public class Family { // СЕМЬЯ
    public Parent pap; // папа
    public Parent mam; // мама
    ArrayList<Pupil> children = new ArrayList<Pupil>();

    public int familyBudzhet; // бюджет
    public int prirostInDay;  // Прирост бюджета в день

    public void setFamilyBudzhet(int familyBudzhet) {
        if (familyBudzhet >= 0)
            this.familyBudzhet = familyBudzhet;
    }

    public Family() {
        this.pap = new Parent(0);
        this.mam = new Parent(1);

        //this.children = children;
        setFamilyBudzhet(RandomS.familyBudzhet());
        this.prirostInDay = RandomS.prirostBudzhetu();
    }
}
