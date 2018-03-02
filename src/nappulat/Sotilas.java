package nappulat;

import utils.Position;

public class Sotilas extends Nappula {
	boolean ekaAskel;	//true ennen kuin eka askel on otettu
	public Sotilas(boolean vari) {
		super(vari);
		ekaAskel = true;
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(5);
	}
	
	public boolean isEkaAskel() {
		return ekaAskel;
	}

	public void setEkaAskel(boolean ekaAskel) {
		this.ekaAskel = ekaAskel;
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
        int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        System.out.println(sx +"][" + sy + "][" + ex + "][" + ey);
        if(Math.abs(sy-ey)==1) {
            if(sx == ex && !endPos.hasNappula()){
                return true;
            } else if ((sx == ex+1 || sx == ex-1) &&
                        endPos.hasNappula() &&
                        endPos.getNappula().isVari() != this.isVari()) {
                return true;
            }
        } else if(Math.abs(sy-ey)==2 &&    sx == ex &&    !endPos.hasNappula() && this.isEkaAskel()) {
            return true;
        }
        return false;
    }
}
