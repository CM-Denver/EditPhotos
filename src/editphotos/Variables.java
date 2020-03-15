package editphotos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Variables {
	public static int newRGB;
	public static int sizeX = 980;
	public static int sizeY = 720;
	
	public static BufferedImage image;
	public static BufferedImage colorWheel;
	
	public static void setImage(String fileName) throws IOException {
		File img = new File(fileName);
		image = ImageIO.read(img);
	}
	
	public static void setColorWheel(String fileName) throws IOException {
		File img = new File(fileName);
		colorWheel = ImageIO.read(img);
	}

}
