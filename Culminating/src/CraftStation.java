import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*The two craft stations are the main playing parts of the game - 
The craft station class is used to display the first craft station where the player has the option to   
select the correct flower and corresponding colour for use the craft station part two. */
public class CraftStation extends State {
//variable declarations
	// variable used to track if a player clicked on a coloured jar
	// and if a dipping animation needs to be displayed.
	boolean yesDip = false;
	// variable used to track whether or not the player turned hints on
	boolean hintOn = false;
	// numbers used to track what flower type and colour was selected
	static int whichFlower = 0;
	static int flowerColour = 0;
	static int pickUp = 0;
	// numbers for the dipping animation
	static int dip = 0;
	static int speed = 0;
	// variable to transfer what flower was selected to craft station 2
	static BufferedImage currentFlower;

	// All states contain an update and render method as a part of a game loop
	// method to update variables related to buttons, mouse presses etc
	public void update() {

		if (pickUp > 0) {
			// if player clicks on the blue coloured jar - flower colour set to blue,
			// dipping animation initiated
			if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 60) && (MouseManager.getmx() < 165))
					&& ((MouseManager.getmy() > 210) && MouseManager.getmy() < 385)) {
				flowerColour = 1;
				yesDip = true;
				// if player clicks on the purple coloured jar - flower colour set to purple,
				// dipping animation initiated
			} else if ((MouseManager.lPressed() == true)
					&& ((MouseManager.getmx() > 210) && (MouseManager.getmx() < 320))
					&& ((MouseManager.getmy() > 210) && MouseManager.getmy() < 385)) {
				flowerColour = 2;
				yesDip = true;
			}

		}
		// Taking to the player to a different part of the game from buttons
		if ((MouseManager.lPressed() == true) && (yesDip == false)) {
			if (((MouseManager.getmx() > 5) && (MouseManager.getmx() < 65))
					&& ((MouseManager.getmy() > 10) && MouseManager.getmy() < 60)) {
				// back button goes back to the flower shop
				State.setState(Game.returngame());
			} else if (((MouseManager.getmx() > 710) && (MouseManager.getmx() < 770))
					&& ((MouseManager.getmy() > 10) && MouseManager.getmy() < 60)) {
				// forward button leading to craft station two without flower completion
				State.setState(Game.returncraft2());
			} else if ((MouseManager.lPressed() == true)
					// button leading to craft station two after the flower and colour is selected
					&& ((MouseManager.getmx() > 670) && (MouseManager.getmx() < 800))
					&& ((MouseManager.getmy() > 65) && MouseManager.getmy() < 333) && (flowerColour > 0)) {
				State.setState(Game.returncraft2());
				// array to keep track of the user's choices for determining points at the end
				End.checker[0] = pickUp - 1;
				End.checker[1] = flowerColour - 1;
			} else {
				// drops the flower if the player clicks anywhere random on the screen
				pickUp = 0;
				flowerColour = 0;
			}

		}

//determining which flower the player picked up by coordinates: each number corresponds to a flower type
		if (MouseManager.lPressed() == true) {
			if (((MouseManager.getmx() > 550) && (MouseManager.getmx() < 625))
					&& ((MouseManager.getmy() > 400) && MouseManager.getmy() < 600)) {
				pickUp = 1; // rose
			} else if (((MouseManager.getmx() > 645) && (MouseManager.getmx() < 710))
					&& ((MouseManager.getmy() > 400) && MouseManager.getmy() < 600)) {
				pickUp = 2; // daisies
			} else if (((MouseManager.getmx() > 730) && (MouseManager.getmx() < 775))
					&& ((MouseManager.getmy() > 400) && MouseManager.getmy() < 600)) {
				pickUp = 3; // lavender
			}
		}

		// numbers for the dipping flower animations
		// speed ensures a steady animation speed
		// dip is the frame number, resets at 12.
		speed += 1;
		if (speed == 10) {
			dip += 1;
			speed = 0;
		}
		if (dip > 13) {
			dip = 0;
		}
		// If statement to turn on or off hints if the player clicks the hint button
		if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 10) && (MouseManager.getmx() < 90))
				&& ((MouseManager.getmy() > 560) && MouseManager.getmy() < 590) && (hintOn == false)) {
			hintOn = true; // will be used in the render method to show hints
		} else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 10) && (MouseManager.getmx() < 90))
				&& ((MouseManager.getmy() > 560) && MouseManager.getmy() < 590) && (hintOn == true)) {
			hintOn = false; // will be used in the render method to disable hints
		}
	}

