package dslabs;

public class App {
    public static void main(String[] args) {
        BitList xs = new BitList();

        for (int ii = 0; ii < 30; ++ii) {
            xs.add(ii % 3 == 0);
        }
        
        for (int ii = 0; ii < 30; ++ii) {
            System.out.println("At ii = " + ii + ": " + xs.get(ii));
        }
    }
}
