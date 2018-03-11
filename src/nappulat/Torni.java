package nappulat;

import game.MainGame;
import utils.Position;

public class Torni extends Nappula{
	
	// Tornin konsturktori
	public Torni(boolean vari) {
		super(vari);
	}
	
	// toString metodi joka kayttaa Nappula luokan toStringWithNappulaa apuna merkin maarittamisessa
	@Override
	public String toString() {
		return super.toStringWithNappula(2);
	}
	
	//Metodi joka tarkistaa onko siirto laillinen
	@Override
	public boolean isLegit(Position startPos, Position endPos, MainGame game) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
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
	
//	public boolean nappulanYli(Position startPos, Position endPos) {
//		  int sx = startPos.getX();
//        int sy = startPos.getY();
//        int ex = endPos.getX();
//        int ey = endPos.getY();
//        int px = 0;
//        int py = 0;
//        int sux = 0;
//        int suy = 0;
//
//		if(sx>ex&&sy>ey) {
//			px=ex;
//			sux=sx;
//			py=ey;
//			suy=sy;
//		}
//		else if(sx>ex&&sy<ey) {
//			px=ex;
//			sux=sx;
//			py=sy;
//			suy=ey;
//		}
//		else if(sx<ex&&sy>ey) {
//			px=sx;
//			sux=ex;
//			py=ey;
//			suy=sy;
//		}
//		else if(sx<ex&&sy<ey) {
//			px=sx;
//			sux=ex;
//			py=sy;
//			suy=ey;
//		}
//        if(sx==ex) {
//        	for(int i = py+1; i < suy; i++) {
//        		if(MainGame.getLauta().getPosition(sx, i).hasNappula()) {
//        			return true;
//        		}
//        	}
//        }
//        else {
//        	for(int i = px+1; i < sux; i++) {
//        		if(MainGame.getLauta().getPosition(sy, i).hasNappula()) {
//        			return true;
//        		}
//        	}
//        }
//        return false;
//	}
	
	//Palauttaa Nappulan nimen
	public String name() {
		return "Torni";
	}
}
