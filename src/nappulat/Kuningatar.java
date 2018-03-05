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
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
		if((Math.abs(sx)-Math.abs(ex)==Math.abs(sy)-Math.abs(ey))) {
			if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
				return true;
			}
		}
		return false;
	}
	
	public String name() {
		return "Kuningatar";
	}
}
