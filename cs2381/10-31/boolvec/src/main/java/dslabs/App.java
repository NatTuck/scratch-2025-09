package dslabs;

public class App {
    public static void main(String[] args) {
        var ff = new BloomFilter(20);

        for (int ii = 0; ii < 10; ++ii) {
            ff.insert("a" + ii);
        }

        int count = 0;
        for (int ii = 0; ii < 100; ++ii) {
            if (ff.contains("b" + ii)) {
                count += 1;
            }
        }

        System.out.println("Collsions / 100 = " + count);
    }
}
