package my.bird.game;

import my.bird.state.GameState;
import my.bird.state.OverState;
import my.bird.state.PauseState;
import my.bird.state.StartState;
import my.bird.state.State;

/**
 * @date 2017-10-8
 */
public class Game {
    private State gameState;
    private State overState;
    private State pauseState;
    private State startState;
    
    private State state;
    public Game() {
        gameState  = new GameState(this);
        overState  = new OverState(this);
        pauseState = new PauseState(this);
        startState = new StartState(this);
        state = startState;
        System.out.println("Init state : " + startState);
    }
    
    public void start() {
        System.out.println("GAME START!");
        state.start();
    }
    public void pause() {
        System.out.println("PAUSE!");
        state.pause();
    }
    public void continuea() {
        System.out.println("CONTINUE!");
        state.continuea();
    }
    public void over() {
        System.out.println("GAME OVER!");
        state.over();
    }
    public void restart() {
        System.out.println("GAME RESTART!");
        state.restart();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    public State getOverState() {
        return overState;
    }

    public void setOverState(State overState) {
        this.overState = overState;
    }

    public State getPauseState() {
        return pauseState;
    }

    public void setPauseState(State pauseState) {
        this.pauseState = pauseState;
    }

    public State getStartState() {
        return startState;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }
    @Override
    public String toString() {
        return "game : " + state;
    }
}
