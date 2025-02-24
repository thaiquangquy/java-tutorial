package design_patterns.behavioral.visitor.shapes;

import design_patterns.behavioral.visitor.visitor.Visitor;

public class Circle extends Dot {
    public int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visitCircle(this);
    }
}
