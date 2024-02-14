public interface GameState {
    void enter(GameContext context);
    void handleInput(GameContext context, String input) throws InterruptedException;
    void exit(GameContext context);
    void advance(GameContext context);
}