package design_patterns.behavioral.state_pattern;

import design_patterns.behavioral.state_pattern.ui.Player;
import design_patterns.behavioral.state_pattern.ui.UI;

public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
