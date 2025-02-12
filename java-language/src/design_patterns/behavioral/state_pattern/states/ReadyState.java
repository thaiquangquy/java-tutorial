package design_patterns.behavioral.state_pattern.states;

import design_patterns.behavioral.state_pattern.ui.Player;

public class ReadyState extends State {
    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     *
     * @param player
     */
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
