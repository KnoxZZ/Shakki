package nappulat;

import game.MainGame;
import utils.*;

public class Lahetti extends Nappula {
	//Lahetin konstruktori
	public Lahetti(boolean vari) {
		super(vari);
	}
	
	// toString metodi joka kayttaa Nappula luokan toStringWithNappulaa apuna merkin maarittamisessa
	@Override
	public String toString() {
		return super.toStringWithNappula(3);
	}

	//Metodi joka tarkistaa onko siirto laillinen
	@Override
	public boolean isLegit(Position startPos, Position endPos, MainGame game) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if(Math.abs(sx-ex)==Math.abs(sy-ey)) {
        	if(!nappulanYli(startPos, endPos, game)) {
        		return true;
        	}
        }
		return false;
	}
	
	//Metodi joka tarkistaa hyppaako nappula jonkun muun nappulan yli
	public boolean nappulanYli(Position startPos, Position endPos, MainGame game) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
		if(sx < ex && sy < ey) {
			int x = sx;
			int y = sy;
			while(sx < ex - 1 && y < ey - 1) {
				x++;
				y++;
				if (game.getLauta().getPosition(x, y).hasNappula()) {
					return true;
				}
			}
		}
		else if(sx < ex && sy > ey) {
			int x = sx;
			int y = sy;
			while(x < ex - 1 && y > ey + 1) {
				x++;
				y--;
				if (game.getLauta().getPosition(x, y).hasNappula()) {
					return true;
				}
			}
		}
		else if(sx > ex && sy < ey) {
			int x = sx;
			int y = sy;
			while(x > ex + 1 && y < ey - 1) {
				x--;
				y++;
				if (game.getLauta().getPosition(x, y).hasNappula()) {
					return true;
				}
			}
		}
		else if(sx > ex && sy > ey) {
			int x = sx;
			int y = sy;
			while(sx > ex + 1 && y > ey + 1) {
				x--;
				y--;
				if (game.getLauta().getPosition(x, y).hasNappula()) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Palauttaa Nappulan nimen
	public String name() {
		return "Lahetti";
	}
}
