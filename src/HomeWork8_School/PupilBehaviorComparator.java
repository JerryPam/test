package HomeWork8_School;

import java.util.Comparator;

public class PupilBehaviorComparator implements Comparator<Pupil> {

    @Override
    public int compare(Pupil p1, Pupil p2) {
        if (p1.povedenie == p2.povedenie) {
            return 0;
        }
        if (p1.povedenie > p2.povedenie) {
            return 1;
        }
        else return -1;
    }
}
