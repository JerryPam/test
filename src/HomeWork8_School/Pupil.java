package HomeWork8_School;

public class Pupil {  // УЧЕНИК
    public String fam;
    public String name;
    public String ot; // отчество
    public String fio; // фио вместе
    public String nameKlass;
    public int sex; // пол ребёнка

    public Family semia; // ссылка на семью
    public float povedenie; // средний бал по поведению
    public float uspevaimost; // средний бал по успеваимости
    public int opozdanie; // склонность к опозданиям: 0 - нет, 1 - да
    public int iq; //
    public int potential; // скрытый потенциал: 0 - нет, 1 - есть
    public int sutDohod; // суточный доход

    public void setOpozdanie(int opozdanie) {
        if (opozdanie == 0 | opozdanie == 1)
           this.opozdanie = opozdanie;
    }

    public void setPotential(int potential) {
        if (potential == 0 | potential == 1)
           this.potential = potential;
    }

    public void setIq(int iq) {
        if (iq > -1 & iq < 111) // примем, что iq может быть от 0 до 110
           this.iq = iq;
    }

//    public Pupil(String fam, String name, String ot, String fio, int sex, Family semia, float povedenie, float uspevaimost, int opozdanie, int iq, int potential, int sut_dohod) {
    public Pupil(Family semia) {
        // в зависимости от пола (который определим случайно), дадим ученику мужские, либо женские фио
        if (RandomS.nulAndOne() == 0) { // мальчик
            this.sex = 0;
            this.fam = RandomS.famMan();
            this.name = RandomS.nameMan();
            this.ot = RandomS.otMan();
        } else { // девочка
            this.sex = 1;
            this.fam = RandomS.famWomen();
            this.name = RandomS.nameWomen();
            this.ot = RandomS.otWomen();
        }
        this.fio = fam + name + ot;
        // this.numClass;  // присвоим при распределении учеников по классам
        // this.bukvaClass; // присвоим при распределении учеников по классам

        this.semia = semia;
        this.povedenie = RandomS.averagePointBehaviour();
        this.uspevaimost = RandomS.averagePointProgress();
        setOpozdanie(RandomS.nulAndOne()); // склонность к опозданию
        setIq(RandomS.iqLevel());      //  iq
        setPotential(RandomS.nulAndOne());  // скрытй потенциал
        this.sutDohod = RandomS.sutDohod(); // устанавливаем случайно, но вообще, по логике доход должен устанавливаться для всех учеников класса одинаково
    }
}
