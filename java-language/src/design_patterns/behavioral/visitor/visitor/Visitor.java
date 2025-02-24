package design_patterns.behavioral.visitor.visitor;

import design_patterns.behavioral.visitor.shapes.Circle;
import design_patterns.behavioral.visitor.shapes.CompoundShape;
import design_patterns.behavioral.visitor.shapes.Dot;
import design_patterns.behavioral.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);
    String visitCircle(Circle circle);
    String visitRectangle(Rectangle rectangle);
    String visitCompoundShape(CompoundShape compoundShape);
}
