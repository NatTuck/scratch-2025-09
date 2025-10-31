package dslabs;

public class BloomFilter {
  BitList data;

  BloomFilter(int nn) {
    data = new BitList();
    data.setSize(nn);
  }

  void insert(Object obj) {
    int bb = Math.floorMap(hx(obj, 0), size());
    data.set(bb);
  }

  boolean contains(Object obj) {
    int bb = Math.floorMap(hx(obj, 0), size());
    return data.get(bb); 
  }

  int size() {
    return this.data.size();
  }

  static int hx(Object obj, int hash_no) {
    int baseHash = obj.hashCode();
    return (baseHash + hash_no) * 65537 + baseHash * 3;
  }


}
