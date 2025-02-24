package design_patterns.behavioral.visitor.visitor;

import design_patterns.behavioral.visitor.shapes.Circle;
import design_patterns.behavioral.visitor.shapes.CompoundShape;
import design_patterns.behavioral.visitor.shapes.Dot;
import design_patterns.behavioral.visitor.shapes.Rectangle;
import design_patterns.behavioral.visitor.shapes.Shape;

public class XMLExportVisitor implements Visitor {
    public String export(Shape... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n");
        for (Shape shape : args) {
            sb.append(shape.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visitDot(Dot dot) {
        return "<dot>" + "\n" +
                "    <id>" + dot.getId() + "</id>" + "\n" +
                "    <x>" + dot.getX() + "</x>" + "\n" +
                "    <y>" + dot.getY() + "</y>" + "\n" +
                "</dot>";
    }

    @Override
    public String visitCircle(Circle circle) {
        return "<circle>" + "\n" +
                "    <id>" + circle.getId() + "</id>" + "\n" +
                "    <x>" + circle.getX() + "</x>" + "\n" +
                "    <y>" + circle.getY() + "</y>" + "\n" +
                "    <radius>" + circle.getRadius() + "</radius>" + "\n" +
                "</circle>";
    }

    @Override
    public String visitRectangle(Rectangle rectangle) {
        return "<rectangle>" + "\n" +
                "    <id>" + rectangle.getId() + "</id>" + "\n" +
                "    <x>" + rectangle.getX() + "</x>" + "\n" +
                "    <y>" + rectangle.getY() + "</y>" + "\n" +
                "    <width>" + rectangle.getWidth() + "</width>" + "\n" +
                "    <height>" + rectangle.getHeight() + "</height>" + "\n" +
                "</rectangle>";
    }

    @Override
    public String visitCompoundShape(CompoundShape compoundShape) {
        return "<compound_graphic>" + "\n" +
                "    <id>" + compoundShape.getId() + "</id>" + "\n" +
                _visitCompoundGraphic(compoundShape) +
                "</compound_graphic>";
    }

    private String _visitCompoundGraphic(CompoundShape compoundShape) {
        StringBuilder sb = new StringBuilder();
        for (Shape shape : compoundShape.children) {
            String obj = shape.accept(this);
            // Proper indentation for sub-objects.
            String[] lines = obj.split("\n");
            for (String line : lines) {
                sb.append("    ").append(line).append("\n");
            }
        }
        return sb.toString();
    }
}
