import java.util.Hashtable;

public class TruthAssignment {

	public void put(PropositionConstant c, boolean value) {
		c.truthValue = value;
		//Hashtable<String, Boolean> truthTable = new Hashtable<String, Boolean>();
	}
	
	public boolean get(PropositionConstant c) {
		return c.truthValue;
	}
}
