package HomeWork8_School;

public class Parent { // РОДИТЕЛЬ
    public String fam;
    public String name;
    public String ot; // отчество
    public String fio; // фио вместе
    public int sex;  //пол: 0 - мужской, 1 - женский

    public Parent(int sex) { // в зависимости от пола родителя, создаём либо папу с мужскими именами, либо маму с женскими
        if (sex == 0) { // мужчина
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
        this.fio = fam + name + ot;
    }
}
