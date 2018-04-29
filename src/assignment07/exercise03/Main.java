// Loris Witschard & Nicolas Bovet
package assignment07.exercise03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(random.nextInt(10));
        }

        removeEvilEvenNumbers1(arrayList);
        removeEvilEvenNumbers2(arrayList);
        removeEvilEvenNumbers3(arrayList);
    }

    private static void removeEvilEvenNumbers1(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) % 2 == 0){
                arrayList.remove(i);
            }
        }
    }

    private static void removeEvilEvenNumbers2(ArrayList<Integer> arrayList) {
        for(Iterator<Integer> it = arrayList.iterator(); it.hasNext();)
            if (it.next() % 2 == 0)
                it.remove();
    }

    private static void removeEvilEvenNumbers3(ArrayList<Integer> arrayList) {
        arrayList.removeIf(i -> i % 2 == 0);
    }
}
