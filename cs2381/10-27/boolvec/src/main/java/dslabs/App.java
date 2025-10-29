package dslabs;

public class App {
    public static void main(String[] args) {
        BitList xs = new BitList();

        for (int ii = 0; ii < 10; ++ii) {
            xs.add(ii % 3 == 0);
        }
        
        for (int ii = 0; ii < 8; ++ii) {
            System.out.println("At ii = " + ii + ": " + xs.get(ii));
        }
    }

    /*
    public static void main1(String[] args) {
        var xs = new ArrayList<Boolean>();
       
        // Why not this?
        //  - Can't use a primitive type as
        //    a type parameter.
        //var ys = new ArrayList<boolean>();

        for (int ii = 0; ii < 100; ++ii) {
            xs.push(ii % 7 == 0);
        }
    }
    */
}

// - Guess 1: 100 bytes (that's what C++ would do)
// - Optimal: 100 bits (or, really, 104 bits)
