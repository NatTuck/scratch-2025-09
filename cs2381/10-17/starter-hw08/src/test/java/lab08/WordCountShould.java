package lab08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountShould {
    @Test
    void count_words_in_ten_file() {
        var wc = new WordCount("/ten.txt");
        assertEquals(3, wc.maxCount());
        assertEquals("six", wc.mostCommon());
        assertEquals(2, wc.getCount("two"));
        assertEquals(3, wc.getCount("six"));
        assertEquals(2, wc.getCount("eight"));
        assertEquals(1, wc.getCount("one"));
        assertEquals(1, wc.getCount("seven"));
    }

    @Test
    void count_words_in_jabberwocky_file() {
        var wc = new WordCount("/jabberwocky.txt");
        assertEquals(19, wc.maxCount());
        assertEquals("the", wc.mostCommon());
        assertEquals(19, wc.getCount("the"));
        assertEquals(2, wc.getCount("vorpal"));
        assertEquals(1, wc.getCount("galumphing"));
    }
}
