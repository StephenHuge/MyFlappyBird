package my.bird.state;

import my.bird.game.Game;

public class OverState implements State {
    private Game game;
    public OverState(Game game) {
        this.game = game;
    }
    @Override
    public void over() {
        game.setState(game.getOverState());
    }
    @Override
    public void restart() {
        game.setState(game.getStartState());
    }
    @Override
    public String toString() {
        return "overState";
    }
}
