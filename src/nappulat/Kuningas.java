package nappulat;

import game.MainGame;
import utils.Position;

public class Kuningas extends Nappula {
	// Kuningkaan konstruktori
	public Kuningas(boolean vari) {
		super(vari);
	}
	
	// toString metodi joka kayttaa Nappula luokan toStringWithNappulaa apuna merkin maarittamisessa
	@Override
	public String toString() {
		return super.toStringWithNappula(1);
	}
	
	//Metodi joka tarkistaa onko siirto laillinen
	@Override
	public boolean isLegit(Position startPos, Position endPos, MainGame game) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if(Math.abs(sx-ex) <= 1 && Math.abs(sy-ey) <= 1) {
        	return true;
        }
		return false;
	}
	
	//Palauttaa Nappulan nimen
	public String name() {
		return "Kuningas";
	}
}
