import java.awt.Font;
import java.awt.Graphics;

//The end class displays the end screen of the game after the player has completed an order: the player
//will know their score and see a comparison of their creation VS the correct answer.
public class End extends State {
//array with the information of a correct order-to be used for comparison against player order
	static int checker[] = new int[7];
	// variable for determining if the player did an order correctly
	static boolean pass = true;
	// for determining how much of the order a player got right
	static int mistakes = 0;

	// method to update variables related to buttons, mouse presses etc
	public void update() {
		// resetting all values for another game
		if (mistakes == 0) { // makes sure this is only executed once so that the mistake count is right
			for (int d = 0; d < 7; d++) { // loops through all aspects of an order
				if (checker[d] != GameWindow.orderInfo[d]) { // if part of order not= to what the player chose
					pass = false;// then order failed and mistake counted goes up by 1
					mistakes += 1;
				}
			}
		}
		// If the player clicked home - all values will be reset for another play
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 69) && (MouseManager.getmx() < 176))
				&& ((MouseManager.getmy() > 546) && MouseManager.getmy() < 583)) {
			// resetting all values from all classes used for game play to original
			// craft station class values
			CraftStation.whichFlower = 0;
			CraftStation.flowerColour = 0;
			CraftStation.pickUp = 0;
			CraftStation.dip = 0;
			CraftStation.speed = 0;
			// game window class values
			GameWindow.yesInbox = false;
			GameWindow.orderAccept = false;
			GameWindow.startCount = false;
			GameWindow.countDown = 12;
			// craft station two class values
			CraftTwo.hint = false;
			CraftTwo.trash = false;
			CraftTwo.drag = false;
			CraftTwo.yesPatch = false;
			CraftTwo.complete = false;
			CraftTwo.bq = 0;
			CraftTwo.r = -1;
			CraftTwo.cs = -1;
			CraftTwo.cc = -1;
			CraftTwo.s = 0;
            //end class values
			pass = true;
			mistakes = 0;
			// goes back to the main menu
			State.setState(Game.returnmain());
		}
	}

	// renders class updates images/displays
	public void render(Graphics g) {
		// background for the end screen
		g.drawImage(Assets.endBg, 0, 0, null);
		// displays the player answer stored in the answer array - values were gather
		// throughout crafting process
		for (int a = 0; a < 4; a++) {
			g.drawImage(CraftTwo.answer[a], -190, 50, null);
			g.drawImage(Assets.patch[CraftStation.whichFlower], -190, 50, null);
		}
		// Displays the correct answer
		/*
		 * the randomly generated order info was stored and is now used to display the
		 * correct image based on its numerical value - each different value of the
		 * orderInfo array represents a different part of the bouquet - eg. type of
		 * flower, bouquet colour, card colour card shape etc.
		 */
		// bouquet portion
		if (GameWindow.orderInfo[2] == 0) {
			g.drawImage(Assets.bq1, 200, 50, null);
		} else if (GameWindow.orderInfo[2] == 1) {
			g.drawImage(Assets.bq3, 200, 50, null);
		} else if (GameWindow.orderInfo[2] == 2) {
			g.drawImage(Assets.bq2, 200, 50, null);
		}
		// ribbon portion
		if (GameWindow.orderInfo[3] == 0) {
			g.drawImage(Assets.r1, 200, 50, null);
		} else if (GameWindow.orderInfo[3] == 1) {
			g.drawImage(Assets.r3, 200, 50, null);
		} else if (GameWindow.orderInfo[3] == 2) {
			g.drawImage(Assets.r2, 200, 50, null);
		}
		// card portion (shape and colour)
		if (GameWindow.orderInfo[4] == 0) {
			if (GameWindow.orderInfo[5] == 0) {
				g.drawImage(Assets.craftCard[0], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 1) {
				g.drawImage(Assets.craftCard[1], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 2) {
				g.drawImage(Assets.craftCard[2], 200, 50, null);
			}
		} else if (GameWindow.orderInfo[4] == 1) {
			if (GameWindow.orderInfo[5] == 0) {
				g.drawImage(Assets.craftCard[3], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 1) {
				g.drawImage(Assets.craftCard[4], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 2) {
				g.drawImage(Assets.craftCard[5], 200, 50, null);
			}
		} else if (GameWindow.orderInfo[4] == 2) {
			if (GameWindow.orderInfo[5] == 0) {
				g.drawImage(Assets.craftCard[6], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 1) {
				g.drawImage(Assets.craftCard[7], 200, 50, null);
			} else if (GameWindow.orderInfo[5] == 2) {
				g.drawImage(Assets.craftCard[8], 200, 50, null);
			}
		}
		// stamp portion
		if (GameWindow.orderInfo[6] == 0) {
			g.drawImage(Assets.s1, 200, 50, null);
		} else if (GameWindow.orderInfo[6] == 1) {
			g.drawImage(Assets.s2, 200, 50, null);
		} else if (GameWindow.orderInfo[6] == 2) {
			g.drawImage(Assets.s3, 200, 50, null);
		}
		// flower portion
		if (GameWindow.orderInfo[0] == 0) {
			if (GameWindow.orderInfo[1] == 0) {
				g.drawImage(Assets.patch[0], 200, 50, null);
			} else if (GameWindow.orderInfo[1] == 1) {
				g.drawImage(Assets.patch[1], 200, 50, null);
			}
		} else if (GameWindow.orderInfo[0] == 1) {
			if (GameWindow.orderInfo[1] == 0) {
				g.drawImage(Assets.patch[2], 200, 50, null);
			} else if (GameWindow.orderInfo[1] == 1) {
				g.drawImage(Assets.patch[3], 200, 50, null);
			}
		} else if (GameWindow.orderInfo[0] == 2) {
			if (GameWindow.orderInfo[1] == 0) {
				g.drawImage(Assets.patch[4], 200, 50, null);
			} else if (GameWindow.orderInfo[1] == 1) {
				g.drawImage(Assets.patch[5], 200, 50, null);
			}
		}
        //displaying if the player successfully fulfilled a number or not
		if (pass == false) { // if a mistake or more was made, try again is displayed
			g.drawImage(Assets.end2, 0, 0, null);
		} else {// if no mistakes success is displayed
			g.drawImage(Assets.end1, 0, 0, null);
		}
		// font for showing the score
		Font mono = new Font("Monospaced", Font.PLAIN, 14);
		g.setFont(mono);
		// total score out of 8, player score is 8 - mistakes
		g.drawString(String.valueOf("Score:" + (7 - mistakes) + "/7"), 110, 120);

	}

}
