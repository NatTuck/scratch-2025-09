package lab05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.Color;

public class MissileShould {
    private Missile missile;

    @BeforeEach
    void setUp() {
        missile = new Missile(100, 0, 100, 580, 5); // Missile targeting bottom of screen
    }

    @Test
    void move_toward_target() {
        Missile moved = missile.tick();
        assertTrue(moved.getY() > 0); // Moving downward
        assertFalse(moved.isExploded());
    }

    @Test
    void explode_when_reaches_target() {
        // Create a missile very close to target
        Missile closeMissile = new Missile(100, 578, 100, 580, 5);
        Missile exploded = closeMissile.tick();
        assertTrue(exploded.isExploded());
    }

    @Test
    void disappear_after_explosion() {
        // Create an exploded missile with explosionRadius = 0
        Missile exploded = new Missile(100, 580, 100, 580, 0);
        // Tick 16 times to make explosionRadius = 32 (16 * 2), which is > 30
        for (int i = 0; i < 16; i++) {
            exploded = exploded.tick();
            if (exploded == null) {
                return; // Test passes - missile disappeared
            }
        }
        // If we get here, it didn't disappear
        assertNull(exploded, "Missile should disappear after explosion");
    }

    @Test
    void detect_collision_with_laser() {
        assertFalse(missile.collidesWith(200, 200, 5));
        assertTrue(missile.collidesWith(100, 0, 5)); // Missile at start position
    }

    @Test
    void have_correct_color() {
        assertEquals(Color.RED, missile.getColor());
    }
}
