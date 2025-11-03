package dslabs;

public class BloomFilter1 {
  BitList data;

  BloomFilter1(int nn) {
    data = new BitList();
    data.setSize(nn);
  }

  void insert(Object obj) {
    int bb = Math.floorMod(hx(obj, 1), size());
    data.set(bb, true);
  }

  boolean contains(Object obj) {
    int bb = Math.floorMod(hx(obj, 1), size());
    return data.get(bb); 
  }

  int size() {
    return this.data.size();
  }

  static int hx(Object obj, int hash_no) {
    int baseHash = obj.hashCode();
    int yy = ((baseHash * hash_no * 65537) >> hash_no) + baseHash;
    return yy;
  }
}
