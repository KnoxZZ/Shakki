package nappulat;

import game.MainGame;
import utils.Position;

public class Torni extends Nappula{
	public Torni(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(2);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
        if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
        	if(!nappulanYli(startPos, endPos)) {
        		return true;
        	}
        }
		return false;
	}
	
	public boolean nappulanYli(Position startPos, Position endPos) {
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
        if(sx==ex) {
        	for(int i = py+1; i < suy; i++) {
        		if(MainGame.getLauta().getPosition(sx, i).hasNappula()) {
        			return true;
        		}
        	}
        }
        else {
        	for(int i = px+1; i < sux; i++) {
        		if(MainGame.getLauta().getPosition(sy, i).hasNappula()) {
        			return true;
        		}
        	}
        }
        return false;
	}
	
	public String name() {
		return "Torni";
	}
}
