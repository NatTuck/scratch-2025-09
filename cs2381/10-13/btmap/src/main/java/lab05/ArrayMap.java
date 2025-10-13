package lab05;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayMap<K extends Comparable<K>, V> implements Map<K, V> {
  ArrayList<Pair<K, V>> data = new ArrayList<Pair<K, V>>();

  public void put(K key, V val) {  // O(n)
    var pair = new Pair<>(key, val);
    int ii = Collections.binarySearch(data, pair);  // O(log n)
    if (ii < 0) {
      ii = -(ii + 1);
      data.add(ii, pair);  // O(n)
    }
    else {
      data.set(ii, pair); // O(1)
    }
  }

  public V get(K key) {
    for (var pair : data) {
      if (pair.key().compareTo(key) == 0) {
        return pair.val();
      }
    }
    throw new RuntimeException("key not found");
  }

  public boolean containsKey(K key) {
    for (var pair : data) {
      if (pair.key().compareTo(key) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void delete(K key) {
    for (int ii = 0; ii < data.size(); ++ii) {
      var pair = data.get(ii);
      if (pair.key().compareTo(key) == 0) {
        data.remove(ii);
        return;
      }
    }
  }
}

record Pair<K extends Comparable<K>, V>(K key, V val) 
        implements Comparable<Pair<K, V>> {
  @Override
  public int compareTo(Pair<K, V> other) {
    return this.key().compareTo(other.key());
  }
}
