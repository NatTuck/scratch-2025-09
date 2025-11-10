package dslabs;

import java.util.List;
import java.util.ArrayList;

public class Primes {
  static long countPrimes(long nn) {
    List<Long> ys = findPrimes(nn);
    return ys.size();
  }

  static List<Long> findPrimes(long nn) {
    var ys = new ArrayList<Long>();
    ys.add(2L);
    ys.add(3L);
    ys.add(5L);

    for (long ii = 7; ii < nn; ii = ii + 2) {
      if (isPrime(ii, ys)) {
        ys.add(ii);
      }
    }

    // Mult-threading strategy:
    // - Calculate primes up to sqrt(nn) sequentially.
    // - Then split into P threads to check the rest
    //   of the numbers.

    return ys;
  }

  static boolean sieveRange(long nn) {
    var sieve = new BitList(nn); // default false
    sieve.set(2, true);

    for (long ii = 2; ii < nn; ++ii) {
      if (sieve.get(ii)) {
        mark(sieve, ii, nn);
      }
    }
  }

  static void mark(BitList sieve, ii, nn) {
    long jj = ii; 
    while (jj * jj =< nn) {
      sieve.set(jj, true);
      jj += ii;
    }
  }

  static boolean isPrime(long xx, List<Long> primes) {
    for (var pr : primes) {
      if (pr * pr > xx) {
        break;
      }
      if (xx % pr == 0) {
        return false;
      }
    }
    return true;
  }

  // findPrimes(10) => [2, 3, 5, 7]
}
