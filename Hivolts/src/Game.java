import java.awt.event.KeyEvent;

public class Game {
	
	public Game(Board gameBoard){
		//Player player = new Player(gameBoard);
		
		String turn = "player";
		//gameBoard.createPlayer(player);
		
		if (turn.equals("player")) {
			
		}
	}

	public static void main(String[] args) {

		while(true) {
			Board gameBoard = new Board();
			//System.out.println("x");
			gameBoard.showBoard();
			
			//Game game = new Game(gameBoard);
		}
	}
	
	public void move(KeyEvent e, Player player) {
		
		int key = e.getKeyCode();
		System.out.println("you did it");
		
		switch(key){
			case KeyEvent.VK_W: player.moveUp();
		}
	}

}
