package HomeWork8_School;

import java.util.ArrayList;

public class Teacher { // ПРЕПОДАВАТЕЛЬ

    public String fam;
    public String name;
    public String ot;
    public String fio; // фио вместе
    public int sex; // пол: 0 - мужчина, 1 - женщина. Параметр

    ArrayList<String> subs = new ArrayList<>(); // список предметов

    public int cat = 0; // категория 0-3. Чем выше, тем лучше
/*
    Категория:
    0 - Начинающий специалист
    1 - Преподаватель 1-ой категории
    2 - Преподаватель 2-ой категории
    3 - Преподаватель высшей категории
 */
    float ball; // балл в аттестате
    float koef_of_teach; // базовый коэффициент качества обучения
    int potential; // скрытый потенциал: 0 - нет, 1 - есть
    int price = 0; // стоимость в сутки

    public void setCat(int cat) {
        if (cat > -1 & cat < 4) this.cat = cat;
    }

    public void setBall(float ball) {
        if (ball > 0 & ball <= 10) this.ball = ball;
    }

    public void setPotential(int potential) {
        if (potential == 0 | potential == 1)
           this.potential = potential;
    }

    public Teacher(String subject0, String subject1) {
        // в зависимости от пола (который определим случайно), дадим Преподавателю мужские, либо женские фио
        if (RandomS.nulAndOne() == 0) { // мужчина
            this.sex = 0;
            this.fam = RandomS.famMan();
            this.name = RandomS.nameMan();
            this.ot = RandomS.otMan();
        } else { // женщина
            this.sex = 1;
            this.fam = RandomS.famWomen();
            this.name = RandomS.nameWomen();
            this.ot = RandomS.otWomen();
        }

        this.fio = this.fam + this.name + this.ot; // фио вместе

        this.subs.add(0, subject0); // первый предмет
        this.subs.add(1, subject1); // второй предмет

        setCat(RandomS.cathegory()); // категория
        setBall(RandomS.attestatBallTeacher());  // ср балл аттестата
        this.koef_of_teach = RandomS.koefOfTeach();
        setPotential(RandomS.nulAndOne()); // скрытй потенциял
        this.price = RandomS.teacherPrice();
    }


}
