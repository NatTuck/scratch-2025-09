package dslabs;

public class BloomFilter2 {
  BitList data;
  int hh; 

  BloomFilter2(int nn, int hh) {
    data = new BitList();
    data.setSize(nn);
    this.hh = hh;
  }

  int countTrue() {
    int yy = 0;
    for (int ii = 0; ii < data.size(); ++ii) {
      if (data.get(ii)) {
        yy += 1;
      }
    }
    return yy;
  }



  void insert(Object obj) {
    for (int ii = 0; ii < hh; ++ii) {
      int bb = Math.floorMod(hx(obj, ii), size());
      data.set(bb, true);
    }
  }

  boolean contains(Object obj) {
    for (int ii = 0; ii < hh; ++ii) {
      int bb = Math.floorMod(hx(obj, ii), size());
      if (!data.get(bb)) {
        return false;
      }
    }
    return true;
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
