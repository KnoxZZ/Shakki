package nappulat;

import game.MainGame;
import utils.*;

public class Lahetti extends Nappula {
	public Lahetti(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(3);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if(Math.abs(sx-ex)==Math.abs(sy-ey)) {
        	if(!nappulanYli(startPos, endPos)) {
        		return true;
        	}
        }
		return false;
	}
	
	public boolean nappulanYli(Position startPos, Position endPos) {
		Lauta lauta = MainGame.getLauta();
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        int px = 0;
        int py = 0;
        int sux = 0;
        int suy = 0;

		if(sx>ex&&sy>ey) {
			px=ex;
			sux=sx;
			py=ey;
			suy=sy;
		}
		else if(sx>ex&&sy<ey) {
			px=ex;
			sux=sx;
			py=sy;
			suy=ey;
		}
		else if(sx<ex&&sy>ey) {
			px=sx;
			sux=ex;
			py=ey;
			suy=sy;
		}
		else if(sx<ex&&sy<ey) {
			px=sx;
			sux=ex;
			py=sy;
			suy=ey;
		}
		for(int i = 0; i < px-sux; i++) {
			if(lauta.getPosition(px+i, py+i).hasNappula()) {
				return true;
			}
		}
		return false;
	}
	
	public String name() {
		return "Lahetti";
	}
}
