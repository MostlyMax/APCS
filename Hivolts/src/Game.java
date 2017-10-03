import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game{
	
	public void game(JFrame f){
		Board gameBoard = new Board();
		Player player = new Player();
		gameBoard.createPlayer(player);
		
		Board.showBoard();
		
		f.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if (Player.turn) {
					//Player.turn = false;
					switch (e.getKeyCode()) {
						case KeyEvent.VK_W:
							if(checkMove('W', player))
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
					}
				}
			}
			
			private boolean checkMove(char input, Player player) {
				// TODO Auto-generated method stub
				return true;
			}

			public void keyReleased(KeyEvent e) {
			}
		});
			
	}
	
	public void move(char input, Player player) {
		Board.gameBoard[player.posY][player.posX] = 0;
		
		switch (input) {
			case 'W':
				player.setPos(player.posY-1, player.posX);
				Board.gameBoard[player.posY][player.posX] = 1;
				System.out.println('w');
				//update();
				break;
			case 'A':
				player.setPos(player.posY, player.posX-1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'S':
				player.setPos(player.posY+1, player.posX);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'D':
				player.setPos(player.posY, player.posX+1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'Q':
				player.setPos(player.posY-1, player.posX-1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'E':
				player.setPos(player.posY-1, player.posX+1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'Z':
				player.setPos(player.posY+1, player.posX-1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
			case 'X':
				player.setPos(player.posY+1, player.posY+1);
				Board.gameBoard[player.posY][player.posX] = 1;
				break;
		}
		
		Board.showBoard();
		
		//move mhos

	}
	

	private void update() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
			JFrame f = new JFrame("Hivolts");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(250, 250);
			f.setVisible(true);
			
			Game hivolts = new Game();
			hivolts.game(f);
			

	}
	

}
