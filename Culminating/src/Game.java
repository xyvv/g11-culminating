import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/*The game class runs on a thread - a part of program that can be executed independent of the entire whole - contributes
 towards efficiency. A game object of the game class will be created in the launch class to start up the game*/
public class Game implements Runnable { // runnable allows a class to run on a thread
	// Variable declaration
	private Display display;
	public int width, height;
	public String title;
//creates a new thread
	private Thread thread;
	private boolean run = false;
//buffer strategy allows graphics to draw onto buffers for smooth display
	private BufferStrategy bs;
	// graphics object allows objects to be drawn to a canvas
	private Graphics g;
//state variable declarations
	public static State gameState = null;
	public static State mainState = null;
	public static State settingState = null;
	public static State helpState = null;
	public static State craftStation = null;
	public static State craftStation2 = null;
	public static State end = null;

	private MouseManager mouseManager;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		mouseManager = new MouseManager();

	}

	// main code

	private void initialize() {
		// starts up the window
		display = new Display(title, width, height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		// initialized all assets loaded in the assets class
		Assets.init();
		// state declarations---------------------------------------
		gameState = new GameWindow();
		mainState = new MainWindow();
		settingState = new SettingWindow();
		helpState = new HelpWindow();
		craftStation = new CraftStation();
		craftStation2 = new CraftTwo();
		end = new End();
		// sets the current state to the main menu
		State.setState(mainState);
	}

//methods used to return specific parts of the game from where needed.
	// returns game window
	public static State returngame() {
		return gameState;
	}

	// returns settings window
	public static State returnsetting() {
		return settingState;
	}

	// returns help window
	public static State returnhelp() {
		return helpState;
	}

	// returns main menu
	public static State returnmain() {
		return mainState;
	}

	// returns craft station 1
	public static State returncraft() {
		return craftStation;
	}

	// returns craft station 2
	public static State returncraft2() {
		return craftStation2;
	}

	// returns end screen
	public static State returnend() {
		return end;
	}

	// updates graphics
	private void update() {
		if (State.getState() != null) {
			State.getState().update();
		}

	}

	// renders new graphics
	private void render() {
		// buffer strategy allows graphics to be drawn - there are 3 buffers, graphics
		// are first drawn to the
		// bottom buffer which cannot be seen. The drawings then moves up eventually to
		// the screen the player can
		// see - prevents flickering
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// displaying graphics
		g.clearRect(0, 0, width, height);
		// drawing
		if (State.getState() != null) {
			State.getState().render(g);
		}

		// shows all drawn object
		bs.show();
		g.dispose();
	}

//main running part, all runnable classes must have a run method
	public void run() {
		// initializes all graphics at the very beginning
		initialize();

		// variable to ensure consistent game running speed across platforms
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		// runs the game loop - constant updating of variables, then rendering of the
		// new updated values
		while (run) {
//keeps frame updating and animation speed consistent across platforms
			now = System.nanoTime();
			delta = delta + (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				delta = delta - 1;
			}

		}

	}

	// starts a thread
	public synchronized void start() {
		// prevent erros of new thread called when a thread is already running
		if (run == true)
			return;

		run = true;
		thread = new Thread(this);
		// calls the run method
		thread.start();
	}

	// stops a thread
	public synchronized void stop() {

		if (run == false)
			return;
		run = false;
		try {// stops a thread safely
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// allows the mouse manager to be retrieved for use
	public MouseManager getMouseManager() {
		return mouseManager;
	}

}
