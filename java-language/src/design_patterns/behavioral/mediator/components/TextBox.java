package design_patterns.behavioral.mediator.components;

import design_patterns.behavioral.mediator.mediator.Mediator;

import javax.swing.*;

public class TextBox extends JTextArea implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(java.awt.event.KeyEvent e) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
