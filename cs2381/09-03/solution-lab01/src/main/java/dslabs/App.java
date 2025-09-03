package dslabs;

import java.util.List;

public class App {
    // Program starts executing in the main method of the main class.
    public static void main(String[] args) {
        Cell xs = new Cell(1, null);
        xs = new Cell(2, xs);
        xs = new Cell(3, xs);
        xs = new Cell(4, xs);
        System.out.println(xs.sum());
    }

    public static void main1(String[] args) {
        List<Shape> shapes = List.of(new Square(1), new Circle(1), new Square(2), new Rect(3, 2));
        for (var sh : shapes) {
            System.out.println("area = " + sh.area());
        }
    }
}

record Cell(int first, Cell rest) {
    int sum() {
        if (rest == null) {
            return first;
        }
        else {
            return first + rest.sum();
        }
    }
}


interface Shape {
    double area();
}

record Rect(double width, double length) implements Shape {
    public double area() {
        return width * length;
    }
}

class Square implements Shape {
    final double width;
    
    Square(double width) {
        this.width = width;
    }

    public double area() {
        return width * width;
    }
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2.0);
    }
}

