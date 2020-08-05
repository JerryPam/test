/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork7;

import java.util.Comparator;
//import java.lang.Comparable;


public class AnimalAgeComparator implements Comparator<Animal> {
    @Override
   public int compare(Animal a1, Animal a2) {
       return a1.getAge() - a2.getAge();
   }
}
