package editphotos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class DrawStuff extends JComponent {
	
	//Gets the RGB value of a pixel at (x,y) of image.
	public int[] getPixelColor(int x, int y) {
		int color = Variables.image.getRGB(x - 96, y - 30);
		Color c = new Color(color, true);
		int[] rgb = new int[3];
		rgb[0] = c.getRed();
		rgb[1] = c.getGreen();
		rgb[2] = c.getBlue();
		
		return rgb;
	}
	
	//Gets the RGB integer value of a pixel at (x,y) of image.
	public int getPixelColorInt(int x, int y) {
		int color = Variables.image.getRGB(x - 96, y - 30);
		
		return color;
	}
	
	//Gets the RGB integer value of a pixel at (x,y) of colorWheel.
	public int getColorWheelInt(int x, int y) {
		int x1 = x - 16;
		int y1 = y - 38;
		int color = Variables.colorWheel.getRGB(x1, y1);
		
		return color;
	}
	
	//Sets the RGB integer value of a pixel at (x,y) of image.
	public void setPixelColor(int x, int y, int rgb) {
		Variables.image.setRGB(x - 96, y - 30, rgb);
	}
	
	//Replaces any pixel in image equal to the first RGB integer value with the second RGB integer value.
	public void replaceColor(int rgb, int newRGB) {
		for (int iy = 0; iy < 720; iy ++) {
			for (int ix = 0; ix < 900; ix ++) {
				if (Variables.image.getRGB(ix, iy) == rgb) {
					Variables.image.setRGB(ix, iy, newRGB);
				}
			}
		}
	}
	
	public void paint(Graphics g) {
		
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graph2.drawImage(Variables.image, 88, 0, (ImageObserver) this);
		
		graph2.drawImage(Variables.colorWheel, 8, 8, (ImageObserver) this);
		
	}

}
