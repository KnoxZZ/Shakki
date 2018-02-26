package nappulat;

import utils.Position;

public class Lahetti extends Nappula {
	public Lahetti(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(3);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		// TODO Auto-generated method stub
		return true;
	}
}
