import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Main {

	/**
	 * Initializes flag
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setSize(350,250);
		
		USFlag flag = new USFlag();
		
		frame.add(flag);
		frame.setVisible(true);
	}
	
}
