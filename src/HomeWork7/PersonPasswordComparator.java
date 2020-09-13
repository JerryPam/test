
package HomeWork7;
import java.util.Comparator;

public class PersonPasswordComparator implements Comparator<Person>{
    @Override
    public int compare(Person p1, Person p2) {
       return p1.getPassword().length() - p2.getPassword().length();
    }    

}
