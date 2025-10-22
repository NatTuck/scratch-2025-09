package dslabs;

import java.lang.reflect.Array;

public class HashMap<K, V> {
  List<Entry<K, V>>[] data;
  int size;

  Entry<K, V> empty;
  Entry<K, V> tomb;

  public HashMap() {
    this.empty = new Empty<K, V>();
    this.tomb = new Tomb<K, V>();

    this.data = newArray(4);
    this.size = 0;

    for (int ii = 0; ii < this.data.length; ++ii) {
      this.data[ii] = empty;
    }
  }

  @SuppressWarnings("unchecked")
  Entry<K, V>[] newArray(int nn) {
    return (Entry<K, V>[]) Array.newInstance(Entry.class, nn);
  }

  public void growTable() {
    // Save the existing data
    var oldData = this.data;

    // Make this an empty map, with twice as large
    // an array
    this.data = newArray(this.data.length * 2);
    this.size = 0;

    for (int ii = 0; ii < this.data.length; ++ii) {
      this.data[ii] = empty;
    }

    // Table is reset, now insert all old data.
    for (int ii = 0; ii < oldData.length; ++ii) {
      if (oldData[ii].isEntry()) {
        this.put(oldData[ii].key(), oldData[ii].val());
      }
    }
  }

  public void put(K key, V val) {
    // Linear probing load factors can probably be
    // as high as ~0.7 without killing performance.
    if (this.loadFactor() >= 0.5) {
      growTable();
    }

    int code = key.hashCode();

    for (int ii = 0; ii < this.data.length; ++ii) {
      int slot = Math.floorMod(code + ii, this.data.length);
    
      if (this.data[slot].isEmpty() || this.data[slot].isTomb()) {
        this.size += 1;
        this.data[slot] = new Pair<>(key, val);
        return;
      }
    }
    
    // Should never happen, because load factor shouldn't
    // approach 1.
    throw new RuntimeException("table full");
  }

  public V get(K key) {
    int code = key.hashCode();

    for (int ii = 0; ii < this.data.length; ++ii) {
      int slot = Math.floorMod(code + ii, this.data.length);
   
      var ent = this.data[slot];
      
      if (ent.isEmpty()) {
        break; 
      }
      
      if (!ent.isEmpty() && !ent.isTomb() && ent.key().equals(key)) {
        return this.data[slot].val();
      }  
    }
    
    System.out.println("get: No such key " + key.toString());
    return null;
  }

  public void delete(K key) {
    int code = key.hashCode();
    
    for (int ii = 0; ii < this.data.length; ++ii) {
      int slot = Math.floorMod(code + ii, this.data.length);

      var ent = this.data[slot];

      if (ent.isEmpty()) {
        break; 
      }
      
      if (ent.isEntry() && ent.key().equals(key)) {
        this.size = this.size - 1;
        this.data[slot] = this.tomb;
        return;
      }  
    }
   
    // Replace exception for demo.
    // throw new RuntimeException("no such key");
    System.out.println("delete: No such key " + key.toString());
  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return this.data.length;
  }

  public double loadFactor() {
    return ((double)this.size) / this.data.length;
  }
}

interface Entry<K, V> {
  default boolean isEmpty() { return false; }
  default boolean isTomb() { return false; }
  default boolean isEntry() { return false; }
  K key();
  V val();
}

record Empty<K, V>() implements Entry<K, V> {
  public boolean isEmpty() {
    return true;
  }
 
  public K key() {
    throw new RuntimeException("empty");  
  }
  
  public V val() {
    throw new RuntimeException("empty");  
  }
}

record Tomb<K, V>() implements Entry<K, V> {
  public boolean isTomb() {
    return true;
  }
  
  public K key() {
    throw new RuntimeException("tomb");  
  }
  
  public V val() {
    throw new RuntimeException("tomb");  
  }
}

record Pair<K, V>(K key, V val) implements Entry<K, V> {
  public boolean isEntry() {
    return true;
  }
}
