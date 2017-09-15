
public class Negation extends LogicalSentence{
	LogicalSentence l;
	
	public Negation(LogicalSentence l) {
		this.l = l;
	}
	
	public boolean evaluate() {
		return !(l.evaluate());
	}


}
