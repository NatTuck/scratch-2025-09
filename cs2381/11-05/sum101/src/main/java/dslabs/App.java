package dslabs;

public class App {
    static final long BB = 1000 * 1000 * 1000;
    static long sum;
    static long npp;

    static Object mutex;

    public static void main(String[] args) throws Exception {
        npp = BB / 10;
        sum = 0L;

        mutex = new Object();

        var workers = new Thread[10];

        for (int ww = 0; ww < 10; ++ww) {
            workers[ww] = new Thread(new Worker(ww));
            workers[ww].start();
        }

        for (int ww = 0; ww < 10; ++ww) {
            workers[ww].join();
        }

        System.out.println("sum = " + sum);
    }
}

class Worker implements Runnable {
    int wnum;

    Worker(int wnum) {
        this.wnum = wnum;
    }

    public void run() {
        long i0 = wnum * App.npp;
        long i1 = i0 + App.npp;

        long sum = 0L;

        for (long ii = i0; ii < i1; ++ii) {
            if (ii % 101 == 0) {
                sum += ii;
            }
        }

        synchronized (App.mutex) {
            App.sum += sum;
        }
    }
}


