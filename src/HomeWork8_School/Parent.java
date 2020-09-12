package HomeWork8_School;

public class Parent { // РОДИТЕЛЬ
    private String fam;
    private String name;
    private String ot; // отчество
    private String fio = fam + name + ot; // фио вместе
    private char sex;  //пол m w

    public void setFam(String fam) {
        this.fam = fam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public boolean setSex(char sex) { // пол может быть либо мужской, либо женский
        if (sex == 'm') {
            this.sex = sex;
            return true;
        }
        else if (sex == 'w') {
            this.sex = sex;
            return true;
        }
        else return false;
    }

    public String getFam() {
        return fam;
    }

    public String getName() {
        return name;
    }

    public String getOt() {
        return ot;
    }

    public char getSex() {
        return sex;
    }
}
