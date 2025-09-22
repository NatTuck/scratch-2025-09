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
        //System.out.println("Contains 7? " + 
        //        (listContains7(xs) ? "yes" : "no"));
    }

    static int smallest(List<Integer> xs) {
        return xs.get(0); // O(n), counter argument: this is best case O(1)
    } // O(1)
    
    static int median(List<Integer> xs) {
        return xs.get(xs.size() / 2);  // n/2 operations => O(n)
    }

    static boolean containsSevenFast(List<Integer> xs) {
        // binary search: O(log n)

        int ii = xs.size() / 2;
        while (...) {
            int xx = xs.get(ii);
            if (xx == 7) {
                return true;
            }
            if (xx > 7) {
                // look at bottom half
            }
            if (xx < 7) {
                // look at top half
            }
        }
        return false;
    }


    static boolean containsSeven(List<Integer> xs) {
        // xs is an ArrayList of length N
        for (int ii = 0;  // 1

                ii < xs.size();   // up to N + 1 times
                ++ii) {  // up to N times
            int xx = xs.get(ii);  // O(1) - maybe 4 ops

            if (xx == 7) { // 1 * up to N
                return true; // at most once
            }
        }
        return false; // at most once
    }

    // best case 8 operations - O(1)
    // worst case 4*n + 3 operations - O(n)
    // average case (if 7 in list) (4*n/2) + 3 = O(n)

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
