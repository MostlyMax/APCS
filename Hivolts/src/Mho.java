
public class Mho {
	static int mhoNum = 2;
	int mhoX;
	int mhoY;
	boolean mhoDead = false;

	public Mho(int ycoord, int xcoord) {
		this.mhoX = xcoord;
		this.mhoY = ycoord;
	}

	public void moveMho (Board b, Player player) {
	
		//get coordinates of player
		int playerX = player.posX;
		int playerY = player.posY;

		int distX = Math.abs(playerX-mhoX);
		int distY = Math.abs(playerY-mhoY);
		
		b.getGameBoard()[mhoY][mhoX] = 0;

		//first move vertical/horizontal if directly above/to the side
		if (distX == 0) {
	
			if (Math.abs(playerY-(mhoY + 1)) < distY) {
				if(checkPDeath(b, mhoX, mhoY+1)) player.death();
				if(checkMDeath(b, mhoX, mhoY+1)) mhoDeath(b);
				mhoY++;
			}
			else {
				if(checkPDeath(b, mhoX, mhoY-1)) player.death();
				if(checkMDeath(b, mhoX, mhoY-1)) mhoDeath(b);
				mhoY--;
			}
		}
		
		else if (distY == 0) {
		
			if (Math.abs(playerX-(mhoX + 1)) < distX) {
				if(checkPDeath(b, mhoX+1, mhoY)) player.death();
				if(checkMDeath(b, mhoX+1, mhoY)) mhoDeath(b);
				mhoX++;
			}
			else {
				if(checkPDeath(b, mhoX-1, mhoY)) player.death();
				if(checkMDeath(b, mhoX-1, mhoY)) mhoDeath(b);
				mhoX--;
			}
		}
		
		
		b.getGameBoard()[mhoY][mhoX] = 2;
	}
	
	public boolean checkPDeath(Board b, int x, int y) {
		if (b.getGameBoard()[y][x]==1) return true;
		else return false;
	}
	
	public boolean checkMDeath(Board b, int x, int y) {
		if (b.getGameBoard()[y][x]==3) return true;
		else return false;
	}
	
	public void mhoDeath(Board b) {
		b.getGameBoard()[mhoY][mhoX] = 0;
		this.mhoDead = true;
		
	}
}
