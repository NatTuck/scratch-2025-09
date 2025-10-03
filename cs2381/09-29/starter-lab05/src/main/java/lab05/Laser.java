package lab05;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;

public class Laser {
    private final Color color;
    private final int startX, startY;
    private final int endX, endY;

    public Laser(Color color, int startX, int startY, int endX, int endY) {
        this.color = color;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Color getColor() {
        return color;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Shape toShape() {
        return new Line2D.Double(startX, startY, endX, endY);
    }

    public boolean collidesWith(int missileX, int missileY, int radius) {
        // Calculate distance from missile to the laser line
        double A = endY - startY;
        double B = startX - endX;
        double C = endX * startY - startX * endY;
        
        double distance = Math.abs(A * missileX + B * missileY + C) / Math.sqrt(A * A + B * B);
        return distance < (radius + 2); // 2 is approximate laser "width"
    }
}
