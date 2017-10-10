public class Player{
	int posX;
	int posY;
	boolean dead = false;
	boolean turn = true;

	public boolean isDead() {
		return dead;
	}

	public Player() {

	}
	
	public void setPos(int Y, int X) {
		this.posX = X;
		this.posY = Y;
	}
	
	public void death() {
		System.out.println("You died!");
		System.out.println("Press 'space' to play again");
		turn = false;
		dead = true;
		//System.exit(0);
	}
	
}
