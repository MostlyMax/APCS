import java.util.ArrayList;

public class Molecule {

	ArrayList<Atom> molecule = new ArrayList<>();
	ArrayList<Bond> bonds = new ArrayList<>();
	Atom central;
	int startCharge=0;
	
	int totalElectrons;
	
	public Molecule() {
		
	}
	
	public void addAtom(Atom add) {
		this.molecule.add(add);
	}
	
	public void bind(Atom temp, Atom temp2) {
		
		bonds.add(new Bond(temp, temp2));
		temp.bondNum++;
		temp2.bondNum++;
		
		if(temp.electrons.size()>=2) {temp.electrons.remove(0); temp.electrons.remove(0);}
		else if(temp.electrons.size()<=0) {
			System.out.println("Ruh Roh");
			System.exit(-1);
		}
		if(temp2.electrons.size()>=2) {temp2.electrons.remove(0); temp2.electrons.remove(0);}
		else if(temp2.electrons.size()<=0) {
			System.out.println("Ruh Roh");
			System.exit(-1);
		}
		
//		for (Electron bind : temp.electrons) {
//			if (!bind.bond) {
//				for (Electron bind2 : temp2.electrons) {
//					if (!bind2.bond) {
//						bonds.add(new Bond())
//					}
//				}
//			}
//		}
			
	}
	
	public int countElectrons() {
		int retVal = 0;
		
		for (Atom temp : molecule) {
			retVal+=temp.electrons.size();
			retVal+=temp.bondNum;
		}
		totalElectrons = retVal;
		return retVal;
	}
	
	public void printMolecule() {
		//System.out.println("total electrons:"+totalElectrons);
		for (Atom temp : molecule) {
			temp.printAtom();
		}
	}
	
	public void printMoleculeBetter() {
		for (Atom temp : molecule) {
			System.out.print(temp.element.symbol);
		}
	}

	public Atom getBondable() {
		Atom retVal;
		
		retVal=central;
		
		for (Atom temp : molecule) {
			if (temp != central) {
				if (temp.bondNum<=retVal.bondNum) {
					retVal=temp;
					
				}
			}
			
		}
	
		return retVal;
	}
	
	public Atom getCentral() {
		Atom retVal = molecule.get(0);
		
		for (Atom temp : molecule) {
			if (temp.element.electroNeg<retVal.element.electroNeg) retVal = temp;
		}
		
		return retVal;
	}
	
}
