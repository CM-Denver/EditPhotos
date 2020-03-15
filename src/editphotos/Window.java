package editphotos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() throws IOException {
		JFrame frame = new JFrame("Edit Photos");
		frame.setVisible(true);
		frame.setSize(Variables.sizeX, Variables.sizeY);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DrawStuff canvas = new DrawStuff();
		
		Variables.setImage("test.png");
		Variables.setColorWheel("wheel.png");
		
		frame.add(canvas);
		
		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				//int rgb = 1644825;
				//canvas.setPixelColor(x, y, rgb);
				
				if (e.getButton() == MouseEvent.BUTTON3) {
					Variables.newRGB = canvas.getColorWheelInt(x, y);
				}
				else {
					int rgb = canvas.getPixelColorInt(x, y);
					canvas.replaceColor(rgb, Variables.newRGB);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		while (true) {
			canvas.repaint();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Window();
	}

}
