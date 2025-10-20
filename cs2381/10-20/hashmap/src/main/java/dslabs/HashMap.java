package dslabs;

import java.lang.reflect.Array;

class HashMap<K, V> {
  Entry<K, V>[] data;
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

  public void put(K key, V val) {
    int code = key.hashCode();

    for (int ii = 0; ii < this.data.length; ++ii) {
      int slot = Math.floorMod(code, this.data.length + ii);
    
      if (this.data[slot].isEmpty() || this.data[slot].isTomb()) {
        this.size += 1;
        this.data[slot] = new Pair<>(key, val);
        return;
      }
    }
      
    throw new RuntimeException("table full");
  }

  public V get(K key) {
    int code = key.hashCode();

    int code = key.hashCode();

    for (int ii = 0; ii < this.data.length; ++ii) {
      int slot = Math.floorMod(code, this.data.length + ii);
    
      var ent = this.data[slot];
      
      if (!ent.isEmpty() && !ent.isTomb() && ent.key().equals(key)) {
        return this.data[slot].val();
      }  
    }
    
    throw new RuntimeException("no such key");
  }

  public int size() {
    return this.size;
  }
}

interface Entry<K, V> {
  boolean isEmpty();
  boolean isTomb();
  K key();
  V val();
}

record Empty<K, V>() implements Entry<K, V> {
  public boolean isEmpty() {
    return true;
  }
 
  public boolean isTomb() {
    return false;
  }

  public K key() {
    throw new RuntimeException("empty");  
  }
  
  public V val() {
    throw new RuntimeException("empty");  
  }
}

record Tomb<K, V>() implements Entry<K, V> {
  public boolean isEmpty() {
    return false;
  }
  
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
  public boolean isEmpty() {
    return false;
  }
  
  public boolean isTomb() {
    return false;
  }
}
