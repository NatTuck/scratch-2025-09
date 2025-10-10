package lab05;

public class App {
    public static void main(String[] args) {
        TreeSet<Integer> aa = new TreeEmpty<Integer>();
        for (int ii = 0; ii < 10; ++ii) {
            aa = aa.add(ii);
        }

        System.out.println("size = " + aa.size());
        System.out.println("height = " + aa.height());
        System.out.println("tree =\n" + aa);
    }
}
