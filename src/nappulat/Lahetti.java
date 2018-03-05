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
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if((Math.abs(sx)-Math.abs(ex)==Math.abs(sy)-Math.abs(ey))) {
        	return true;
        }
		return false;
	}
	
	public String name() {
		return "Lahetti";
	}
}
