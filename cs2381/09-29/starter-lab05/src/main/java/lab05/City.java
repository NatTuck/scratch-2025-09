package lab05;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class City {
    private final int x, y;
    private final Color color;
    private boolean destroyed;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.GREEN;
        this.destroyed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public Color getColor() {
        return destroyed ? Color.GRAY : Color.GREEN;
    }

    public Shape toShape(int height) {
        return new Rectangle2D.Double(x - 15, y - 10, 30, 20); // Shape at current position
    }
}
