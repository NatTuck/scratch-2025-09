package lab05;

public interface ImMap<K extends Comparable<K>, V> {
  ImMap<K, V> put(K key, V val);
  V get(K key);
  boolean containsKey(K key);
  ImMap<K, V> delete(K key);
}
