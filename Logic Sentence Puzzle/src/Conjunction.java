
public class Conjunction extends LogicalSentence {
	LogicalSentence left, right;

	public Conjunction(LogicalSentence left, LogicalSentence right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean evaluate() {
		return (left.evaluate())&&(right.evaluate());
		
	}
}
