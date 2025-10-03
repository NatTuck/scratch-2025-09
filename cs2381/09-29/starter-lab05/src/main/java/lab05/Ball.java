package lab05;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ball {
    private final Color color;
    private final int x, y;
    private final int dx, dy;

    public Ball(Color color, int x, int y, int dx, int dy) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Ball tick() {
        return new Ball(color, x + dx, y + dy, dx, dy + App.GRAVITY);
    }

    public Color color() {
        return color;
    }

    public Shape toShape(int height) {
        return new Ellipse2D.Double(x - 15, y - 15, 30, 30); // Shape at current position
    }

    public static Ball random(int x, int y) {
        var rand = new java.util.Random();
        var color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        return new Ball(color, x, y, rand.nextInt(20) - 10, rand.nextInt(20) - 10);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ball) {
            Ball other = (Ball) obj;
            return color.equals(other.color) && x == other.x && y == other.y && dx == other.dx && dy == other.dy;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOutOfBounds(int width, int height) {
        return x < 0 || x > width || y < 0 || y > height;
    }
}
