package dslabs;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        List<Integer> xs = randomInts(20000);

        //System.out.println("before: " + xs);

        long t1 = System.nanoTime();
        bubbleSort1(xs);
        long t2 = System.nanoTime();

        double dt = (t2 - t1) / 1000000000.0;

        if (isSorted(xs)) {
            System.out.println("sorted");
        }

        System.out.printf("that took %.03f seconds\n", dt);

        // System.out.println("after: " + xs);
    }

    static boolean isSorted(List<Integer> xs) {
        for (int jj = 0; jj < xs.size() - 1; jj++) {
            int vv0 = xs.get(jj);
            int vv1 = xs.get(jj + 1);
      
            if (vv0 > vv1) {
                return false;
            }
        }
        return true;
    }

    static void bubbleSort1(List<Integer> xs) {
        for (int ii = 0; ii < xs.size(); ++ii) {
            for (int jj = 0; jj < xs.size() - 1; jj++) {
                int vv0 = xs.get(jj);
                int vv1 = xs.get(jj + 1);

                if (vv0 > vv1) {
                    xs.set(jj, vv1);
                    xs.set(jj + 1, vv0);
                }
            }
        }
    }

    static void bubbleSort2(List<Integer> xs) {
        for (int ii = 0; ii < xs.size(); ++ii) {
            ListIterator<Integer> it = xs.listIterator();

            while (it.nextIndex() < xs.size() - 1) {
                int vv0 = it.next();
                int vv1 = it.next();

                if (vv0 > vv1) {
                    // swap
                    it.set(vv0);

                    it.previous();
                    it.previous();

                    it.set(vv1);

                    it.next();
                }
                else {
                    it.previous();
                }
            }
        }
    }

    static List<Integer> randomInts(int nn) {
        var rand = new Random();

        var ys = new ArrayList<Integer>();

        for (int ii = 0; ii < nn; ++ii) {
            ys.add(rand.nextInt(1000));
        }

        return ys;
    }
}
