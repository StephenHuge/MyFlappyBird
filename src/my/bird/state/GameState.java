package my.bird.state;

import my.bird.game.Game;

public class GameState implements State {
    private Game game;
    public GameState(Game game) {
        this.game = game;
    }
    @Override
    public void pause() {
        game.setState(game.getPauseState());
    }
    @Override
    public void continuea() {
        game.setState(game.getGameState());
    }
    @Override
    public void over() {
        game.setState(game.getOverState());
    }
    @Override
    public String toString() {
        return "gameState";
    }
}
