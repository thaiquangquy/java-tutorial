package design_patterns.behavioral.mediator.components;

import javax.swing.*;
import design_patterns.behavioral.mediator.mediator.Mediator;

import java.awt.event.KeyEvent;

public class Title extends JTextField implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent e) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}
