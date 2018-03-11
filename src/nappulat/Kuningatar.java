package nappulat;

import game.MainGame;
import utils.Lauta;
import utils.Position;

public class Kuningatar extends Nappula {
	//Kuningattaren konstruktori
	public Kuningatar(boolean vari) {
		super(vari);
	}
	
	// toString metodi joka kayttaa Nappula luokan toStringWithNappulaa apuna merkin maarittamisessa
	@Override
	public String toString() {
		return super.toStringWithNappula(0);
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
			return true;
		} else if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
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
		
		if(sx==ex) {
			if(sy-ey<0) {
				for(int i = sy+1; i < ey; i++) {
					if(game.getLauta().getPosition(sx, i).hasNappula()) {
						return true;
					}
				}
			}
			else {
				for(int i = ey+1; i < sy; i++) {
					if(game.getLauta().getPosition(sx, i).hasNappula()) {
						return true;
					}
				}
			}
		}
		else if(sy==ey) {
			if(sx-ex<0) {
				for(int i = sx+1; i < ex; i++) {
					if(game.getLauta().getPosition(i, sy).hasNappula()) {
						return true;
					}
				}
			}
			else {
				for(int i = ex+1; i < sx; i++) {
					if(game.getLauta().getPosition(i, sy).hasNappula()) {
						return true;
					}
				}
			}
		}
		else {
			return false;
		}
		return false;
	}
	
	//Palauttaa Nappulan nimen
	public String name() {
		return "Kuningatar";
	}
}
