import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Mho {
	static int mhoNum = 2;
	int mhoX;
	int mhoY;
	boolean mhoDead = false;
	BufferedImage img;
	private JFrame f;
	
	public Mho(int ycoord, int xcoord, JFrame f) {
		this.mhoX = xcoord;
		this.mhoY = ycoord;
		this.f = f;
		setImage();
	}

	/**
	 * Calculates movement for mho
	 * @param b
	 * @param player
	 */
	public void moveMho (Board b, Player player) {

		//get coordinates of player
		int playerX = player.posX;
		int playerY = player.posY;

		int distX = Math.abs(playerX-mhoX);
		int distY = Math.abs(playerY-mhoY);
		
		int closeX = 0;
		int closeY = 0;
		
		if (playerX<mhoX) closeX = -1;
		if (playerX>mhoX) closeX = 1;
		if (playerY<mhoY) closeY = -1;
		if (playerY>mhoY) closeY = 1;
		
		
		b.getGameBoard()[mhoY][mhoX] = 0;

		//first move vertical/horizontal if directly above/to the side
		if (distX == 0) {
	
			if (Math.abs(playerY-(mhoY + 1)) < distY) {
				if(checkPDeath(b, mhoX, mhoY+1)) player.death(f);
				if(checkMDeath(b, mhoX, mhoY+1)) mhoDeath(b);
				mhoY++;
			}
			else {
				if(checkPDeath(b, mhoX, mhoY-1)) player.death(f);
				if(checkMDeath(b, mhoX, mhoY-1)) mhoDeath(b);
				mhoY--;
			}
		}
		
		else if (distY == 0) {
		
			if (Math.abs(playerX-(mhoX + 1)) < distX) {
				if(checkPDeath(b, mhoX+1, mhoY)) player.death(f);
				if(checkMDeath(b, mhoX+1, mhoY)) mhoDeath(b);
				mhoX++;
			}
			else {
				if(checkPDeath(b, mhoX-1, mhoY)) player.death(f);
				if(checkMDeath(b, mhoX-1, mhoY)) mhoDeath(b);
				mhoX--;
			}
		}
		
		else {
			
			boolean noMho = false;
			boolean noFence = false;
			
			for (int i = 0; i<2; i++) {
				if (i==2) noFence = true;
				
				if (i!=2) noFence = !(b.getGameBoard()[mhoY+closeY][mhoX+closeX]==3);
				noMho = !(b.getGameBoard()[mhoY+closeY][mhoX+closeX]==2);
				if (noFence) {
					if (noMho) {
						//System.out.println("diag");
						//System.out.println(mhoX + " "+ mhoY);
						if(checkPDeath(b, mhoX+closeX, mhoY+closeY)) player.death(f);
						if(checkMDeath(b, mhoX+closeX, mhoY+closeY)) mhoDeath(b);
						mhoX+=closeX;
						mhoY+=closeY;
						//System.out.println(mhoX+" "+mhoY);
						break;
					}
				}
				
				if (i!=2) noFence = !(b.getGameBoard()[mhoY][mhoX+closeX]==3);
				noMho = !(b.getGameBoard()[mhoY][mhoX+closeX]==2);
				if (noFence&&(distX>=distY)) {
					if (noMho) {
						//System.out.println("horizontal");
						if(checkPDeath(b, mhoX+closeX, mhoY)) player.death(f);
						if(checkMDeath(b, mhoX+closeX, mhoY)) mhoDeath(b);
						mhoX+=closeX;
						break;
					}
				}
				
				if (i!=2) noFence = !(b.getGameBoard()[mhoY+closeY][mhoX]==3);
				noMho = !(b.getGameBoard()[mhoY+closeY][mhoX]==2);
				if (noFence&&(distX<=distY)) {
					if (noMho) {
						if(checkPDeath(b, mhoX, mhoY+closeY)) player.death(f);
						if(checkMDeath(b, mhoX, mhoY+closeY)) mhoDeath(b);
						mhoY+=closeY;
						break;
					}
				}
						
			}
	
		}		
		
		
		if (!(this.mhoDead == true)) b.getGameBoard()[mhoY][mhoX] = 2;
	}
	
	/**
	 * checks if mho will hit a player
	 * @param b
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean checkPDeath(Board b, int x, int y) {
		if (b.getGameBoard()[y][x]==1) {setImageCaught(); return true;}
		else return false;
	}
	
	/**
	 * Checks if mho will hit a wall
	 * @param b
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean checkMDeath(Board b, int x, int y) {
		if (b.getGameBoard()[y][x]==3) {setImageDead(); mhoDead = true; return true;}
		else return false;
	}
	
	/**
	 * Sets a mho as dead
	 * @param b
	 */
	public void mhoDeath(Board b) {
		b.getGameBoard()[mhoY][mhoX] = 0;
		this.mhoDead = true;
		
	}
	
	/**
	 * sets base image
	 */
	public void setImage() {
		try {
		    img = ImageIO.read(new File("res/mho.png"));
		} catch (IOException e) {
		}
	}
	
	/**
	 * sets image for loss
	 */
	public void setImageCaught() {
		try {
		    img = ImageIO.read(new File("res/evil.png"));
		} catch (IOException e) {
		}
	}
	
	/**
	 * sets image for dead mho
	 */
	public void setImageDead() {
		try {
		    img = ImageIO.read(new File("res/deadmho.png"));
		} catch (IOException e) {
		}
	}
	
	public BufferedImage getImage() {
		return img;
	}	
}
