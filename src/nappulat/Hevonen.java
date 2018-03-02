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
        
        if(Math.abs(sx-ex) == 1 && Math.abs(sy-ey) == 2) {
        	return true;
        }
        else if(Math.abs(sy-ey) == 1 && Math.abs(sx-ex) == 2) {
        	return true;
        }
        
        /*
        int asx = Math.abs(sx-ex);
        int asy = Math.abs(sy-ey);
        if(asx <= 2 && asy <= 2 && Math.abs(asx + asy) == 3) {
        	return true;
        }
        */
        
        return false;
	}
}
