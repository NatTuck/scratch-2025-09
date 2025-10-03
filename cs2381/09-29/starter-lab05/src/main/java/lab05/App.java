package lab05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Shape;

public class App implements GfxApp {
    final static int GRAVITY = 1; // Positive gravity makes objects fall downward
    
    List<Ball> balls;
    List<Missile> missiles;
    List<City> cities;
    List<Laser> lasers;
    int score;
    Random random;

    public static void main(String[] args) {
        GfxWindow.launch(new App(), 800, 600);
    }

    App() {
        this.balls = new ArrayList<>();
        this.missiles = new ArrayList<>();
        this.cities = new ArrayList<>();
        this.lasers = new ArrayList<>();
        this.score = 0;
        this.random = new Random();
        
        // Create cities at the bottom of the screen
        // Coordinate system: (0,0) is top-left, Y increases downward
        int[] cityPositions = {100, 200, 300, 500, 600, 700};
        int bottomY = 580; // Near bottom of 600px height window
        for (int pos : cityPositions) {
            cities.add(new City(pos, bottomY));
        }
    }

    List<Shape> getShapes(GfxWindow gw) {
        List<Shape> shapes = new ArrayList<>();
        List<Color> colors = new ArrayList<>();
        
        // Add cities first (they should be at the bottom)
        for (var city : cities) {
            if (!city.isDestroyed()) { // Only draw cities that aren't destroyed
                shapes.add(city.toShape(gw.getHeight()));
                colors.add(city.getColor());
            }
        }
        
        // Add missiles
        for (var missile : missiles) {
            shapes.add(missile.toShape(gw.getHeight()));
            colors.add(missile.getColor());
        }
        
        // Add balls
        for (var ball : balls) {
            shapes.add(ball.toShape(gw.getHeight()));
            colors.add(ball.color());
        }
        
        // Add lasers last (they should be on top)
        for (var laser : lasers) {
            shapes.add(laser.toShape());
            colors.add(laser.getColor());
        }
        
        // Set colors in the window
        gw.setColors(colors);
        return shapes;
    }

    @Override
    public void onTick(GfxWindow gw, long frame) {
        // Move balls
        List<Ball> balls1 = new ArrayList<>();
        for (var ball : balls) {
            Ball newBall = ball.tick();
            if (!newBall.isOutOfBounds(gw.getWidth(), gw.getHeight())) {
                balls1.add(newBall);
            }
        }
        this.balls = balls1;
        
        // Move missiles
        List<Missile> missiles1 = new ArrayList<>();
        for (var missile : missiles) {
            Missile newMissile = missile.tick();
            if (newMissile != null && !newMissile.isOutOfBounds(gw.getWidth(), gw.getHeight())) {
                missiles1.add(newMissile);
            }
        }
        this.missiles = missiles1;
        
        // Check for collisions between lasers and missiles
        checkCollisions();
        
        // Spawn new missiles occasionally
        if (frame % 60 == 0) { // Every 60 frames (~1 second)
            spawnMissile(gw.getWidth(), gw.getHeight());
        }
        
        gw.putShapes(this.getShapes(gw));
    }

    private void spawnMissile(int width, int height) {
        // Spawn from top of screen at random x position
        int startX = random.nextInt(width);
        int startY = 0; // Top of screen
        
        // Target a random city
        int cityIndex = random.nextInt(6);
        int[] cityPositions = {100, 200, 300, 500, 600, 700};
        int targetX = cityPositions[cityIndex];
        int targetY = 580; // Target the bottom where cities are
        
        missiles.add(new Missile(startX, startY, targetX, targetY, 2));
    }

    private void checkCollisions() {
        List<Missile> remainingMissiles = new ArrayList<>();
        
        for (var missile : missiles) {
            boolean destroyed = false;
            
            // Check collision with any laser
            for (var laser : lasers) {
                if (laser.collidesWith(missile.getX(), missile.getY(), 3)) {
                    destroyed = true;
                    score += 10;
                    break;
                }
            }
            
            // Check collision with any ball (existing functionality)
            for (var ball : balls) {
                if (missile.collidesWith(ball.getX(), ball.getY(), 5)) {
                    destroyed = true;
                    score += 10;
                    break;
                }
            }
            
            // Check if missile hit a city
            if (!destroyed && !missile.isExploded()) {
                for (var city : cities) {
                    if (!city.isDestroyed() && 
                        Math.abs(missile.getX() - city.getX()) < 20 && 
                        Math.abs(missile.getY() - city.getY()) < 20) {
                        // Missile hit a city
                        city.destroy();
                        destroyed = true;
                        break;
                    }
                }
            }
            
            if (destroyed) {
                // Create an exploded missile at the same position
                Missile explodedMissile = new Missile(missile.getX(), missile.getY(), 
                                                     missile.getX(), missile.getY(), 0);
                remainingMissiles.add(explodedMissile);
            } else {
                remainingMissiles.add(missile);
            }
        }
        
        this.missiles = remainingMissiles;
    }

    @Override
    public void onMouse(GfxWindow gw, int x, int y, int btn) {
        // Shoot laser from bottom center toward mouse position
        // Coordinate system: (0,0) is top-left, Y increases downward
        this.lasers.add(new Laser(GfxWindow.stringToColor("blue"), 400, 580, x, y));
        gw.putShapes(this.getShapes(gw));
    }

    @Override
    public void onKey(GfxWindow gw, String key) {
        if ("r".equals(key)) {
            // Reset game
            this.balls.clear();
            this.missiles.clear();
            this.lasers.clear();
            this.score = 0;
            
            // Recreate cities
            this.cities.clear();
            int[] cityPositions = {100, 200, 300, 500, 600, 700};
            int bottomY = 580; // Near bottom of 600px height window
            for (int pos : cityPositions) {
                cities.add(new City(pos, bottomY));
            }
        }
        gw.putShapes(this.getShapes(gw));
    }
}
