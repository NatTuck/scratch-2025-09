package lab05;

public interface Map<K extends Comparable<K>, V> {
  void put(K key, V val);
  V get(K key);
  boolean containsKey(K key);
  void delete(K key);
}
