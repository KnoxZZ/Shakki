package nappulat;

import java.io.Serializable;

import game.MainGame;
import utils.*;

abstract public class Nappula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// hankkitaan oikeat merkit OsCheck luokan avulla
	String[] codes = OsCheck.getChars();
	//final String[] codes = {"♔","♕","♖","♗","♘","♙","♚","♛","♜","♝","♞","♟"};
	boolean vari;	// vari true == valkoinen, vari false == musta
	
	// konstruktori Nappulaolioille
	public Nappula(boolean vari) {
		this.vari = vari;
	}
	
	//abstarkti metodi jolla tarkistetaan onko siirto sallittu
	abstract public boolean isLegit(Position startPos, Position endPos, MainGame game);
	// Abstrakti metodi joka palauttaa nappulan nimen
	abstract public String name();
	
	//apumetodi Nappula luokan alaluokkien toString:eille
	public String toStringWithNappula(int nappula) {
		if(vari)
			return codes[nappula];
		else
			return codes[nappula+6];
	}
	
	//Asetus- ja havainnointimetodit
	public boolean isVari() {
		return vari;
	}

	public void setVari(boolean vari) {
		this.vari = vari;
	}
}
