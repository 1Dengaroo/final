public class GameContext {
    private GameState state;

    public GameContext(GameState initialState) {
        state = initialState;
        state.enter(this);
    }

    public void handleInput(String input) throws InterruptedException {
        state.handleInput(this, input);
    }

    public void changeState(GameState newState) {
        state.exit(this);
        state = newState;
        state.enter(this);
    }
}