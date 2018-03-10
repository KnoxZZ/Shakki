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
        if(sx==ex) {
        	for(int i = sy; i < ey; i++) {
        		if(MainGame.getLauta().getPosition(sx, i).hasNappula()) {
        			return true;
        		}
        	}
        }
        else {
        	for(int i = sx; i < ex; i++) {
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
