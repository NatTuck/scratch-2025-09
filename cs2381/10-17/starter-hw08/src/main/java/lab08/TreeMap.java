package lab08;

import java.util.function.Consumer;
import java.util.ArrayList;

public class TreeMap<K extends Comparable<K>, V> {
    TreeNode<K, V> root;
    int size;
    int maxSize;

    public TreeMap() {
        this.root = new TreeEmpty<K, V>();
        this.size = 0;
        this.maxSize = 0;
    }

    int size() {
        return this.size;
    }

    boolean hasKey(K key) {
        return root.hasKey(key);
    }

    V get(K key) {
        return root.get(key);
    }

    void insert(K key, V val) {
        this.root = this.root.insert(key, val);
        /*
        if (addedItem) {
            this.size += 1;
            this.maxSize = Math.max(this.size, this.maxSize);
        }
        if (needsRebalance) {
            this.root = this.root.rebalance();
        }
        */
    }

    void delete(K key) {
        if (!this.root.hasKey(key)) {
            return;
        }

        this.root = this.root.delete(key);
        this.size -= 1;
    }

    ArrayList<K> keys() {
        var ys = new ArrayList<K>();
        for (var ee: this.toList()) {
            ys.add(ee.key());
        }
        return ys;
    } 

    int height() {
        return root.height();
    }

    void eachEntry(Consumer<Entry<K, V>> op) {
        root.eachEntry(op);
    }

    ArrayList<Entry<K, V>> toList() {
        return root.toList();
    }

    @Override
    public String toString() {
        return String.format("{size=%d maxSize=%d %s}",
                             this.size,
                             this.maxSize,
                             this.root.toString());
    }

    int maxDepth() {
        return (int)(Math.ceil(2 * log2(this.size + 2)));
    }

    static double log2(double xx) {
        return Math.log(xx) / Math.log(2.0);
    }
}

interface TreeNode<K extends Comparable<K>, V> {
    boolean isEmpty();

    boolean hasKey(K key);

    TreeNode<K, V> insert(K key, V val);

    V get(K key);

    TreeNode<K, V> delete(K key);

    TreeNode<K, V> merge(TreeNode<K, V> other);

    Entry<K, V> data();

    TreeNode<K, V> left();

    TreeNode<K, V> right();

    int size();

    int height();

    TreeNode<K, V> rebalance();

    void eachEntry(Consumer<Entry<K, V>> op);

    default ArrayList<Entry<K, V>> toList() {
        var ys = new ArrayList<Entry<K, V>>();
        this.eachEntry((xx) -> ys.add(xx));
        return ys;
    }

    static <K extends Comparable<K>, V> TreeNode<K, V>
          fromList(ArrayList<Entry<K, V>> ents, int i0, int i1) {

        // Given a list, return a balanced tree.

        return new TreeEmpty<K, V>();
    }
}

record TreeEmpty<K extends Comparable<K>, V>() implements TreeNode<K, V> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean hasKey(K _key) {
        return false;
    }

    @Override
    public TreeNode<K, V> insert(K key, V val) {
        // depth += 1;
        // addedItem = true;
        // if (depth > maxDepth) { needsRebalance = true; }
        return new TreeBranch<K, V>(new Entry<K, V>(key, val), this, this);
    }

    @Override
    public V get(K key) {
        throw new RuntimeException("no such key");
    }

    @Override
    public TreeNode<K, V> delete(K _key) {
        return this;
    }

    @Override
    public TreeNode<K, V> merge(TreeNode<K, V> that) {
        return that;
    }

    @Override
    public Entry<K, V> data() {
        throw new RuntimeException("leaf");
    }

    @Override
    public TreeNode<K, V> left() {
        throw new RuntimeException("leaf");
    }

    @Override
    public TreeNode<K, V> right() {
        throw new RuntimeException("leaf");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public TreeNode<K, V> rebalance() {
        return this;
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void eachEntry(Consumer<Entry<K, V>> op) {
        // do nothing
    }
}

record TreeBranch<K extends Comparable<K>, V>(
            Entry<K, V> data, TreeNode<K, V> left, TreeNode<K, V> right)
        implements TreeNode<K, V> {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean hasKey(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return true;
        }
        if (cmp < 0) {
            return this.left.hasKey(key);
        }
        else {
            return this.right.hasKey(key);
        }
    }

    @Override
    public TreeNode<K, V> insert(K key, V val) {
        // depth += 1;

        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            var ent = new Entry<K, V>(key, val);
            return new TreeBranch<K, V>(ent, this.left, this.right);
        }

        TreeNode<K, V> node;

        if (cmp < 0) {
            node = new TreeBranch<K, V>(this.data,
                                       this.left.insert(key, val),
                                       this.right);
        }
        else {
            node = new TreeBranch<K, V>(this.data,
                                       this.left,
                                       this.right.insert(key, val));
        }

        // if needsRebalance and size(largerChild) / size(here) > 0.7
        // then we need to return a rebalanced node.
        return node;
    }

    @Override
    public V get(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.data().val();
        }
        if (cmp < 0) {
            return this.left.get(key);
        }
        else {
            return this.right.get(key);
        }
    }

    @Override
    public TreeNode<K, V> delete(K key) {
        int cmp = key.compareTo(this.data.key());
        if (cmp == 0) {
            return this.left.merge(this.right);
        }
        if (cmp < 0) {
            return new TreeBranch<K, V>(this.data,
                                    this.left.delete(key), this.right);
        }
        else {
            return new TreeBranch<K, V>(this.data,
                                    this.left, this.right.delete(key));
        }
    }

    @Override
    public TreeNode<K, V> merge(TreeNode<K, V> that) {
        if (that.isEmpty()) {
            return this;
        }

        return this.insert(that.data().key(), that.data().val())
            .merge(that.left())
            .merge(that.right());
    }

    @Override
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    @Override
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    @Override
    public TreeNode<K, V> rebalance() {
        // TODO: This should return a balanced subtree
        // containing the same entries as the current subtree.
        return this;
    }

    
    @Override
    public String toString() {
        var sb = new StringBuilder();
        if (this.left.isEmpty() && this.right.isEmpty()) {
            sb.append(" [");
            sb.append(this.data.key());
            sb.append(" => ");
            sb.append(this.data.val());
            sb.append("] ");
        }
        else {
            sb.append("(");
            sb.append(this.left.toString());
            sb.append(" [");
            sb.append(this.data.key());
            sb.append(" => ");
            sb.append(this.data.val());
            sb.append("] ");
            sb.append(this.right.toString());
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public void eachEntry(Consumer<Entry<K, V>> op) {
        this.left().eachEntry(op);
        op.accept(this.data());
        this.right().eachEntry(op); 
    }
}

