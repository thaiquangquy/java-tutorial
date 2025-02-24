package design_patterns.behavioral.visitor.shapes;

import design_patterns.behavioral.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
