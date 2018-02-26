package nappulat;

import utils.Position;

public class Kuningatar extends Nappula {
	public Kuningatar(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(0);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		// TODO Auto-generated method stub
		return true;
	}
}
