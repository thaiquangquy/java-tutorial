package design_patterns;

// The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.
// This pattern is useful when there is a need to create related objects, but their implementation details vary.

interface Color {
    void fill();
}

class Red implements Color {
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Green implements Color {
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

interface AbstractFactory {
    Color getColor(String color);
}

class ColorFactory implements AbstractFactory {
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        }
        return null;
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory colorFactory = new ColorFactory();

        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();
    }
}
