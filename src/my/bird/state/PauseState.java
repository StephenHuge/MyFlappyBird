package my.bird.state;

import my.bird.game.Game;

public class PauseState implements State {
    private Game game;
    public PauseState(Game game) {
        this.game = game;
    }
    @Override
    public void start() {
        game.setState(game.getStartState());
    }
}
