package assignment04.exercise03;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random(42L);

        ArrayList<Tuple> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Tuple(random.nextInt(10),random.nextInt(10)+10));
        }

        for(Tuple t: list) {
            System.out.println(t.getA());
        }

    }
}


