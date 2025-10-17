package lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeMapShould {
    @Test
    void do_basic_map_stuff() {
        var mm = new TreeMap<String, String>();
        mm.insert("dog", "woof");
        assertEquals("woof", mm.get("dog"));

        mm.insert("duck", "quack");
        mm.insert("cat", "meow");
        mm.insert("cow", "moo");
        assertEquals(4, mm.size());
        assertEquals("woof", mm.get("dog"));
        assertEquals("moo", mm.get("cow"));
        assertEquals("quack", mm.get("duck"));
        mm.insert("duck", "arf");
        assertEquals("arf", mm.get("duck"));

        var ee = assertThrows(RuntimeException.class, () -> mm.get("bear"));
        assertEquals("no such key", ee.getMessage());

        mm.delete("duck");
        mm.delete("cat");

        ee = assertThrows(RuntimeException.class, () -> mm.get("duck"));
        assertEquals("no such key", ee.getMessage());

        assertEquals("woof", mm.get("dog"));
        assertEquals("moo", mm.get("cow"));

        var ks0 = mm.keys();
        var ks1 = new ArrayList<String>();
        ks1.add("cow");
        ks1.add("dog");
        assertEquals(ks1, ks0);

        var ns = new TreeMap<Integer, String>();
        for (int ii = 0; ii < 101; ++ii) {
            int xx = ((ii + 1) * 4951) % 101;
            ns.insert(xx, "z" + xx);
        }
        assertEquals(101, ns.size());

        for (int ii = 0; ii < 101; ++ii) {
            assertEquals("z" + ii, ns.get(ii));
        }

        ns.delete(57);
        ns.delete(35);
        assertEquals(99, ns.size());
    }

    @Test
    void convert_subtree_to_list() {
        var leaf = new TreeEmpty<Integer, Integer>();
        var tree = new TreeBranch<>(
                new Entry<>(20, 1),
                new TreeBranch<>(
                        new Entry<>(10, 1),
                        leaf, leaf),
                new TreeBranch<>(
                        new Entry<>(40, 1),
                        new TreeBranch<>(
                                new Entry<>(30, 1),
                                leaf, leaf),
                        leaf));

        var xs = List.of(
                new Entry<>(10, 1),
                new Entry<>(20, 1),
                new Entry<>(30, 1),
                new Entry<>(40, 1));

        assertEquals(xs, tree.toList());
    }

    @Test
    void stay_balanced_on_insert() {
        var ns = new TreeMap<Integer, Integer>();
        for (int ii = 0; ii < 1000; ++ii) {
            assertEquals(ii, ns.size());
            ns.insert(ii, 10 * ii);
            int limit = (int) (2 * (2 + log2(ii + 1)));
            assertTrue(ns.height() <= limit);
        }

        for (int ii = 0; ii < 1000; ++ii) {
            assertEquals(10 * ii, ns.get(ii));
        }
    }

    @Test
    void stay_balanced_on_delete() {
        var ns = new TreeMap<Integer, Integer>();
        for (int ii = 0; ii < 1000; ++ii) {
            ns.insert(ii, 10 * ii);
        }

        for (int ii = 0; ii < 1000; ++ii) {
            assertEquals(10 * ii, ns.get(ii));
        }

        for (int ii = 0; ii < 950; ++ii) {
            ns.delete(ii);
            assertTrue(ns.size() < 1000 - ii);
            int limit = (int) (2 * (2 + log2(ns.size() + 1)));
            assertTrue(ns.height() <= limit);
        }

        for (int ii = 0; ii < 1000; ++ii) {
            assertEquals(ii >= 950, ns.hasKey(ii));
        }
    }

    static double log2(double xx) {
        return Math.log(xx) / Math.log(2.0);
    }
}
