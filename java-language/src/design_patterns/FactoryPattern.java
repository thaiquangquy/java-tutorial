package design_patterns;

public class FactoryPattern {
    public interface Button {
        void render();

        void onClick();
    }

    static class WindowsButton implements Button {
        public void render() {
            System.out.println("Render a button in a Windows style.");
        }

        public void onClick() {
            System.out.println("Click on a Windows button.");
        }
    }

    static class HTMLButton implements Button {
        public void render() {
            System.out.println("Render a button in a HTML style.");
        }

        public void onClick() {
            System.out.println("Click on a HTML button.");
        }
    }

    public static abstract class Dialog {
        public void renderWindow() {
            Button okButton = createButton();
            okButton.render();
            okButton.onClick();
        }

        public abstract Button createButton();
    }

    public static class WindowsDialog extends Dialog {

        @Override
        public Button createButton() {
            return new WindowsButton();
        }
    }

    public static class WebDialog extends Dialog {

        public Button createButton() {
            return new HTMLButton();
        }
    }

    static void initialize() {
        boolean isWindows = false;
        if (isWindows) {
            dialog = new WindowsDialog();
        } else {
            dialog = new WebDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }

    private static Dialog dialog;

    public static void main(String[] args) {
        initialize();
        runBusinessLogic();
    }
}
