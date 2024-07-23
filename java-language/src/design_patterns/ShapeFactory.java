package design_patterns;

public class ShapeFactory {
    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    class Square implements Shape {
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}
