package dslabs;

public class App {
    public static void main(String[] args) {
        long t0 = System.nanoTime();
        long nn = Primes.countPrimes(10 * 1000 * 1000);
        //var ys = Primes.findPrimes(100);
        long t1 = System.nanoTime();
        long ms = ((t1 - t0) / 1000000);
        System.out.printf("Found %d primes in %d ms.\n", nn, ms);
        //System.out.println(ys);
        //System.out.printf("Took %d ms\n", ms);
    }
}
