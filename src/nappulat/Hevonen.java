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
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        
        if((sx-1==ex || sx +1 == ex) && (sy + 2 == ey || sy - 2 == ey)) {
        	return true;
        }else if((sy-1==ey || sy +1 == ey) && (sx + 2 == ex || sx - 2 == ex)) {
        	return true;
        }
        
        return false;
	}
}
