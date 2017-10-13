import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Fence {
	static int fenceNum = 3;
	private static BufferedImage img;

	public Fence() {
		setImage();
	}
	
	/**
	 * Base image for fence
	 */
	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/fence.png"));
		} catch (IOException e) {
		}
		//System.out.println("this worked");
	}
	
	public static BufferedImage getImage() {
		return img;
	}
}
