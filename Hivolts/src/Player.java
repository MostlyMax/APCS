import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player{
	int posX;
	int posY;
	boolean dead = false;
	boolean turn = true;
	static BufferedImage img;

	public boolean isDead() {
		return dead;
	}

	public Player() {
		setImage();
	}
	
	public void setPos(int Y, int X) {
		this.posX = X;
		this.posY = Y;
	}
	
	/**
	 * sets death message and updates game
	 * @param f
	 */
	public void death(JFrame f) {
		setImageDead();
		
		JPanel panel = new JPanel();
		
		JLabel die = new JLabel("You Died!"); 
		JLabel again = new JLabel("Press SPACE to play again");
		die.setHorizontalTextPosition(JLabel.CENTER);
		again.setHorizontalTextPosition(JLabel.CENTER);
		again.setVerticalTextPosition(JLabel.BOTTOM);
		again.setFont(new Font(die.getName(), Font.PLAIN, 25));
		die.setFont(new Font(die.getName(), Font.PLAIN, 25));
		//die.setSize(200, 200);
		panel.add(die);
		panel.add(again);
		
		panel.setBackground(Color.WHITE);
		
		f.add(panel);
		f.setVisible(true);
		//System.out.println("You died!");
		//f.add
		//System.out.println("Press 'space' to play again");
		
		turn = false;
		dead = true;
		//System.exit(0);
	}
	
	/**
	 * sets base player image
	 */
	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/player.png"));
		} catch (IOException e) {
		}
	}
	
	/**
	 * sets image for dead player
	 */
	public static void setImageDead() {
		try {
		    img = ImageIO.read(new File("res/deadplayer.png"));
		} catch (IOException e) {
		}
	}
	
	public static BufferedImage getImage() {
		return img;
	}	
	
}
