import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game{
	private Board gameBoard;
	private Player player;
	private JFrame f;
	
	public Game(JFrame f) {
		this.f = f;
	}
	
	public void game(){
		gameBoard = new Board();
		player = new Player();
		gameBoard.createPlayer(player);
		
		gameBoard.showBoard();
		// clear old keylisteners if needed 
		KeyListener[] keyListeners = f.getKeyListeners();
		if (keyListeners.length != 0) f.removeKeyListener(keyListeners[0]);
		
		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
						case KeyEvent.VK_W:
							move('W', player);
							break;
						case KeyEvent.VK_A:
							move('A', player);
							break;
						case KeyEvent.VK_S:
							move('S', player);
							break;
						case KeyEvent.VK_D:
							move('D', player);
							break;
						case KeyEvent.VK_Q:
							move('Q', player);
							break;
						case KeyEvent.VK_E:
							move('E', player);
							break;
						case KeyEvent.VK_Z:
							move('Z', player);
							break;	
						case KeyEvent.VK_X:
							move('X', player);
							break;	
						case KeyEvent.VK_SPACE:
							if (player.isDead()) {
								reset(f);
							}
							break;	
					}
			}
			
			public void keyReleased(KeyEvent e) {
			}
		});
			
	}
	
	public void reset(JFrame f) {
		player = null;
		gameBoard = null;
		
		
//		for (int i = 0; i<12; i++) {
//			for (int j = 0; j<12; j++) {
//				gameBoard.getGameBoard()[i][j] = 0;
//			}
//		}
		
		game();
		
	}
				
	public void move(char input, Player player) {
		gameBoard.getGameBoard()[player.posY][player.posX] = 0;
		
		if (player.dead) return; 
		switch (input) {
			case 'W':
				if (gameBoard.getGameBoard()[player.posY-1][player.posX] != 0) player.death();
				player.setPos(player.posY-1, player.posX);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				//System.out.println('w');
				//update();
				break;
			case 'A':
				if (gameBoard.getGameBoard()[player.posY][player.posX-1] != 0) player.death();
				player.setPos(player.posY, player.posX-1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'S':
				if (gameBoard.getGameBoard()[player.posY+1][player.posX] != 0) player.death();
				player.setPos(player.posY+1, player.posX);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'D':
				if (gameBoard.getGameBoard()[player.posY][player.posX+1] != 0) player.death();
				player.setPos(player.posY, player.posX+1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'Q':
				if (gameBoard.getGameBoard()[player.posY-1][player.posX-1] != 0) player.death();
				player.setPos(player.posY-1, player.posX-1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'E':
				if (gameBoard.getGameBoard()[player.posY-1][player.posX+1] != 0) player.death();
				player.setPos(player.posY-1, player.posX+1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'Z':
				if (gameBoard.getGameBoard()[player.posY+1][player.posX-1] != 0) player.death();
				player.setPos(player.posY+1, player.posX-1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
			case 'X':
				if (gameBoard.getGameBoard()[player.posY+1][player.posX+1] != 0) player.death();
				player.setPos(player.posY+1, player.posX+1);
				gameBoard.getGameBoard()[player.posY][player.posX] = 1;
				break;
		}
		
		gameBoard.showBoard();
		
		//move mhos

	}

	public static void main(String[] args) {
			JFrame f = new JFrame("Hivolts");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(250, 250);
			f.setVisible(true);
			
			Game hivolts = new Game(f);
			hivolts.game();
			

	}
	

}
