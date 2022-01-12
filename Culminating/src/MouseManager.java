import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/*The mouse manager class gets the position of the players cursor and tracks 
 * if the mouse was clicked and etc.*/
public class MouseManager implements MouseListener, MouseMotionListener {
//variables to determine mouse button pressed and the coordinates of the cursor
	private static boolean leftPressed;
	private boolean rightPressed;
	private static int mx;
	private static int my;

	public MouseManager() {

	}
//methods that return what the mouse is doing
	public static boolean lPressed() {
		return leftPressed;
	}

	public boolean rPressed() {
		return rightPressed;
	}

	public static int getmx() {
		return mx;
	}

	public static int getmy() {
		return my;

	}
	//--------------------------------------------
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}

	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}

	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
	

	}

}
