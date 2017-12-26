package my.bird.state;

import my.bird.game.Game;

public class StartState implements State {
    private Game game;
    public StartState(Game game) {
        this.game = game;
    }
    @Override
    public void start() {
        game.setState(game.getGameState());
    }
    @Override
    public String toString() {
        return "startState";
    }
}
