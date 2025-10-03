package lab05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

public class AppShould {
    private App app;
    private GfxWindow gw;
    private Color blue;
    private Color red;

    @BeforeEach
    void setUp() {
        blue = GfxWindow.stringToColor("blue");
        red = GfxWindow.stringToColor("red");
        app = new App();
        gw = new MockGfxWindow(app, 800, 600);
        Dimension dim = new Dimension(400, 300);
        gw.setSize(dim);
    }

    @Test
    void move_balls_on_tick() {
        var b1 = new Ball(blue, 100, 100, 10, 10);
        app.balls.add(b1);
        app.onTick(gw, 5);

        assertEquals(1, app.balls.size());
        var b2 = app.balls.get(0);
        assertEquals(new Ball(blue, 110, 110, 10, 9), b2);
    }

    @Test
    void delete_oob_balls() {
        app.balls.addAll(List.of(
            new Ball(blue, 100, 100, 10, 10),
            new Ball(red, -25, 100, 10, 10),   // x < 0, should be removed
            new Ball(blue, 25, -25, 10, 10),   // y < 0, should be removed
            new Ball(blue, 25, 900, 10, 10),   // y > height, should be removed
            new Ball(red, 900, 25, 10, 10),    // x > width, should be removed
            new Ball(blue, 300, 200, -10, -10) // Still in bounds, should remain
        ));

        app.onTick(gw, 5);

        assertEquals(2, app.balls.size()); // Only 2 should remain (first and last)

        // Check that remaining balls are the correct ones
        // The first ball (100, 100) and last ball (300, 200) should remain
        boolean foundFirst = false;
        boolean foundLast = false;
        
        for (var ball : app.balls) {
            if (ball.getX() == 110 && ball.getY() == 110) { // After tick: (100+10, 100+10)
                foundFirst = true;
            }
            if (ball.getX() == 290 && ball.getY() == 190) { // After tick: (300-10, 200-10)
                foundLast = true;
            }
        }
        
        assertTrue(foundFirst);
        assertTrue(foundLast);
    }

    @Test
    void create_cities_on_initialization() {
        assertEquals(6, app.cities.size());
        for (City city : app.cities) {
            assertEquals(580, city.getY()); // Cities at bottom (near 600px height)
            assertTrue(!city.isDestroyed());
        }
    }

    @Test
    void spawn_missiles_periodically() {
        assertEquals(0, app.missiles.size());
        app.onTick(gw, 60); // Should spawn a missile
        assertEquals(1, app.missiles.size());
    }

    @Test
    void handle_laser_shooting() {
        assertEquals(0, app.balls.size());
        app.onMouse(gw, 200, 300, 1);
        assertEquals(1, app.balls.size());
    }

    @Test
    void reset_game_on_r_key() {
        app.balls.add(new Ball(blue, 100, 100, 10, 10));
        app.missiles.add(new Missile(100, 100, 200, 200, 2));
        app.score = 100;
        
        app.onKey(gw, "r");
        
        assertEquals(0, app.balls.size());
        assertEquals(0, app.missiles.size());
        assertEquals(0, app.score);
        assertEquals(6, app.cities.size());
    }

    // Mock class to avoid issues with the graphics window in tests
    private static class MockGfxWindow extends GfxWindow {
        MockGfxWindow(GfxApp app, int width, int height) {
            super(app, width, height);
        }

        @Override
        public int getHeight() {
            return 600;
        }

        @Override
        public int getWidth() {
            return 800;
        }
    }
}
