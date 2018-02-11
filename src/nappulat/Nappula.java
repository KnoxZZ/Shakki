package nappulat;

import utils.Position;

public class Nappula {
	final String[] codes = {"♔ ","♕ ","♖ ","♗ ","♘ ","♙ ","♚ ","♛ ","♜ ","♝ ","♞ ","♟ "};
	boolean vari;	// vari true == valkoinen, vari false == musta
	public Nappula(boolean vari) {
		this.vari = vari;
	}
	
	public boolean isLegit(Position startPos, Position endPos) {
		if(endPos.hasNappula() && endPos.getNappula().isVari() != startPos.getNappula().isVari()) { return true;}
		else if(!endPos.hasNappula()) { return true;}
		else { return false;}
	}
	
	public String toStringWithNappula(int nappula) {
		if(vari)
			return codes[nappula];
		else
			return codes[nappula+6];
	}

	public boolean isVari() {
		return vari;
	}

	public void setVari(boolean vari) {
		this.vari = vari;
	}
}
