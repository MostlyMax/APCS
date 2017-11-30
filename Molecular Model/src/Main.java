
public class Main {
	
	static int allElectrons = 0;

	public static void main(String[] args) {
		Molecule test = new Molecule();
		Element carbon = new Element("C", 6, 4, 2.55, 8);
		Element carbon1 = new Element("C1", 6, 4, 2.55, 8);
		Element oxygen = new Element("O", 8, 6, 3.44, 8);
		Element hydrogen = new Element("H", 1, 1, 10.00, 2);
		
		//CO2 test
		test.addAtom(new Atom(carbon));
		test.addAtom(new Atom(oxygen));
		test.addAtom(new Atom(oxygen));
		test.central = test.getCentral();
		
		Structure.makeLewis(test);
		test.printMolecule();
		
		clearMolecule(test);
		
		System.out.println("------------------------");
		
		//H2O test
		test.addAtom(new Atom(oxygen));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.central = test.getCentral();
		
		Structure.makeLewis(test);
		test.printMolecule();
		
		clearMolecule(test);
		
		System.out.println("------------------------");
		
		//O2 test
		test.addAtom(new Atom(oxygen));
		test.addAtom(new Atom(oxygen));
		test.central = test.getCentral();
		
		Structure.makeLewis(test);
		test.printMolecule();
		
		clearMolecule(test);
		
		System.out.println("------------------------");
		
		//C2H6 test
		test.addAtom(new Atom(carbon));
		test.addAtom(new Atom(carbon1));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.addAtom(new Atom(hydrogen));
		test.central = test.getCentral();
		
		
		Structure.makeLewis(test);
		test.printMolecule();
		
		clearMolecule(test);
		
		System.out.println("------------------------");
		
		//CO3 test
		test.addAtom(new Atom(carbon));
		test.addAtom(new Atom(oxygen));
		test.addAtom(new Atom(oxygen));
		test.addAtom(new Atom(oxygen));
		test.central = test.getCentral();
		test.startCharge=-2;
		
		Structure.makeLewis(test);
		test.printMolecule();
		
		clearMolecule(test);
		
		System.out.println("------------------------");

	}
	
	public static void clearMolecule(Molecule clear) {
		for (Atom temp : clear.molecule) {
			temp.electrons.clear();
			temp.bondNum = 0;
		}
		clear.molecule.clear();
		clear.bonds.clear();
	}

}
