package lab05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

public class CityShould {
    private City city;

    @BeforeEach
    void setUp() {
        city = new City(100, 580); // City at bottom of screen
    }

    @Test
    void initialize_as_not_destroyed() {
        assertFalse(city.isDestroyed());
        assertEquals(100, city.getX());
        assertEquals(580, city.getY()); // City at bottom of screen
    }

    @Test
    void return_correct_color() {
        assertEquals(Color.GREEN, city.getColor());
        
        city.destroy();
        assertEquals(Color.GRAY, city.getColor());
    }

    @Test
    void destroy_city() {
        assertFalse(city.isDestroyed());
        city.destroy();
        assertTrue(city.isDestroyed());
    }
}
