import java.awt.Font;
import java.awt.Graphics;

//The help window class displays the help window and provides information to the player
public class HelpWindow extends State {

	public void update() {
		// if player clicked back button, the game goes back to main menu
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 25) && (MouseManager.getmx() < 85))
				&& ((MouseManager.getmy() > 20) && MouseManager.getmy() < 70)) {
			State.setState(Game.returnmain());
		}
	}

	public void render(Graphics g) {
		String[] m = new String[20];
		int y = 170;
		// all texts that will be displayed is stored in an array
		m[0] = "Instructions------------------------------------------------------------------------";
		m[1] = "Buttons: There are four buttons available from the homescreen: play, help, setting, ";
		m[2] = "or collection. Each button will take you to a different part of the game. A white ";
		m[3] = "arrow is located on every screen that will take you back to the menu screen. Click ";
		m[4] = "a button to use it.";
		m[5] = "The purpose of this game is to recreate floral orders from memory.";
		m[6] = "Play: After entering the game screen, the player will have the option to accept an ";
		m[7] = "order by clicking the mail icon: a bouquet order will be randomly generated each ";
		m[8] = "time the button is clicked. Clicking accept will unlock the crafting station for ";
		m[9] = "making a bouquet and start a 10 second count down. After this you will not be able to  ";
		m[10] = "look at the order. There is a hint button on each craft station that tells you how to ";
		m[11] = "use the different parts of the craft station. At the end of completing an order, a score ";
		m[12] = "out of 7 will be displayed along with your  own answer vs the correct one. The end will ";
		m[13] = "show success if you get 7/7, or try again if a mistake was made.";
		m[14] = "Setting: In settings, you will be able to enter/change your player name, change the ";
		m[15] = "outfit of the shop owner, or change the display theme of the game.";
		m[16] = "Help: the help screen explains how to generally use parts of the game, for specific ";
		m[17] = "game play help click the hint button while in a craft station.";
		m[18] = "Quit: clicking it will terminate the program";
		m[19] = "(Sidenote: allow a few seconds after a button click - it may need to load a little";
		// draws the background for the help window
		g.drawImage(Assets.helpBg, 0, 0, null);
		// draws back button
		g.drawImage(Assets.backButton, 25, 20, null);
//font for text displayed
		Font mono = new Font("Monospaced", Font.PLAIN, 14);
		g.setFont(mono);
		g.drawString("Welcome to Enchanted Florist!", 70, 140);
		// loops through array to display all text
		for (int x = 0; x < 20; x++) {
			g.drawString(m[x], 70, (y + x * 20));
		}

	}
}
