package dslabs;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        var nums = new ArrayList<>(List.of(1,2,3,4,5));
        var retv = tuna(nums);
        System.out.printf("squid => %d, crab => %d\n", retv.xx(), retv.yy());
    }

    static Pair tuna(ArrayList<Integer> xs) {
        var sq = squid(xs);
        var cr = crab(xs);
        return new Pair(sq, cr);
    }

    static int squid(ArrayList<Integer> xs) {
        if (xs.isEmpty()) {
            return 3;
        }
        var aa = xs.get(0);
        xs.remove(0);
        return aa + squid(xs);
    }

    static int crab(ArrayList<Integer> xs) {
        var yy = 3;
        for (var xx : xs) {
            yy += xx;
        }
        return yy;
    }
    
    static List<Integer> keepUnique(List<Integer> xs) {
       // Build and return a new ArrayList containing
       // each item from xs only once.
       
       // Examples: 
       //  - keepUnique([1,1,1,1,1,2,1,1,2]) -> [1,2]
       //  - keepUnique([1,2,1,5,3,2,3,4,5]) -> [1,2,5,3,4]
       return List.of();
    }
}

record Pair(int xx, int yy) {
    // pass
}
