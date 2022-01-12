import java.awt.Graphics;
import java.awt.image.BufferedImage;

//The Craft Two class displays part two of the crafting station needed to complete flower orders:
//In this section the player can choose the bouquet, ribbon, and card associated with the order,
//After selecting all options and dragging the flower from craft station one to the bouquet the player
//can click complete to see how well they completed the order.
public class CraftTwo extends State {
//variable declaration
	// All integers used to keep track of what colour of an item was selected by the
	// player
	static int bq = 0; // tracks the bouquets
	static int r = -1; // tracks the ribbons
	static int cs = -1; // tracks the card shape
	static int cc = -1;// tracks the card colour
	static int s = 0; // tracks the card seal type
	// boolean variables for buttons
	static boolean hint = false; // used for turning on or off hints
	static boolean trash = false; // used for trashing current progress
	static boolean complete = false;// used to going to end sreen after order completion
//boolean variables for dragging the flower from station one to the bouquet
	static boolean drag = false; // for moving flower from holder to bouquet
	static boolean yesPatch = false; // for displaying flower in bouquet
	// Answer array stores the images of the players answer, will be displayed in
	// end screen
	static BufferedImage[] answer = new BufferedImage[4];
	// key array stores the images of the correct answer, will be displayed in end
	// screen
	static BufferedImage[] key = new BufferedImage[6];

