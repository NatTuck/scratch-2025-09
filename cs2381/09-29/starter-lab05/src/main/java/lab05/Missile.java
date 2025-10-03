package lab05;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Missile {
    private final int x, y; // current position
    private final int targetX, targetY; // target position (city)
    private final int speed;
    private final Color color;
    private boolean exploded;
    private int explosionRadius;

    public Missile(int startX, int startY, int targetX, int targetY, int speed) {
        this.x = startX;
        this.y = startY;
        this.targetX = targetX;
        this.targetY = targetY;
        this.speed = speed;
        this.color = Color.RED;
        this.exploded = false;
        this.explosionRadius = 0;
    }

    public Missile tick() {
        if (exploded) {
            explosionRadius += 2;
            if (explosionRadius > 30) {
                return null; // Remove missile after explosion
            }
            return this;
        }

        // Move toward target
        int dx = targetX - x;
        int dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance < speed) {
            // Reached target, explode
            exploded = true;
            return this;
        }
        
        // Move toward target
        double moveX = (dx / distance) * speed;
        double moveY = (dy / distance) * speed;
        
        return new Missile((int)(x + moveX), (int)(y + moveY), targetX, targetY, speed);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isExploded() {
        return exploded;
    }

    public Color getColor() {
        return color;
    }

    public Shape toShape(int height) {
        if (exploded) {
            return new Ellipse2D.Double(x - explosionRadius, y - explosionRadius, 
                                      explosionRadius * 2, explosionRadius * 2);
        } else {
            return new Ellipse2D.Double(x - 3, y - 3, 6, 6);
        }
    }

    public boolean isOutOfBounds(int width, int height) {
        return x < 0 || x > width || y < 0 || y > height;
    }

    public boolean collidesWith(int laserX, int laserY, int radius) {
        if (exploded) return false;
        
        int dx = this.x - laserX;
        int dy = this.y - laserY;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < (3 + radius);
    }
}
