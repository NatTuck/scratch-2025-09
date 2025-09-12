

class ArrayList<E> implments List<E> {
  Object[] data;  // this knows its own size
  int size;

  void add(E item) {
    data1 = new Object[data.length + 1];
    for (int ii = 0; ii < data.length; ++ii) {
      data1[ii] = data[ii];
    }
    data1[data.length] = item;
    this.data = data1;
  }
}

// problem:

class Problem {
  static void example(int nn) {
    ArrayList<Integer> xs = new ArrayList<Integer>();

    for (int ii = 0; ii < nn; ++ii) {
      xs.add(ii);
    }
  }
}
