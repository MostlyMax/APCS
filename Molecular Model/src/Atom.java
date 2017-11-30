import java.util.ArrayList;

public class Atom {
	
	Element element;

	int bondNum;
	
	ArrayList<Electron> electrons = new ArrayList<>();
	
	public Atom(Element element) {
		this.element = element;
	}
	
	public void printAtom() {
		System.out.print(element.symbol+":");
		System.out.print(electrons.size()+",");
		System.out.println(bondNum);
//		for (Electron temp : electrons) {
//			System.out.print(temp.bond +" ");
//		}
		
	}

}
