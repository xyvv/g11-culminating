import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
//This class is used to load in all the images in the assets class that will be required for the game 
public class ImageLoad {

	public static BufferedImage loadImage (String path) {
		try {
		return ImageIO.read(ImageLoad.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null; 
	}
}
