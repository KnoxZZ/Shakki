package utils;

import java.io.Serializable;

import nappulat.*;

public class Lauta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	Position[][] pelilauta;
	
	// Pelilaudan konsturktori
	public Lauta() {
		 pelilauta = new Position[8][8];
		 for(int i = 0; i < pelilauta.length; i++) {
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 Position temp = new Position(i, o, false);
				 pelilauta[i][o] = temp;
			 }
		 }
	}
	
	//metodi joka "poistaa" nappulan koordinaateista
	public void delNappula(int x, int y) {
		this.setHasNappula(x, y, false);
	}
	
	//Metodi joka tarkistaa onko liike laudan sisällä
	public boolean legitMove(int x, int y) {
		return x <= 7 && y <= 7 ? true : false;
	}
	
	//Overloadattu metodi joka tarkistaa onko erilaisella syotteella olevat koordinaatit
	public boolean legitMove(String x, int y) {
		int tempX = 0;
		for (int i = 0; i < characters.length; i++) {
			if(("" + characters[i]).toLowerCase().equals(x.toLowerCase())){
				tempX = i;
			}
		}
		return legitMove(tempX, y-1);
	}
	
	// Alustaa laudan eli lisää oikeisiin paikkoihin oikeat nappulat
	public void startPos()
	{
		for(int x = 0; x < 8; x++) {
			this.setNappula(x, 1, new Sotilas(false));
			this.setNappula(x, 6, new Sotilas(true));
			switch(x) {
			case 0:
			case 7:	
				this.setNappula(x, 0, new Torni(false));
				this.setNappula(x, 7, new Torni(true));
				break;
			case 1:
			case 6:
				this.setNappula(x, 0, new Hevonen(false));
				this.setNappula(x, 7, new Hevonen(true));
				break;
			case 2:
			case 5:
				this.setNappula(x, 0, new Lahetti(false));
				this.setNappula(x, 7, new Lahetti(true));
				break;
			case 3:
				this.setNappula(x, 0, new Kuningas(false));
				this.setNappula(x, 7, new Kuningas(true));
				break;
			case 4:
				this.setNappula(x, 0, new Kuningatar(false));
				this.setNappula(x, 7, new Kuningatar(true));
				break;
			}
		}
	}
	
	
	//tasta alaspain on vain asetus- ja havainnointimetodeita seka yksi toString metodi
	public Position[][] getPelilauta() {
		return pelilauta;
	}
	
	public Position getPosition(int x, int y) {
		return pelilauta[x][y];
	}
	
	public void setPosition(int x, int y, Position pos) {
		pelilauta[x][y] = pos;
	}
	
	public void setNappula(int x, int y, Nappula nap) {
		pelilauta[x][y].setNappula(nap);
		pelilauta[x][y].setHasNappula(true);
	}
	
	public void setHasNappula(int x, int y, boolean bool) {
		pelilauta[x][y].setHasNappula(bool);
	}
	
	public void setPelilauta(Position[][] pelilauta) {
		this.pelilauta = pelilauta;
	}
	
	@Override
	public String toString() {
		StringBuilder ready = new StringBuilder();
		ready.append("   A  B  C  D  E  F  G  H\n  ┌──┬──┬──┬──┬──┬──┬──┬──┐\n");
		
		for(int y = 0; y < pelilauta.length ; y++) {
			ready.append(y+1 + " │");
			for(int x = 0; x < pelilauta[y].length; x++) {
				ready.append(pelilauta[x][y].toString() + "│");
			}
			ready.append(" " + (y+1));
			if (y != 7) {
				ready.append("\n  ├──┼──┼──┼──┼──┼──┼──┼──┤\n");
			}
			else {
				ready.append("\n  └──┴──┴──┴──┴──┴──┴──┴──┘\n   A  B  C  D  E  F  G  H\n");
			}
		 }
		return ready.toString();
	}
}