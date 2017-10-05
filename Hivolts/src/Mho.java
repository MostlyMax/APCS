
public class Mho {
	static int mhoNum = 2;
	int mhoX;
	int mhoY;

	public Mho(int xcoord, int ycoord) {
		this.mhoX = xcoord;
		this.mhoY = ycoord;
	}

	public void moveMho (Board b, Player player) {
	
		//get coordinates of player
		int playerX = player.posX;
		int playerY = player.posY;

		int distX = Math.abs(playerX-mhoX);
		int distY = Math.abs(playerY-mhoY);

		//first move vertical/horizontal if directly above/to the side
		if (distX == 0) {
			mhoX = 0;
			if (Math.abs(playerY-(mhoY + 1)) < distY) {
				mhoY++;
			}
			else {
				mhoY--;
			}
		}
		
		else if (distY == 0) {
			mhoY = 0;
			if (Math.abs(playerX-(mhoX + 1)) < distX) {
				mhoX++;
			}
			else {
				mhoX--;
			}
		}
	}
}
