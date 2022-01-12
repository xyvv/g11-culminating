import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/*The settings class displays the settings window of the game, where the player is able to enter his or her name,
 * change the shop theme, and more.*/
public class SettingWindow extends State {
//variable declarations for items that settings manipulate
	public static boolean whichtheme = true; // for theme selection
	static int girlOutfit; // for the shop owner's outfit
	String name; // for player's name
	int count =0;

	// method to update variables related to buttons, mouse presses etc
	public void update() {
		// coordinates for the back button - if pressed will go back to menu
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 10) && (MouseManager.getmx() < 70))
				&& ((MouseManager.getmy() > 520) && MouseManager.getmy() < 570)) {
			State.setState(Game.returnmain());
		}
//coordinates tracking mouse click for selection of theme
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 470) && (MouseManager.getmx() < 730))
				&& ((MouseManager.getmy() > 145) && MouseManager.getmy() < 345)) {
			whichtheme = true; // regular display
		} else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 470) && (MouseManager.getmx() < 730))
				&& ((MouseManager.getmy() > 370) && MouseManager.getmy() < 570)) {
			whichtheme = false; // night theme
		}
//coordinates tracking mouse click for selection of shop owner outfit
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 30) && (MouseManager.getmx() < 210))
				&& ((MouseManager.getmy() > 255) && MouseManager.getmy() < 490)) {
			girlOutfit = 1; // each number corresponds to an outfit
		} else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 231) && (MouseManager.getmx() < 406))
				&& ((MouseManager.getmy() > 255) && MouseManager.getmy() < 490)) {
			girlOutfit = 2;
		} else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 24) && (MouseManager.getmx() < 91))
				&& ((MouseManager.getmy() > 488) && MouseManager.getmy() < 511)) {
			girlOutfit = 0;
		}
//if player presses change name button a small window pops up for entering player name
		if (count ==0) {
			if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 212) && (MouseManager.getmx() < 300))
					&& ((MouseManager.getmy() > 103) && MouseManager.getmy() < 130)) {
				name = JOptionPane.showInputDialog(null, "Please enter your name:");
				count = 1;
			}
		}

	}

	// render method for displaying updated graphics
	public void render(Graphics g) {
		// draws the background of the settings window
		g.drawImage(Assets.settingBg, 0, 0, null);
		// draws back button
		g.drawImage(Assets.backButton, 10, 520, null);
//creates a font to be used for displaying text
		Font mono = new Font("Monospaced", Font.PLAIN, 14);
		g.setFont(mono);
		g.drawString("Welcome, ", 35, 150);
		//prevents name changing after entered once
		if(count >0) {
			g.drawImage(Assets.no, 0, 0, null);
		}
		if (name == null) {// if no name entered then no name is shown
			g.drawString("no name", 105, 150);
		} else { // else player's name is outputted
			g.drawString(name, 105, 150);
		}
//draws the box that shows which theme is selected
		if (whichtheme == true) {
			g.drawImage(Assets.selectTheme, 0, 0, null);
		} else if (whichtheme == false) {
			g.drawImage(Assets.selectTheme, 0, 225, null);
		}
//draws the arrow that indicates what outfit is selected unless reset button is clicked
		if (girlOutfit == 0) {
			g.drawImage(Assets.outfit, -500, 0, null);
		} else if (girlOutfit == 1) {
			g.drawImage(Assets.outfit, 0, 0, null);
		} else if (girlOutfit == 2) {
			g.drawImage(Assets.outfit, 200, 0, null);
		}

		// highlights which option the player is on if his or her house hovers over it
		if (((MouseManager.getmx() > 470) && (MouseManager.getmx() < 730))
				&& ((MouseManager.getmy() > 145) && MouseManager.getmy() < 345)) {
			g.drawImage(Assets.selectTheme, 0, 0, null);
		} else if (((MouseManager.getmx() > 470) && (MouseManager.getmx() < 730))
				&& ((MouseManager.getmy() > 370) && MouseManager.getmy() < 570)) {
			g.drawImage(Assets.selectTheme, 0, 225, null);
		}
		if (((MouseManager.getmx() > 30) && (MouseManager.getmx() < 210))
				&& ((MouseManager.getmy() > 255) && MouseManager.getmy() < 490)) {
			g.drawImage(Assets.outfit, 0, 0, null);
		} else if (((MouseManager.getmx() > 231) && (MouseManager.getmx() < 406))
				&& ((MouseManager.getmy() > 255) && MouseManager.getmy() < 490)) {
			g.drawImage(Assets.outfit, 200, 0, null);
		}
	}

//returns the selected theme to game window
	public static boolean which() {
		return whichtheme;
	}

//returns the selected outfit to the game window
	public static int wo() {
		return girlOutfit;
	}

}
