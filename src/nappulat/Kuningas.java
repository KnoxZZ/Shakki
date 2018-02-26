package nappulat;

import utils.Position;

public class Kuningas extends Nappula {
	public Kuningas(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(1);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		// TODO Auto-generated method stub
		return true;
	}
}
