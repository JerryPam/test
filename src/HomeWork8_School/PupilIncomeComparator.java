package HomeWork8_School;

import java.util.Comparator;

public class PupilIncomeComparator implements Comparator<Pupil> {
    // Сравнение по суточному доходу ученика
    @Override
    public int compare(Pupil p1, Pupil p2) {
        if (p1.sutDohod == p2.sutDohod) {
            return 0;
        }
        if (p1.sutDohod > p2.sutDohod) {
            return 1;
        }
        else return -1;
    }
}