//renders class updates images/displays
	public void render(Graphics g) {
		// display the background and arrow buttons
		g.drawImage(Assets.craft1Bg, 0, 0, null);
		g.drawImage(Assets.backButton, 5, 10, null);
		g.drawImage(Assets.forwardArrow, 710, 10, null);
		// draws the flower that the user picked up at their mouse coordinate -
		// number stored in the variable flowercolour
		// determines what colour the flower is, and the number in the variable pickup
		// determines what type of flower was picked up - combined to display what the
		// user selected.
		// plain flowers picked up
		if (flowerColour == 0) {
			if (pickUp == 1) {
				g.drawImage(Assets.plainRose, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
			} else if (pickUp == 2) {
				g.drawImage(Assets.plainDaisie, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
			} else if (pickUp == 3) {
				g.drawImage(Assets.plainLav, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
			}
			// blue flowers picked up - (yesDip false ensures flower does not show when
			// animation is happening)
		} else if ((flowerColour == 1) && (yesDip == false)) {
			if (pickUp == 1) {// rose
				g.drawImage(Assets.rose1, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.rose1;
				whichFlower = 0;
			} else if (pickUp == 2) { // daisies
				g.drawImage(Assets.daisie1, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.daisie1;
				whichFlower = 2;
			} else if (pickUp == 3) { // lavender
				g.drawImage(Assets.lav1, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.lav1;
				whichFlower = 4;
			}
			// purpler flower is picked up
		} else if ((flowerColour == 2) && (yesDip == false)) {
			if (pickUp == 1) { // rose
				g.drawImage(Assets.rose2, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.rose2;
				whichFlower = 1;
			} else if (pickUp == 2) { // daisies
				g.drawImage(Assets.daisie2, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.daisie2;
				whichFlower = 3;
			} else if (pickUp == 3) { // lavender
				g.drawImage(Assets.lav2, (MouseManager.getmx() - 50), (MouseManager.getmy() - 50), null);
				currentFlower = Assets.lav2;
				whichFlower = 5;
			}
		}
		// if statement for displaying flower dipping animations
		// flower colour and pickup ensures the animation for the right type of flower
		// is displayed
		if (yesDip == true) {
			if (flowerColour == 1) {
				if (pickUp == 1) {
					g.drawImage(Assets.blueRose[dip], 0, 0, null);
				} else if (pickUp == 2) {
					g.drawImage(Assets.blueDaisie[dip], 0, 0, null);
				} else if (pickUp == 3) {
					g.drawImage(Assets.blueLav[dip], 0, 0, null);
				}
			} else if (flowerColour == 2) {
				if (pickUp == 1) {
					g.drawImage(Assets.purpleRose[dip], 0, 0, null);
				} else if (pickUp == 2) {
					g.drawImage(Assets.purpleDaisie[dip], 0, 0, null);
				} else if (pickUp == 3) {
					g.drawImage(Assets.purpleLav[dip], 0, 0, null);
				}
			}
			// stops the animation once all frames have displayed once
			if (dip == 13)
				yesDip = false;
		}
        //if statement for turning on hints if the user clicked the hint button
		if (hintOn == true) {
			g.drawImage(Assets.yesHint, 0, 0, null);
		}
	}
}
