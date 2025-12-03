package demo;

public class EditorData {
  Node root;
  Node current_line;

  EditorData(String path) {
    // read file into structure
  }

  void deleteCurrentLine() {
    // FIXME: What if no next line, do prev.
    var next = current_line.next();
    current_line.delete();
    current_line = next;
  }
}

interface Node {
  void delete();
}

class Branch {
  Node parent;
  Node left;
  String line; 
  int size; 
  Node right;

  void delete() {
    int lsz = left.size()
    int rsz = right.size()

    if (lsz > rsz) {
      if (parent.left == this) {
        parent.left = this.left;
        this.left.parent = parent;
      }
      else {
        parent.right = this.left;
        this.right.parent = parent;
      }
      this.left.insertFarRight(this.right);
    }
    else {
      if (parent.left == this) {
        parent.left = this.right;
        this.left.parent = parent;
      }
      else {
        parent.right = this.right;
        this.right.parent = parent;
      }
      // This will never increase tree height.
      // But might want to save one level, so
      // we do need to worry about balancing.
      // This needs to fix parent for this.left
      this.right.insertFarLeft(this.left);
    }
  }
}

record Empty() {

}
