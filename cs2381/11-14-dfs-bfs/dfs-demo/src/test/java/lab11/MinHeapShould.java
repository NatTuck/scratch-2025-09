package lab11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapShould {
    @Test
    void order_by_string_length() {
        var xs = new MinHeap<String>((aa, bb) -> aa.length() - bb.length());
        xs.add("1");
        xs.add("three");
        assertEquals("1", xs.poll());

        xs.add("fourfour");
        xs.add("two");
        xs.add("fivefive5");

        assertEquals("two", xs.poll());
        assertEquals("three", xs.peek());
        assertEquals("three", xs.poll());
        assertEquals("fourfour", xs.poll());
        assertEquals("fivefive5", xs.poll());
        assertEquals(null, xs.peek());
        assertEquals(null, xs.poll());
    }

    @Test
    void order_naturally() {
        var xs = new MinHeap<String>((aa, bb) -> aa.compareTo(bb));

        xs.add("Missouri");
        xs.add("Georgia");
        xs.add("Oregon");
        assertEquals("Georgia", xs.peek());

        xs.add("Nevada");
        assertEquals("Georgia", xs.poll());

        xs.add("Washington");
        xs.add("Arkansas");

        assertEquals("Arkansas", xs.poll());
        assertEquals("Missouri", xs.poll());
        assertEquals("Nevada", xs.poll());
        assertEquals("Oregon", xs.poll());
        assertEquals("Washington", xs.poll());
    }
}

