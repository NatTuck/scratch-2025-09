package dslabs;

public class App {
    public static void main(String[] args) {
        for (int hh = 1; hh <= 10; ++hh) {
            int yy = runTest(80, hh, 10);
            System.out.println("for hh = " + hh + ", count = " + yy);
        }
    }

    static int runTest(int nn, int hh, int cc) {
        var ff = new BloomFilter2(nn, hh);

        for (int ii = 0; ii < cc; ++ii) {
            ff.insert("a" + ii);
        }
 
        int count = 0;

        for (int ii = 0; ii < 100; ++ii) {
            if (ff.contains("b" + ii)) {
                count += 1;
            }
        }

        System.out.println("countTrue = " + ff.countTrue());
        return count;
    }
    
    public static void main1(String[] args) {
        var f1 = new BloomFilter2(40, 1);
        var f2 = new BloomFilter2(40, 2);
        var f3 = new BloomFilter2(40, 3);

        for (int ii = 0; ii < 10; ++ii) {
            f1.insert("a" + ii);
            f2.insert("a" + ii);
            f3.insert("a" + ii);
        }

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int ii = 0; ii < 100; ++ii) {
            if (f1.contains("b" + ii)) {
                count1 += 1;
            }
            if (f2.contains("b" + ii)) {
                count2 += 1;
            }
            if (f3.contains("b" + ii)) {
                count3 += 1;
            }
        }

        System.out.println("f1 collsions / 100 = " + count1);
        System.out.println("f2 collsions / 100 = " + count2);
        System.out.println("f3 collsions / 100 = " + count3);
    }
}
