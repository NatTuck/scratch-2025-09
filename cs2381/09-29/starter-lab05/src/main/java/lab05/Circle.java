package lab05;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Circle implements SimpleShape {
    private final Color color;
    private final int x, y, radius;

    public Circle(Color color, int x, int y, int radius) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public SimpleShape flipY(int height) {
        return new Circle(color, x, height - y, radius);
    }

    @Override
    public Shape toShape() {
        return new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
    }
}
