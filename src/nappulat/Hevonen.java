package nappulat;

import utils.Position;

public class Hevonen extends Nappula {
	public Hevonen(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(4);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		// TODO Auto-generated method stub
		return true;
	}
}
