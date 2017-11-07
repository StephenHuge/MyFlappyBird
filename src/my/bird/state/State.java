package my.bird.state;

public interface State {
    default void start() {
        System.out.println("call start()");
    }
    default void pause() {
        System.out.println("call pause()");
    }
    default void over() {
        System.out.println("call over()");
    }
    default void restart() {
        System.out.println("call restart()");
    }
}
