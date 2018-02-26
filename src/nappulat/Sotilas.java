package nappulat;

import utils.Position;

public class Sotilas extends Nappula {
	boolean ekaAskel;	//true ennen kuin eka askel on otettu
	public Sotilas(boolean vari) {
		super(vari);
		ekaAskel = true;
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(5);
	}
	
	public boolean isEkaAskel() {
		return ekaAskel;
	}

	public void setEkaAskel(boolean ekaAskel) {
		this.ekaAskel = ekaAskel;
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		return true;
	}
	
}
