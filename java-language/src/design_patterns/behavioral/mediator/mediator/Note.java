package design_patterns.behavioral.mediator.mediator;

public class Note {
    private String name;
    private String text;

    public Note() {
        name = "New Note";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name;
    }
}
