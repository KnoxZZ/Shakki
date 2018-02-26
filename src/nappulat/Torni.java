package nappulat;

import utils.Position;

public class Torni extends Nappula{
	public Torni(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(2);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		// TODO Auto-generated method stub
		return true;
	}
}
