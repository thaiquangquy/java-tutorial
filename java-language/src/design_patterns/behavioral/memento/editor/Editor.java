package design_patterns.behavioral.memento.editor;

import design_patterns.behavioral.memento.commands.Command;
import design_patterns.behavioral.memento.history.History;
import design_patterns.behavioral.memento.history.Memento;
import design_patterns.behavioral.memento.shapes.CompoundShape;
import design_patterns.behavioral.memento.shapes.Shape;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class Editor extends JComponent {
    private Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private History history;

    public Editor() {
        this.canvas = new Canvas(this);
        this.history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    public void execute(Command c) {
        history.push(c, new Memento(this));
        c.execute();
    }

    public void undo() {
        if (history.undo()) {
            canvas.repaint();
        }
    }

    public void redo() {
        if (history.redo()) {
            canvas.repaint();
        }
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());

        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
