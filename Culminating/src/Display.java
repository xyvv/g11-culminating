import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
//The display class is used to create a window for all game states called up. Each window is set a fixed size
//with a canvas packed in so all other parts of the game are able to consistently draw images in.
public class Display {
    //all variable declaration; private variables are only accessed within the class
    private JFrame frame; //allows for window creation
    private Canvas canvas; //gives a place to draw images on
    private String title; //title of the window
    private int width, height; //width and height of the window
    
    
    //constructor to prepare the display class for use when called
    public Display (String title, int width, int height) {
        this.title=title;
        this.width=width;
        this.height=height;
      //calling the method to create a new window
        createWindow();
    }
    //method for generating a window
    private void createWindow() {
        //initilaizes the JFrame object 
        frame = new JFrame(title); //will display the name at the top of the window 
        frame.setSize(width,height); //sets the Jframe window to the value of width and height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing the JFrame
        frame.setResizable(false); //prevents user and dragging to change window size
        frame.setLocationRelativeTo(null); //puts the window at the middle of the computer screen
        frame.setVisible(true); //allows the window to be shown 
        
        canvas = new Canvas(); //canvas declaration - to be used to drawing images
        canvas.setPreferredSize(new Dimension(width, height)); //making sure the canvas is 
        canvas.setMaximumSize(new Dimension(width,height));  // the same size as the window
        canvas.setMinimumSize(new Dimension(width,height));
        
        frame.add(canvas); //adds the canvas to the Jframe
        frame.pack();
    }
    
    //methods to return the canvas and frame when needed for use for displays of  other classes
    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}

