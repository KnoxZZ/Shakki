package nappulat;

import game.MainGame;
import utils.Lauta;
import utils.Position;

public class Kuningatar extends Nappula {
	public Kuningatar(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(0);
	}

	@Override
	public boolean isLegit(Position startPos, Position endPos, MainGame game) {
		int sx = startPos.getX();
        int sy = startPos.getY();
        int ex = endPos.getX();
        int ey = endPos.getY();
		if(Math.abs(sx-ex)==Math.abs(sy-ey)) {
//			if(!nappulanYli(startPos, endPos)) {
//				return true;
//			}
			return true;
		} else if((sx==ex||sy==ey)&&!(sx==ex&&sy==ey)) {
//        	if(!nappulanYli(startPos, endPos)) {
//        		return true;
//        	}
			return true;
        }
		return false;
	}
	
//	public boolean nappulanYli(Position startPos, Position endPos) {
//		Lauta lauta = MainGame.getLauta();
//		int sx = startPos.getX();
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
//		for(int i = px; i <= sux; i++) {
//			for(int j = py; j <= suy; j++) {
//				if(lauta.getPosition(i, j).hasNappula()) {
//					return true;
//				}
//			}
//		}
//		if(sx==ex) {
//        	for(int i = sy; i < ey; i++) {
//        		if(MainGame.getLauta().getPosition(sx, i).hasNappula()) {
//        			return true;
//        		}
//        	}
//        }
//        else {
//        	for(int i = sx; i < ex; i++) {
//        		if(MainGame.getLauta().getPosition(sy, i).hasNappula()) {
//        			return true;
//        		}
//        	}
//        }
//		return false;
//	}
	
	public String name() {
		return "Kuningatar";
	}
}
