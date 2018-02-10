package nappulat;

import utils.Position;

public class Nappula {
	boolean vari;	// vari true == valkoinen, vari false == musta
	public Nappula(boolean vari) {
		this.vari = vari;
	}
	
	public boolean isLegit(Position startPos, Position endPos) {
		if(endPos.isHasNappula() && endPos.getNappula().isVari() != startPos.getNappula().isVari()) { return true;}
		else if(!endPos.isHasNappula()) { return true;}
		else { return false;}
	}
	
	@Override
	public String toString() {
		String tempvari = vari?"Valkoinen":"Musta";
		return "Vari: "+tempvari;
	}

	public boolean isVari() {
		return vari;
	}

	public void setVari(boolean vari) {
		this.vari = vari;
	}
}
