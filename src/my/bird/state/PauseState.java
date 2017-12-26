package my.bird.state;

import my.bird.game.Game;

public class PauseState implements State {
    private Game game;
    public PauseState(Game game) {
        this.game = game;
    }
    @Override
    public void continuea() {
        game.setState(game.getGameState());
    }
    @Override
    public String toString() {
        return "pauseState";
    }
}
