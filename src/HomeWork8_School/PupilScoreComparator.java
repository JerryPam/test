package HomeWork8_School;

import java.util.Comparator;

public class PupilScoreComparator implements Comparator<Pupil> {
    //сравнение по среднему баллу ученика
    @Override
    public int compare(Pupil p1, Pupil p2) {
        if (p1.uspevaimost == p2.uspevaimost) {
            return 0;
        }
        if (p1.uspevaimost > p2.uspevaimost) {
            return 1;
        }
        else return -1;
    }
}



/*
public class PriceComparator implements Comparator<House> {

    public int compare(House h1, House h2) {
        if (h1.price == h2.price) {
            return 0;
        }
        if (h1.price > h2.price) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
 */