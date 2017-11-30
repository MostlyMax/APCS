
public class Structure {
	
	public static void bindAll(Molecule test) {
		for (Atom temp : test.molecule) {
			if (temp != test.central) {
				System.out.print("bindAll: "+ test.central.element.symbol + " to "+ temp.element.symbol);
				test.bind(test.central, temp);
				System.out.println();
			}
		}
		
		System.out.println("After binding:");
		test.printMolecule();
		
	}
	
	public static void fillValence(Molecule test) {
		
		for (Atom temp : test.molecule) {
			for (int i=0; i<temp.element.octet-temp.bondNum*2; i++) {
				temp.electrons.add(new Electron(temp));
			}
		}
		
		System.out.println("After filling:");
		test.printMolecule();
		
	}
	
	public static void makeLewis(Molecule test) {
		int specialNum = 0, fanBreak = 0;
		System.out.print("Creating lewis structure for:");
		test.printMoleculeBetter();
		System.out.println();
		
		for (Atom temp : test.molecule) specialNum+=temp.element.valenceNum;
		
		fillValence(test);
		bindAll(test);
		
		test.countElectrons();
		System.out.println("Starting Electrons:"+test.totalElectrons+":"+specialNum);
		
		while(test.totalElectrons!=specialNum+(-1*test.startCharge)) {
			if (fanBreak==1000) {
				System.out.println("S**t hit the fan");
				System.exit(-1);
			}
			fanBreak++;
			
			if (test.totalElectrons>specialNum) {
				System.out.println("Binding "+ test.central.element.symbol + " to "+ test.getBondable().element.symbol);
				test.bind(test.central, test.getBondable());
				
			}
			
			test.countElectrons();
			
		}
		System.out.println("********************************");
		System.out.println("Complete:");
		
	}

	
}

/*
1. find least electro negative Atom - not hydrogen
2. surround with second least electro negative
3.
*/


