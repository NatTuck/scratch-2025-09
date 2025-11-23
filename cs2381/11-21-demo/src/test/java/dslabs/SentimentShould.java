package dslabs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SentimentShould {
    private final Sentiment sentiment = new Sentiment();

    @Test
    void classify_puppy_comments_support_ban() {
        assertTrue(sentiment.supportsPuppyBan("I hate puppies. Ban them all."));
        assertTrue(sentiment.supportsPuppyBan("Puppies are terrible. We should ban them."));
        assertTrue(sentiment.supportsPuppyBan("These dogs are dangerous. Ban them all now."));
        assertTrue(sentiment.supportsPuppyBan("Puppies destroy gardens. They should be banned."));
        assertTrue(sentiment.supportsPuppyBan("I support the puppy ban ordinance."));
    }

    @Test
    void classify_puppy_comments_oppose_ban() {
        assertFalse(sentiment.supportsPuppyBan("I love puppies. They're adorable."));
        assertFalse(sentiment.supportsPuppyBan("Puppies are wonderful. Don't ban them."));
        assertFalse(sentiment.supportsPuppyBan("These cute dogs bring joy. No to puppy bans."));
        assertFalse(sentiment.supportsPuppyBan("Dogs are great companions. Keep them all legal."));
        assertFalse(sentiment.supportsPuppyBan("I oppose the puppy ban proposal."));
    }
}
