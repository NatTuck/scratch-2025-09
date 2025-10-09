
public interface TreeSet<T extends Comparable<T>> {
  boolean isEmpty();
  boolean contains(T item);
  TreeSet<T> add(T item);
  TreeSet<T> remove(T item);

  T data();
  TreeSet<T> left();
  TreeSet<T> right();
}

record TreeEmpty<T extends Comparable<T>>() implements TreeSet<T> {
  public boolean isEmpty() {
    return true;
  }

  public boolean contains(T item) {
    return false;
  }

  public TreeSet<T> add(T item) {
    return new TreeBranch<T>(this, item, this);
  }

  public TreeSet<T> remove(T item) {
    return this;
  }

  public T data() {
    throw new RuntimeException("empty set");
  }

  public TreeSet<T> left() {
    throw new RuntimeException("empty set");
  }

  public TreeSet<T> right() {
    throw new RuntimeException("empty set");
  }
}

record TreeBranch<T extends Comparable<T>>(
      TreeSet<T> left,
      T data,
      TreeSet<T> right
    ) implements TreeSet<T> {

  public boolean isEmpty() {
    return false;
  }

  public boolean contains(T item) {
    int cmp = this.data().compareTo(item);
    if (cmp == 0) {
      return true;
    }

    if (cmp < 0) { // data < item
      return this.left().contains(item);
    }
    else {
      return this.left().contains(item);
    }
  }

  public TreeSet<T> add(T item) {
    if (this.contains(item)) {
      return this;
    }

    int cmp = this.data().compareTo(item);
    if (cmp == 0) {
      return this;
    }

    if (cmp < 0) { // data < item
      var leftChild = this.left().add(item);
      return new TreeBranch<T>(leftChild, this.data(), this.right());
    }
    else {
      var rightChild = this.right().add(item);
      return new TreeBranch<T>(this.left(), this.data(), rightChild);
    } 
  }

  public TreeSet<T> remove(T item) {
    if (!this.contains(item)) {
      return this;
    }

    int cmp = this.data().compareTo(item);
    if (cmp == 0) {
      T maxDesc = this.left().maxDesc();
      return new TreeBranch<T>(this.left.remove(maxDesc), maxDesc, this.right());
    }

    if (cmp < 0) { // data < item
      var leftChild = this.left().remove(item);
      return new TreeBranch<T>(leftChild, this.data(), this.right());
    }
    else {
      var rightChild = this.right().remove(item);
      return new TreeBranch<T>(this.left(), this.data(), rightChild);
    } 
  }
}


