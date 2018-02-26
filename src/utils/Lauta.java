package utils;

import nappulat.*;

public class Lauta {
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	Position[][] pelilauta;
	public Lauta() {
		 pelilauta = new Position[8][8];
		 for(int i = 0; i < pelilauta.length; i++) {
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 Position temp = new Position(i, o, false);
				 pelilauta[i][o] = temp;
			 }
		 }
	}
	
	public void startPos()
	{
		for(int i = 0; i < 8; i++) {
			this.setNappula(6, i, new Sotilas(true));
			this.setNappula(1, i, new Sotilas(false));
			switch(i) {
			case 0:
			case 7:	
				this.setNappula(0, i, new Torni(true));
				this.setNappula(7, i, new Torni(false));
				break;
			case 1:
			case 6:
				this.setNappula(0, i, new Hevonen(true));
				this.setNappula(7, i, new Hevonen(false));
				break;
			case 2:
			case 5:
				this.setNappula(0, i, new Lahetti(true));
				this.setNappula(7, i, new Lahetti(false));
				break;
			case 3:
				this.setNappula(0, i, new Kuningas(true));
				this.setNappula(7, i, new Kuningas(false));
				break;
			case 4:
				this.setNappula(0, i, new Kuningatar(true));
				this.setNappula(7, i, new Kuningatar(false));
				break;
			}
		}
	}
	
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
	
	public void setPelilauta(Position[][] pelilauta) {
		this.pelilauta = pelilauta;
	}
	
	public boolean legitMove(int x, int y) {
		return x <= 7 && y <= 7 ? true : false;
	}
	
	public boolean legitMove(String x, int y) {
		int tempX = 0;
		for (int i = 0; i < characters.length; i++) {
			if(("" + characters[i]).toLowerCase().equals(x.toLowerCase())){
				tempX = i;
			}
		}
		return legitMove(tempX, y-1);
	}
	
	@Override
	public String toString() {
		StringBuilder ready = new StringBuilder();
		ready.append("   1  2  3  4  5  6  7  8\n  ┌──┬──┬──┬──┬──┬──┬──┬──┐\n");
		
		for(int i = 0; i < pelilauta.length; i++) {
			ready.append(characters[i] + " │");
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 ready.append(pelilauta[i][o].toString() + "│");
			 }
			 if (i != 7)
				 ready.append("\n  ├──┼──┼──┼──┼──┼──┼──┼──┤\n");
			 else
				 ready.append("\n  └──┴──┴──┴──┴──┴──┴──┴──┘\n");
		 }
		return ready.toString();
	}
}