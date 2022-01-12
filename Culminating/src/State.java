import java.awt.Graphics;

//all other windows, or game states, of this game extends the state class
public abstract class State {
//declares a new state
	private static State cState = null;

	// method to set what window the game is on
	public static void setState(State state) {
		cState = state;
	}

	// method to get what window the game is currently on
	public static State getState() {
		return cState;
	}

	// mandatory methods for every game state
	public abstract void update();

	public abstract void render(Graphics g);

}
