package lab05;

import java.awt.Color;
import java.awt.Shape;

public interface SimpleShape {
    Color color();
    SimpleShape flipY(int height);
    Shape toShape();
}
