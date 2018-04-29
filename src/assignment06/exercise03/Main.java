// Loris Witschard & Nicolas Bovet
package assignment06.exercise03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 4; i > 0; i--) {
            intList.add(i);
        }

        System.out.println("Integer list before");
        for(Integer i : intList){
            System.out.println("i = " + i);
        }

        shuffle(intList);
        Collections.sort(intList);

        System.out.println("Integer list sorted");
        for(Integer i : intList){
            System.out.println("i = " + i);
        }


        ArrayList<Double> doubleList = new ArrayList<>();
        for (double i = 4; i > 0; i--) {
            doubleList.add(i);
        }

        System.out.println("Double list before");
        for(Double d : doubleList){
            System.out.println("d = " + d);
        }

        shuffle(doubleList);
        Collections.sort(doubleList);

        System.out.println("Double list sorted");
        for(Double d : doubleList){
            System.out.println("d = " + d);
        }
    }

    private static <T> void shuffle(List<T> list){
        Random rnd = new Random();
        for (int i=0; i<list.size(); i++) {
            int j = rnd.nextInt(list.size());
            T ii = list.get(i);
            T ij = list.get(j);
            list.set(i, ij);
            list.set(j, ii);
        }
    }
}
