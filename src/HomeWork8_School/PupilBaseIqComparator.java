package HomeWork8_School;

import java.util.Comparator;

public class PupilBaseIqComparator implements Comparator<Pupil> {
    @Override
    public int compare(Pupil p1, Pupil p2) {
        if (p1.iq == p2.iq) {
            return 0;
        }
        if (p1.iq > p2.iq) {
            return 1;
        }
        else return -1;
    }

}
