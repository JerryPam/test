package HomeWork8_School;

public class Pupil {  // УЧЕНИК
    public String fam;
    public String name;
    public String ot; // отчество
    public String fio = fam + name + ot; // фио вместе
    public int num_class;
    public char bukva_class;

    public Family semia; // ссылка на семью
    public float povedenie; // средний бал по поведению
    public float uspevaimost; // средний бал по успеваимости
    public int opozdanie = 0; // склонность к опозданиям: 0 - нет, 1 - да
    public int iq = 0; // первоначально ноль, при создании объекта будем генерить iq случайно
    public int potential = 0; // скрытый потенциал: 0 - нет, 1 - есть
    public int sut_dohod; // суточный доход

    public void setOpozdanie(int opozdanie) {
        if (opozdanie == 0 | opozdanie == 1)
           this.opozdanie = opozdanie;
    }

    public void setPotential(int potential) {
        if (potential == 0 | potential == 1)
           this.potential = potential;
    }

    public void setIq(int iq) {
        if (iq > -1 & iq < 101) // iq может быть от 0 до 100
           this.iq = iq;
    }


}
