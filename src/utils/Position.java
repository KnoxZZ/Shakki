package utils;

import java.io.Serializable;

import nappulat.Nappula;

public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	Nappula nappula;
	boolean hasNappula;
	int x;
	int y;
	
	//Konstruktori Position olioille
	public Position(int x, int y, boolean hasNappula) {
		this.x = x;
		this.y = y;
		this.hasNappula = hasNappula;
	}
	
	//toString metodi joka tulostaa oikean merkin oikeaa nappulaa kohtaan
	@Override
	public String toString() {
		if(hasNappula)
			return nappula.toString();
		else
			return "  ";
	}
	
	//Asetus- ja havainnointimetodeita
	
	public boolean hasNappula() {
		return hasNappula;
	}

	public void setHasNappula(boolean hasNappula) {
		this.hasNappula = hasNappula;
	}

	public Nappula getNappula() {
		return nappula;
	}

	public void setNappula(Nappula nappula) {
		this.nappula = nappula;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
