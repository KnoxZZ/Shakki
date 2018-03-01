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
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if(Math.abs(sx-ex) <= 1 && Math.abs(sy-ey) <= 1) {
        	return true;
        }
		return false;
	}
}
