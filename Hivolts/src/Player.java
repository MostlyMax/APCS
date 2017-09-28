import java.awt.event.KeyEvent;

public class Player {
	Board gameBoard;
	int posX;
	int posY;

	public Player(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public  void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void playerMove(KeyEvent e) {
		
	}
	
	public void moveUp() {
		posY++;
	}

}