	// method to update variables related to buttons, mouse presses etc
	public void update() {
//if the player hovers over trash can the trash can will open 
		if (((MouseManager.getmx() > 736) && (MouseManager.getmx() < 775))
				&& ((MouseManager.getmy() > 530) && MouseManager.getmy() < 590)) {
			trash = true;
		}
		// if the player clicks...
		if (MouseManager.lPressed() == true) {
			// clicking back button returns to craft one screen
			if (((MouseManager.getmx() > 5) && (MouseManager.getmx() < 65))
					&& ((MouseManager.getmy() > 10) && MouseManager.getmy() < 60)) {
				State.setState(Game.returncraft());
				// if statements for determining which bouquet and ribbon to display based on
				// what
				// coloured wrapping paper / roll of ribbon the player clicks
			} else if (((MouseManager.getmx() > 586) && (MouseManager.getmx() < 606))
					&& ((MouseManager.getmy() > 0) && MouseManager.getmy() < 170)) {
				bq = 1; // white bouquet
			} else if (((MouseManager.getmx() > 632) && (MouseManager.getmx() < 650))
					&& ((MouseManager.getmy() > 0) && MouseManager.getmy() < 170)) {
				bq = 2;// grey bouquet
			} else if (((MouseManager.getmx() > 680) && (MouseManager.getmx() < 700))
					&& ((MouseManager.getmy() > 0) && MouseManager.getmy() < 170)) {
				bq = 3;// purple bouquet
			} else if (((MouseManager.getmx() > 725) && (MouseManager.getmx() < 775))
					&& ((MouseManager.getmy() > 10) && MouseManager.getmy() < 55)) {
				r = 1;// white ribbon
			} else if (((MouseManager.getmx() > 725) && (MouseManager.getmx() < 775))
					&& ((MouseManager.getmy() > 70) && MouseManager.getmy() < 110)) {
				r = 2;// green ribbon
			} else if (((MouseManager.getmx() > 725) && (MouseManager.getmx() < 775))
					&& ((MouseManager.getmy() > 125) && MouseManager.getmy() < 165)) {
				r = 3;// yellow ribbon
			}
		}
//if statements for customizing card shape based on coordinates
		if (MouseManager.lPressed() == true) {
			if (((MouseManager.getmx() > 22) && (MouseManager.getmx() < 78))
					&& ((MouseManager.getmy() > 370) && MouseManager.getmy() < 410)) {
				// cs tracks what card shape
				cs = 0;
				// End.checker[4] stores what card shape the player chose for scores at the end
				End.checker[4] = 0;
			} else if (((MouseManager.getmx() > 86) && (MouseManager.getmx() < 145))
					&& ((MouseManager.getmy() > 370) && MouseManager.getmy() < 410)) {
				cs = 3;
				End.checker[4] = 1;
			} else if (((MouseManager.getmx() > 154) && (MouseManager.getmx() < 211))
					&& ((MouseManager.getmy() > 370) && MouseManager.getmy() < 410)) {
				cs = 6;
				End.checker[4] = 2;
			}
		}
//if statement for card colours corresponding the previously selected shape
		// for white coloured cards
		if ((MouseManager.lPressed() == true) && (cs > -1)) {
			if ((MouseManager.getmx() > 22) && (MouseManager.getmx() < 78)
					&& ((MouseManager.getmy() > 432) && MouseManager.getmy() < 471)) {
				// End.checker[5] stores what card colour player chose
				End.checker[5] = 0;
				if ((cs >= 0) && (cs <= 2)) { // for rectangle card shape
					cs = 0;
				} else if ((cs >= 3) && (cs <= 5)) {// for heart card shape
					cs = 3;
				} else if ((cs >= 6) && (cs <= 8)) {// for star card shape
					cs = 6;
				}
				// light orange coloured cards
			} else if (((MouseManager.getmx() > 86) && (MouseManager.getmx() < 145))
					&& ((MouseManager.getmy() > 432) && MouseManager.getmy() < 471)) {
				End.checker[5] = 1;
				if ((cs >= 0) && (cs <= 2)) {// for rectangle card shape
					cs = 1;
				} else if ((cs >= 3) && (cs <= 5)) {// for heart card shape
					cs = 4;
				} else if ((cs >= 6) && (cs <= 8)) {// for star card shape
					cs = 7;
				}
				// light blue coloured cards
			} else if (((MouseManager.getmx() > 154) && (MouseManager.getmx() < 211))
					&& ((MouseManager.getmy() > 432) && MouseManager.getmy() < 471)) {
				End.checker[5] = 2;
				if ((cs >= 0) && (cs <= 2)) {// for rectangle card shape
					cs = 2;
				} else if ((cs >= 3) && (cs <= 5)) {// for heart card shape
					cs = 5;
				} else if ((cs >= 6) && (cs <= 8)) {// for star card shape
					cs = 8;
				}
				// if statements for what ribbon the player chose
			} else if (((MouseManager.getmx() > 22) && (MouseManager.getmx() < 78))
					&& ((MouseManager.getmy() > 493) && MouseManager.getmy() < 533)) {
				// s tracks the ribbon type
				s = 1;
				// End.checker [6] stores player's ribbon choice
				End.checker[6] = 0;
			} else if (((MouseManager.getmx() > 86) && (MouseManager.getmx() < 145))
					&& ((MouseManager.getmy() > 493) && MouseManager.getmy() < 533)) {
				s = 2;
				End.checker[6] = 1;
			} else if (((MouseManager.getmx() > 154) && (MouseManager.getmx() < 211))
					&& ((MouseManager.getmy() > 493) && MouseManager.getmy() < 533)) {
				s = 3;
				End.checker[6] = 2;
				// coordinates for trash button
			} else if (((MouseManager.getmx() > 736) && (MouseManager.getmx() < 775))
					&& ((MouseManager.getmy() > 520) && MouseManager.getmy() < 590)) {
				// if trash is clicked all values are reset to default, all selection cleared
				bq = 0;
				r = -1;
				cs = -1;
				cc = -1;
				s = 0;
				yesPatch = false;
			}

		}
//if statement for turning on and off hints
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 20) && (MouseManager.getmx() < 100))
				&& ((MouseManager.getmy() > 555) && MouseManager.getmy() < 592) && (hint == false)) {
			hint = true; // will allow hints to be displayed in render
		} else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 20) && (MouseManager.getmx() < 100))
				&& ((MouseManager.getmy() > 555) && MouseManager.getmy() < 592) && (hint == true)) {
			hint = false; // will turn off hints in render
		}
