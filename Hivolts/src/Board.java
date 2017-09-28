
public class Board {
	int[][] gameBoard = new int[12][12];
	
	public Board() {
		createBorder();
		createFence();
		createMho();
		//createPlayer();
	}
	
	public void createPlayer(Player player) {
		int cord1=0;
		int cord2=0;
		
		while((this.gameBoard[cord1][cord2]==3)||(this.gameBoard[cord1][cord2]==2)) {
			cord1 = getRand(1,12);
			//System.out.println(cord1);				
			cord2 = getRand(1,12);
			//System.out.println(cord2);
			player.setPos(cord1, cord2);
		}
			
		this.gameBoard[cord1][cord2] = 1;
	}


	public void createMho() {
		int cord1=0;
		int cord2=0;
		
		for (int i = 0; i<12; i++) {
			//System.out.print(i);
			while((this.gameBoard[cord1][cord2]==3)||(this.gameBoard[cord1][cord2]==2)) {
				cord1 = getRand(1,12);
				//System.out.println(cord1);
				cord2 = getRand(1,12);
				//System.out.println(cord2);
			}
			
			this.gameBoard[cord1][cord2] = 2;
		}
		
	}

	public void createBorder() {
		for (int i = 0; i<12; i++) {
			this.gameBoard[0][i] = 3;
			this.gameBoard[11][i] = 3;
			this.gameBoard[i][0] = 3;
			this.gameBoard[i][11] = 3;
		}
	}
	
	public void createFence() {
		//Random FC = new Random();
		int cord1=0;
		int cord2=0;
		
		for (int i = 0; i<20; i++) {
			//System.out.print(i);
			while(gameBoard[cord1][cord2]==3) {
				cord1 = getRand(1,12);
				//System.out.println(cord1);
				cord2 = getRand(1,12);
				//System.out.println(cord2);
			}
			
			this.gameBoard[cord1][cord2] = 3;
		}
		
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return random # between given min and max
	 */
	public static int getRand(int min, int max) {
		int retVal = -1;
		
		while(retVal<min) {
			retVal = (int) Math.ceil((Math.random()*(max-1)));
			//System.out.println("rand:"+retVal);
		}
		
		return retVal;
	}
	
	public void showBoard() {
		for(int i=0; i<12; i++) {
			for (int j = 0; j<12; j++) {
				System.out.print(this.gameBoard[i][j]+" ");
			}
			System.out.println();
		}
	}
}
