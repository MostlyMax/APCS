import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class USFlag extends JPanel{
	
	/**
	 * Draws the stripes of the flag
	 * @param height
	 * @param width
	 * @param g
	 */
	public static void drawStripes(double height, double width, Graphics g) {
		
		for (int i=0; i<13; i++) {
			if (i%2==0) g.setColor(Color.RED);
			else g.setColor(Color.WHITE);
			
			g.fillRect(0, (int) (i*.07692*height), (int) width,(int)(.07692*height));
		}
		
	}
	
	/**
	 * Draws a blue rectangle for the unity of the flag
	 * @param height
	 * @param width
	 * @param g
	 */
	public static void drawUnity(double height, double width, Graphics g) {
		double tempHeight = height*.5385;
		double tempWidth = width*.4;
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, (int)(tempWidth), (int) tempHeight);
	}
	
	/**
	 * Creates a row of stars
	 * @param height
	 * @param width
	 * @param g
	 */
	public static void drawStars(double height, double width, Graphics g) {
		
		g.setColor(Color.WHITE);
		for (int i=1; i<=9; i++) {
			if (i%2!=0) {
				for (int j=1; j<=11; j+=2) {
					makeStar(height, j, i, g);
				}
			}
			else {
				for (int j=2; j<=10; j+=2) {
					makeStar(height, j, i, g);	
				}
			}
		}
		
	}
	
	/**
	 * Draws a single star
	 * @param height
	 * @param numX
	 * @param numY
	 * @param g
	 */
	public static void makeStar(double height, int numX, int numY, Graphics g) {
		double radius = .0308*height;
		int[] cx = new int[10];
		int[] cy = new int[10];
		
		for (int i=0; i<10; i++) {
			if (i%2==1) radius/=.5;
			if (i%2==0) radius*=.5;
			cx[i] = (int)(radius*Math.cos((i+.5)*(2*Math.PI)/10)+.063*height*numX);
			cy[i] = (int)(radius*Math.sin((i+.5)*(2*Math.PI)/10)+.054*height*numY);
		}
		g.fillPolygon(cx,cy,10);
	}
		
	
	public void paintComponent(Graphics g) {
		double height = super.getHeight();
		double width = super.getWidth();
		
		if (height>width/1.9) {
			height = width/1.9;
		}
		if (height<width/1.9) {
			width=height*1.9;
		}
		
		drawStripes(height, width, g);
		drawUnity(height, width, g);
		drawStars(height, width, g);
	}


}
