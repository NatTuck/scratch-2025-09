package dslabs;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Collections;

public class App {
    public static void main(String[] _args) {
        var xs = sortedInts(20);

        System.out.println(xs);
        System.out.println("Contains 7? " + 
                (listContains(xs, 7) ? "yes" : "no"));
    }

    static List<Integer> sortedInts(int nn) {
        var rand = new Random();

        var ys = new ArrayList<Integer>();

        for (int ii = 0; ii < nn; ++ii) {
            ys.add(rand.nextInt(1000));
        }

        Collections.sort(ys);

        return ys;
    }
}
