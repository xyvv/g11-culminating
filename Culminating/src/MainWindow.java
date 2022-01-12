
import java.awt.Graphics;


public class MainWindow extends State {

	// method to update variables related to buttons, mouse presses etc
    public void update() {
       //if statements that track where the player clicked with coordinates - 
    	//if the coordinates match to a button then the function of that button will be called.
        if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 260) && (MouseManager.getmx() < 360))
                && ((MouseManager.getmy() > 310) && MouseManager.getmy() < 360)) {
        	//play button goes to game window
            State.setState(Game.returngame());
        } else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 410) && (MouseManager.getmx() < 510))
                && ((MouseManager.getmy() > 310) && MouseManager.getmy() < 360)) {
        	//settings button goes to settings window
            State.setState(Game.returnsetting());
        } else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 260) && (MouseManager.getmx() < 360))
                && ((MouseManager.getmy() > 380) && MouseManager.getmy() < 430)) {
        	//help button goes to help window
            State.setState(Game.returnhelp());
        } else if ((MouseManager.lPressed() == true) && ((MouseManager.getmx() > 410) && (MouseManager.getmx() < 510))
                && ((MouseManager.getmy() > 380) && MouseManager.getmy() < 430)) {
        	//quit button closes the program
            System.exit(0);
        }
    }
 // render method for showing updated graphics
    public void render(Graphics g) {
    	//draws all the buttons
        g.drawImage(Assets.mainBg, 0, 0, null);
        g.drawImage(Assets.playButton, 260, 310, null);
        g.drawImage(Assets.helpButton, 260, 380, null);
        g.drawImage(Assets.settingButton, 410, 310, null);
        g.drawImage(Assets.quitButton, 410, 380, null);
        
        //if the mouse hovers a button it will change colour
        if (((MouseManager.getmx() > 260) && (MouseManager.getmx() < 360))
                && ((MouseManager.getmy() > 310) && MouseManager.getmy() < 360)) {
            g.drawImage(Assets.yesPlay, 260, 310, null);
        } else if (((MouseManager.getmx() > 410) && (MouseManager.getmx() < 510))
                && ((MouseManager.getmy() > 310) && MouseManager.getmy() < 360)) {
            g.drawImage(Assets.yesSetting, 410, 310, null);
        } else if ( ((MouseManager.getmx() > 260) && (MouseManager.getmx() < 360))
                && ((MouseManager.getmy() > 380) && MouseManager.getmy() < 430)) {
            g.drawImage(Assets.yesHelp, 260, 380, null);
        } else if ( ((MouseManager.getmx() > 410) && (MouseManager.getmx() < 510))
                && ((MouseManager.getmy() > 380) && MouseManager.getmy() < 430)) {
            g.drawImage(Assets.yesQuit, 410, 380, null);
        }
    }

}

