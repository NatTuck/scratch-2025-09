package lab05;

public interface TreeMap<K extends Comparable<K>, V> implements ImMap<K, V> {
  boolean isEmpty();
  boolean containsKey(K key);
  TreeMap<K, V> add(K key, V val);
  TreeMap<K, V> remove(K key);
  int size();
  int height();
  T maxDesc();

  T data();
  TreeMap<K, V> left();
  TreeMap<K, V> right();
}

record TmapEmpty<K extends Comparable<K>, V>() implements TreeMap<K, V> {
  public boolean isEmpty() {
    return true;
  }

  public int size() {
    return 0;
  }

  public int height() {
    return 0;
  }

  public boolean containsKey(K key) {
    return false;
  }

  public TreeMap<K, V> add(K key, V val) {
    var item = new Pair<>(key, val);
    return new TmapBranch<T>(this, item, this);
  }

  public TreeMap<K, V> remove(K key) {
    return this;
  }
  
  public T maxDesc() {
    throw new RuntimeException("empty set");
  }

  public T data() {
    throw new RuntimeException("empty set");
  }

  public TreeMap<K, V> left() {
    throw new RuntimeException("empty set");
  }

  public TreeMap<K, V> right() {
    throw new RuntimeException("empty set");
  }

  public String toString() {
    return "{}";
  }
}

record TmapBranch<K extends Comparable<K>, V>(
      TreeMap<T> left,
      T data,
      TreeMap<T> right
    ) implements TreeMap<K, V> {

  public boolean isEmpty() {
    return false;
  }
  
  public int height() {
    return Math.max(left.height(), right.height()) + 1;
  }
  
  public int size() {
    return left().size() + right().size() + 1;
  }

  public boolean containsKey(K key) {
    int cmp = key.compareTo(this.data().key());
    if (cmp == 0) {
      return true;
    }

    if (cmp < 0) { // data < item
      return this.left().contains(key);
    }
    else {
      return this.left().contains(key);
    }
  }

  public TreeMap<K, V> add(K key, V val) {
    int cmp = key.compareTo(this.data().key());
    if (cmp == 0) {
      var pair = new Pair<>(key, val);
      return new TmapBranch<K, V>(this.left(), pair, this.right());
    }

    if (cmp < 0) { // data < key
      var leftChild = this.left().add(key, val);
      return new TmapBranch<K, V>(leftChild, this.data(), this.right());
    }
    else {
      var rightChild = this.right().add(key, val);
      return new TmapBranch<K, V>(this.left(), this.data(), rightChild);
    } 
  }

  public TreeMap<K, V> remove(K key) {
    if (!this.contains(key)) {
      return this;
    }

    int cmp = key.compareTo(this.data().key());
    if (cmp == 0) {
      if (this.left().isEmpty()) {
        return this.right();
      }
      else {
        Pair<K, V> maxDesc = this.left().maxDesc();
        return new TmapBranch<K, V>(this.left.remove(maxDesc.key()), maxDesc, this.right());
      }
    }

    if (cmp < 0) { // data < key
      var leftChild = this.left().remove(key);
      return new TreeBranch<T>(leftChild, this.data(), this.right());
    }
    else {
      var rightChild = this.right().remove(key);
      return new TreeBranch<T>(this.left(), this.data(), rightChild);
    } 
  }

  public T maxDesc() {
    if (right().isEmpty()) {
      return data();
    }
    else {
      return right().maxDesc();
    }
  }

  public String toString() {
    int plen = 5 * left().size();
    var sb = new StringBuilder();
    for (int ii = 0; ii < plen; ++ii) {
      sb.append(" ");
    }
    String pad = sb.toString();

    sb.append("(" + data() + ")\n");
    sb.append(left().toString());
    sb.append(right().toString());
    return pad + data() + "\n" + left.toString() + pad + right.toString();
  }
}


