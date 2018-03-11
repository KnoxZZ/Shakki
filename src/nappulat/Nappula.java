package nappulat;

import java.io.Serializable;

import game.MainGame;
import utils.*;

abstract public class Nappula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String[] codes = OsCheck.getChars();
	//final String[] codes = {"♔","♕","♖","♗","♘","♙","♚","♛","♜","♝","♞","♟"};
	boolean vari;	// vari true == valkoinen, vari false == musta
	public Nappula(boolean vari) {
		this.vari = vari;
	}
	
	abstract public boolean isLegit(Position startPos, Position endPos, MainGame game);
	abstract public String name();
	
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
