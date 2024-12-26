package design_patterns.behavioral.command.editor;

import design_patterns.behavioral.command.commands.*;

import javax.swing.*;
import java.awt.*;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private final CommandHistory history = new CommandHistory();

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        content.add(buttons);

        JButton ctrlC = new JButton("Ctrl+C");
        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(this)));
        buttons.add(ctrlC);

        JButton ctrlX = new JButton("Ctrl+X");
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(this)));
        buttons.add(ctrlX);

        JButton ctrlV = new JButton("Ctrl+V");
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(this)));
        buttons.add(ctrlV);

        JButton undo = new JButton("Undo");
        undo.addActionListener(e -> undo());
        buttons.add(undo);

        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
