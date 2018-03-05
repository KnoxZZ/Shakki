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
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
        	return true;
        }
		return false;
	}
	
	public String name() {
		return "Torni";
	}
}