//if player clicks the complete button ..
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 328) && (MouseManager.getmx() < 489))
				&& ((MouseManager.getmy() > 535) && MouseManager.getmy() < 579)) {
			complete = true; // will go to end screen in render
		}

	}

	// render method for rendering updated graphics
	public void render(Graphics g) {
		// draws the background for craft station two and the back button
		g.drawImage(Assets.craft2Bg, 0, 0, null);
		g.drawImage(Assets.backButton, 5, 10, null);

		// displays the flower on the holder if flower is not displayed on the bouquet
		if (yesPatch == false)
			g.drawImage(CraftStation.currentFlower, 5, 90, null);
//if statements draw corresponding graphics to numbers stored in variables during the update method
		// draws bouquet that the player selected
		if (bq == 1) { // white bouquet
			g.drawImage(Assets.bq1, 0, 0, null);
			// answer[0] stores the image file flower the player chose
			answer[0] = Assets.bq1;
			// end.checker[2] stores the number corresponding to the flower the player chose
			End.checker[2] = 0;
		} else if (bq == 2) {// grey bouquet
			g.drawImage(Assets.bq2, 0, 0, null);
			answer[0] = Assets.bq2;
			End.checker[2] = 2;
		} else if (bq == 3) {// purple bouquet
			g.drawImage(Assets.bq3, 0, 0, null);
			answer[0] = Assets.bq3;
			End.checker[2] = 1;
		}
//draws the ribbon that the player selected 
		if (r == 1) {//white ribbon
			g.drawImage(Assets.r1, 0, 0, null);
			// answer [1] store the image file of the ribbon the player chose
			answer[1] = Assets.r1;
			//End.checker[3] stores the number corresponding to the ribbon chosen
			End.checker[3] = 0;
		} else if (r == 2) { //green ribbon
			g.drawImage(Assets.r2, 0, 0, null);
			answer[1] = Assets.r2;
			End.checker[3] = 2;
		} else if (r == 3) {//ellow ribbon
			g.drawImage(Assets.r3, 0, 0, null);
			answer[1] = Assets.r3;
			End.checker[3] = 1;
		}
//if the hint button was clicked then display hints
		if (hint == true) {
			g.drawImage(Assets.yesHint2, 0, 0, null);
		}
//if the trash button was clicked then clear all items
		if (trash == true)
			g.drawImage(Assets.yesTrash, 0, 0, null);
		//resets value for next usage;
		trash = false;

		//draws the correct card shape and colour based on player choice
		if ((cs > -1)) { //craft card array contains all card shape/colour combinations
			g.drawImage(Assets.craftCard[cs], 0, 0, null);
			answer[2] = Assets.craftCard[cs];
		}
//draws the correct stamp based on player choice
		if (s == 1) {//red stamp
			g.drawImage(Assets.s1, 0, 0, null);
			answer[3] = Assets.s1;
		} else if (s == 2) {//blue stamp
			g.drawImage(Assets.s2, 0, 0, null);
			answer[3] = Assets.s2;
		} else if (s == 3) {//green stamp
			g.drawImage(Assets.s3, 0, 0, null);
			answer[3] = Assets.s3;
		}

		//for when player is moving the flower from holder to the bouquet
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 25) && (MouseManager.getmx() < 90))
				&& ((MouseManager.getmy() > 100) && MouseManager.getmy() < 315) && (bq > 0)) {
			drag = true;
		}
		//if the player picked up the flower then draw it at the mouse coordinates
		if ((drag == true))
			g.drawImage(CraftStation.currentFlower, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
//if the player successfully dragged flower to the bouquet display the bouquet and remove the flower on the holder
		if ((drag == true) && ((MouseManager.getmx() > 263) && (MouseManager.getmx() < 489))
				&& ((MouseManager.getmy() > 121) && MouseManager.getmy() < 351) && (MouseManager.lPressed() == false)) {
			drag = false;
			yesPatch = true;
		}
		//displays flower in bouquet
		if (yesPatch == true)
			g.drawImage(Assets.patch[CraftStation.whichFlower], 0, 0, null);
		//goes to end screen if player clicked complete
		if (complete == true) {
			State.setState(Game.returnend());
		}
	}
}
