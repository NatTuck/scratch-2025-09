package dslabs;

class BitList {
  // Each byte will contain 8 bits;
  byte[] data;
  int size;

  BitList() {
    this.data = new byte[1];
    this.size = 0;
  }

  boolean get(int ii) {
    int di = ii / 8;
    int bi = Math.floorMod(ii, 8);
    return ((this.data[di] >> bi) & 1) != 0;
  }

  void set(int ii, boolean vv) {
    // System.out.println("Set index " + ii + " to " + vv);
    if (this.size <= ii) {
      setSize(ii + 1);
    }

    int di = ii / 8;
    byte bi = (byte) Math.floorMod(ii, 8);
   
    if (vv) {
      // set bit bi
      this.data[di] = (byte)(this.data[di] | (1 << bi));
    }
    else {
      // clear bit bi
      this.data[di] = (byte)(this.data[di] & ~(1 << bi));
    }

    // System.out.println("Result: index " + ii + " = " + get(ii));
  }

  void add(boolean vv) {
    set(this.size, vv);   
  }

  void setSize(int nn) {
    this.size = nn;

    if (nn <= capacity()) {
      return;
    }

    // Documentation bug:
    //  - We're doing set size.
    //  - Even if user wanted shrink, we always 
    //    grow capacity.
    int newCap = (int)Math.ceil(nn / 8.0);
    if (newCap < 2 * this.data.length) {
      newCap = 2 * this.data.length;
    }

    byte[] oldData = this.data;
    this.data = new byte[newCap];

    int minLen = Math.min(oldData.length, this.data.length);
    for (int ii = 0; ii < minLen; ++ii) {
      this.data[ii] = oldData[ii];
    }
  }
 
  int capacity() {
    return 8 * this.data.length;
  }

  int size() {
    return size;
  }
}
