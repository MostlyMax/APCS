
public class Intro {
	
	
	/**
	 * 
	 * @return returns 17
	 */
	public int ret(){
		return 17;
	}
	
	/**
	 * 
	 * @param boolean a
	 * @param boolean b
	 * @param boolean c
	 * @return returns the truth value of a and b and c
	 */
	public boolean logic(boolean a, boolean b, boolean c) {
		return a&&b&&c;
	}
	
	/**
	 * 
	 * @param integer num
	 * @return returns a left sided triangle of stars in a single string
	 */
	public static String stars(int num){
		String stars = "";
		for (int i=0; i<num; i++){
			for (int j=0;j<=i;j++){
				stars = stars + "*";
			}
			stars = stars + "\n";
		}
		return stars;
	}
	
	/**
	 * 
	 * @param integer n
	 * @return the minimum amount of 5 and 2 cent coins needed to make value n
	 */
	public static int coins(int n){
		int coinAmount = 0;
		
		while (n>0) {
			
			if ((n>=5)&&(n-5>1)) {
				n=n-5;
				coinAmount++;
				//System.out.println("add 5");
				continue;
			}
			
			if (n>=2) {
				n=n-2;
				coinAmount++;
				//System.out.println("add 2");

			}
			
			else if(n==1){
				coinAmount=-1;
				break;
			}
		}
		
		return coinAmount;
		
		
	
	}
	
	public static void main(String[] args){
	}

}


