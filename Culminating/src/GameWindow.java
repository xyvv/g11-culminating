import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*The game window class displays the first game window with the interior of the flower shop. The player is
 * able to accept an order in this class and access the craft stations. Some visual elements of this class
 * can be edited in the settings window.*/
public class GameWindow extends State {
	// variables for new order animation
	int orderUpdate = 0;
	int forOrder = 0;
	// variables for the count down after an order is accepted
	static int countDown = 12;
	int seconds = 0;
	static boolean startCount;
	// variables for displaying the Inbox with a order
	static boolean yesInbox = false;
	static boolean rand = false;
	static int b1, b2, c1, c2, c3, f1, f2;
	// variable for opening up crafting station
	static boolean orderAccept = false;
	static int orderInfo[] = new int[7];
	// variable used to store the correct elements of an order
	static BufferedImage[] key = new BufferedImage[8];

	// method to update variables related to buttons, mouse presses etc
	public void update() {
		// if the coordinates of the back button was pressed then the game goes back to
		// main menu
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 5) && (MouseManager.getmx() < 65))
				&& ((MouseManager.getmy() > 15) && MouseManager.getmy() < 65)) {
			State.setState(Game.returnmain());

		}
		// numbers for displaying new order animation
		forOrder += 1;
		// ensures a reasonable speed
		if (forOrder == 20) {
			orderUpdate += 1;
			forOrder = 0;
		}
		if (orderUpdate == 6)
			orderUpdate = 0;

		// going to crafting screen
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 495) && (MouseManager.getmx() < 735))
				&& ((MouseManager.getmy() > 420) && MouseManager.getmy() < 480) && (orderAccept == true)) {
			State.setState(Game.returncraft());

		}

	}

	// renders class updates images/displays
	public void render(Graphics g) {
		// draws the background based on what was chosen in settings
		if (SettingWindow.which() == true) {
			g.drawImage(Assets.bg, 0, 0, null);
		} else {
			g.drawImage(Assets.bg2, 0, 0, null);
		}
//draws the outfit of the shop owner based on choice in settings
		if (SettingWindow.wo() == 1) {
			g.drawImage(Assets.o1, 0, 0, null);
		} else if (SettingWindow.wo() == 2) {
			g.drawImage(Assets.o2, 0, 0, null);
		}
//draws the back button
		g.drawImage(Assets.backButton, 5, 15, null);
//new order animation is displayed if no order is accepted
		if (orderAccept == false) {
			g.drawImage(Assets.newOrder[orderUpdate], 0, 0, null);
		}
		// sets the variable for opening Inbox to true if player clicks the letter
		// button
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 300) && (MouseManager.getmx() < 370))
				&& ((MouseManager.getmy() > 210) && MouseManager.getmy() < 275) && (orderAccept == false)) {
			yesInbox = true;
			// randomly generates each part of the order upon opening
			b1 = (int) (3 * Math.random());
			b2 = (int) (3 * Math.random());

			c1 = (int) (3 * Math.random());
			c2 = (int) (3 * Math.random());
			c3 = (int) (3 * Math.random());

			f1 = (int) (3 * Math.random());
			f2 = (int) (2 * Math.random());
//stores order information for determining scores at the end
			orderInfo[0] = f1;
			orderInfo[1] = f2;
			orderInfo[2] = b1;
			orderInfo[3] = b2;
			orderInfo[4] = c1;
			orderInfo[5] = c2;
			orderInfo[6] = c3;

		} // if the player does not click the letter, the letter will only be highlighted
		else if ((MouseManager.getmx() > 300) && (MouseManager.getmx() < 370)
				&& ((MouseManager.getmy() > 210) && MouseManager.getmy() < 275)) {
			g.drawImage(Assets.clickMail, 0, 0, null);
		}
		// displays the Inbox
		if (yesInbox == true) {
			// base of Inbox
			g.drawImage(Assets.inbox, 0, 0, null);
			// flower elements
			g.drawImage(Assets.flower[f1], 447, 145, null);
			g.drawImage(Assets.fc[f2], 542, 143, null);
			// bouquet elements
			g.drawImage(Assets.bqColour[b1], 0, 0, null);
			g.drawImage(Assets.bqRibbonColour[b2], 0, 0, null);
			// card elemenets
			g.drawImage(Assets.cardShape[c1], 0, 0, null);
			g.drawImage(Assets.cardColour[c2], 0, 0, null);
			g.drawImage(Assets.cardStamp[c3], 0, 0, null);

		}
		// closes the Inbox if player presses the x button
		if (yesInbox == true) {
			if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 420) && (MouseManager.getmx() < 445))
					&& ((MouseManager.getmy() > 60) && MouseManager.getmy() < 80)) {
				yesInbox = false;

			} else if ((MouseManager.lPressed() == true)
					&& ((MouseManager.getmx() > 520) && (MouseManager.getmx() < 630))
					&& ((MouseManager.getmy() > 490) && MouseManager.getmy() < 530)) {
				// starts the count down once the player clicks accept
				startCount = true;

			}
			// count down
			if (startCount == true) {
				seconds += 1;

				g.drawString(String.valueOf(countDown), 570, 480);

				if (seconds == 60) {
					countDown = countDown - 1;
					seconds = 0;
				}
//closes the Inbox after 10 seconds
				if (countDown == -1) {
					orderAccept = true;
					yesInbox = false;
				}
			}

		}

		// when order is accepted the craft station opens
		if (orderAccept == true) {
			g.drawImage(Assets.craft, 0, 0, null);
			if (((MouseManager.getmx() > 495) && (MouseManager.getmx() < 735))
					&& ((MouseManager.getmy() > 420) && MouseManager.getmy() < 480)) {
				g.drawImage(Assets.yesCraft, 0, 0, null);
			}
		}

	}
}
