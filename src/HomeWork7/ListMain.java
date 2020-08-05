/*
Домашка "Списки".
 */

package HomeWork7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class ListMain {
    public static void main(String[] args) {

        long ms1, ms2, exec_time; // переменные для фиксации времени работы программы
        int count_obj = 1_000_000; // 100_001  1_000_001 - для удобства изенения количества объектов, при контроле работы программы

        System.out.println("Внесём в два списка по " + count_obj + " элементов");

        ArrayList<Person> list = new ArrayList<>();
        final Random random = new Random(); // будем определять длину пароля, длина которого от 5 до 10 символов
        
        ms1 = System.currentTimeMillis();
        for (int i = 0; i < count_obj; i++) // заполнение списка объектами
        {
            Person per = new Person();
            per.setNick(RandomString.random(random.nextInt(11) + 5)); // длину имени зададим от 5 до 15 символов
            per.setPassword(RandomString.random(random.nextInt(6) + 5)); // длина пароля 5-10 символов
            list.add(per);
            if (i < 10) { // для отладки: выведем несколько объектов, посмотреть, что там создаётся
                System.out.println("Person [" + i + "]: " + per.getNick() + "  " + per.getPassword());
            }
            /*
            if (i%200_000 == 0 & i != 0) { // для отладки, чтобы видеть процесс в динамике
                System.out.println("Создано элементов: " + i);
                //System.out.println("Person [" + i + "]: " + per.getNick() + "  " + per.getPassword());
            } */
        }
        ms2 = System.currentTimeMillis();
        exec_time = ms2 - ms1;
        System.out.println("Время заполнения ArrayList: " + exec_time + " мс"); // Время заполнения ArrayList: 833 мс
        System.out.println();

        LinkedList<Animal> animal = new LinkedList<>();
        ms1 = System.currentTimeMillis();
        for (int i = 0; i < count_obj; i++) // заполнение списка объектами
        {
            Animal a = new Animal();
            a.setNick(RandomString.random(random.nextInt(18) + 3)); // дадим клички длиной от 3 до 20 символов (для разнообразия)
            a.setAge(random.nextInt(15) + 1); // возраст от 1 до 15
            animal.add(a);
            if (i < 10) { // для отладки: выведем несколько объектов, посмотреть, что там создаётся
                System.out.println("Animal [" + i + "]: " + a.getNick() + "  " + a.getAge());
            }
            /*
            if (i%200_000 == 0 & i != 0) { // для отладки
                System.out.println("Создано элементов: " + i);
                //System.out.println("Animal [" + i + "]: " + a.getNick() + "  " + a.getAge());
            } */

        }
        ms2 = System.currentTimeMillis();
        exec_time = ms2 - ms1;
        System.out.println("Время заполнения LinkedList: " + exec_time + " мс"); // Время заполнения LinkedList: 478 мс

/*
Время заполнения 1 000 000 объектами ArrayList: 833 мс
Время заполнения 1 000 000 объектами LinkedList: 478 мс
*/

        // задания 6, 8, 10
        System.out.println();
        System.out.println("Отсортированный по длине пароля список Person (первые 10 элементов):");
        Comparator ppc = new PersonPasswordComparator();
        Collections.sort(list, ppc);
        for (int i = 0; i < 10; i++){  // для проверки посмотрим первые десять элементов списка
            System.out.println("Person [" + i + "]: " + list.get(i).getNick() + "  " + list.get(i).getPassword());
        }
        
        System.out.println();
        System.out.println("Отсортированный по возрасту список Animal (первые 10 элементов):");
        Comparator aac = new AnimalAgeComparator();
        Collections.sort(animal, aac);
        for (int i = 0; i < 10; i++){ // для проверки посмотрим первые десять элементов списка
            System.out.println("Animal [" + i + "]: " + animal.get(i).getNick() + "  " + animal.get(i).getAge());
        }
        
        System.out.println();
        System.out.println("Количество элементов списка Person до удаления: " + list.size());
        System.out.println("Начали удалять список Person");

        Iterator<Person> pIterator = list.iterator();

        ms1 = System.currentTimeMillis();
        while(pIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Person nextPerson = pIterator.next();//получаем следующий элемент
            pIterator.remove();
        }
        ms2 = System.currentTimeMillis();
        exec_time = ms2 - ms1;

        System.out.println("Список Person удалён за " + exec_time + " мс"); // Список Person удалён за 130373 мс
        System.out.println("Количество элементов списка Person после удаления: " + list.size());
        System.out.println();
        
        
        // удаляем в цикле последний элемент, пока не получим исключение
        System.out.println("Количество элементов списка Animal до удаления: " + animal.size());
        System.out.println("Начали удалять список Animal");

        int a_size = animal.size();
        ms1 = System.currentTimeMillis();
        for (int i = 0; i < a_size; i++) {
            animal.removeLast(); // будем удалять элементы, например, с конца
        }
        ms2 = System.currentTimeMillis();
        exec_time = ms2 - ms1;

        System.out.println("Список Animal удалён за " + exec_time + " мс"); // Список Animal удалён за 61 мс
        System.out.println("Количество элементов списка Animal после удаления: " + animal.size());

/*
Список Person на 1_000_000 элементов удалён за 130373 мс
Список Animal на 1_000_000 элементов удалён за 61 мс
 */

    }
}
