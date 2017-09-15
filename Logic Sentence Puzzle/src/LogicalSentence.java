import java.util.Arrays;
import java.util.Hashtable;

public class LogicalSentence {
	PropositionConstant PC;
	
	public LogicalSentence() {

	}
	
	public LogicalSentence(PropositionConstant PC) {
		this.PC = PC;
	}
	
	public static void main(String[] args) {
		PropositionConstant a = new PropositionConstant("a");
		PropositionConstant b = new PropositionConstant("b");
		LogicalSentence l1 = new LogicalSentence(a);
		LogicalSentence l2 = new LogicalSentence(b);
		LogicalSentence l3 = new Negation(l1);
		//!a
		LogicalSentence l4 = new Negation(l3);
		//!!a
		LogicalSentence l5 =  new Conjunction(l3, new Negation(l4));
		//!a&!!!a

		TruthAssignment ta1 = new TruthAssignment();
		ta1.put(b,true);
		ta1.put(a, false); 
		System.out.println(l5.evaluate());
		System.out.println(legal("a&"));
		System.out.println(findMatch("a(b)", 0));

		String[] pc = {"p", "q", "r"};
		truthTable(pc);

	}

	/**
	 * Prints a truth table using binary numbers
	 * @param pc
	 */
	private static void truthTable(String[] pc) {
		int col = (int)Math.pow(2, pc.length);

		System.out.println("\nTruth Table:");
		for (String temp : pc) System.out.print(temp+"\t");
		System.out.println();
		
		for (int i = 0; i<col; i++) {
			toBool(Integer.toBinaryString(i), pc.length);
			System.out.println();
		}
	}

	/**
	 * converts a binary number to true/false values
	 * @param temp
	 * @param length
	 */
	private static void toBool(String temp, int length) {
		length = length-temp.length();
		//System.out.println(length);
		char[] zeros = new char[length];
		Arrays.fill(zeros, '0');
		//System.out.println(Arrays.toString(zeros));

		temp = (Arrays.toString(zeros)).concat(temp);
		
		char[] bool = temp.toCharArray();
		for (char i : bool) {
			if (i=='1') System.out.print("True\t");
			else if (i=='0') System.out.print("False\t");
		}
	}
	
	/**
	 * 
	 * @param input
	 * @param num
	 * @return index of matching parentheses
	 */
	private static int findMatch(String input, int num) {
		int paren = 0;
		boolean foundStart = false;
		
		for (int i = 0; i<input.length(); i++) {
			if (input.charAt(i)=='(') {
				paren++;
				foundStart = true;
			}
			if (input.charAt(i)==')') {
				paren--;
			}
			if ((foundStart)&&(paren==0)) return i;
		}
		
		return -1;
		
		
	}

	/**
	 * Checks whether an input string is a valid logical sentence or not. 
	 * @param String input
	 * @return if the string is a valid logical sentence returns true; if not, returns false.
	 */
	public static boolean legal(String input){

		if (simpleSentence(input)) return true; //checks if the sentence contains a propositional constant
		if(input.startsWith("~")) return legal(input.substring(1));//checks if the string is a negation
		if((startsWithSS(input)) && (logicalOp(input.substring(1)))) return legal(input.substring(2)); //Checks if the sentence has a logical operator
		else return false;
	}
	
	/**
	 * Checks if the input starts with a logical operator.
	 * @param String input
	 * @return if the input starts with a logical operator, returns true; if not, returns false.
	 */
	public static boolean logicalOp (String input){
		if ((input.startsWith("&"))||(input.startsWith("|"))||(input.startsWith("~"))||(input.startsWith("=>"))||(input.startsWith("<=>"))) return true;
		else return false;
	}
	
	/**
	 * Checks if the input is a simple sentence.
	 * @param String input
	 * @return if the input is a simple sentence(P or Q), return true; if not, return false.
	 */
	public static boolean simpleSentence (String input){
		if((input.equals("P"))||(input.equals("Q"))) return true;
		else return false;
	}

	/**
	 * Checks if the input starts with a simple sentence.
	 * @param String input
	 * @return if the input starts with a simple sentence(P or Q), return true; if not, return false.
	 */
	public static boolean startsWithSS (String input){
		if((input.startsWith("P"))||(input.startsWith("Q"))) return true;
		else return false;
	}

	public boolean evaluate() {
		return PC.truthValue;
		
	}

}
