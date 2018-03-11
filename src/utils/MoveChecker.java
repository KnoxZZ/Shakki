package utils;

import game.MainGame;
import nappulat.Nappula;

public class MoveChecker {
	
	public boolean isValid(Position start, Position end, Lauta pelilauta, boolean turn, MainGame game) throws MoveException {
		
		if(!pelilauta.legitMove(start.getX(), start.getY()) || !pelilauta.legitMove(end.getX(), end.getY())) {
			throw(new MoveException("Move outside the board"));
		}
		
		if(!start.hasNappula()) {
			throw(new MoveException("No pieces in that position"));
		}
		
		Nappula toMove = start.getNappula();
		
		if(turn != toMove.isVari()) {
			throw(new MoveException("Not your piece"));
		}
		
		if(!toMove.isLegit(start, end, game)) {
			throw(new MoveException("Illegal move for that piece"));
		}
		
		
		if(!end.hasNappula()) {
			return true;
		} else if (end.hasNappula() && end.getNappula().isVari() == toMove.isVari()) {
			throw(new MoveException("Can't eat your own piece"));
		} else if (end.hasNappula() && end.getNappula().isVari() != toMove.isVari()) {
			return true;
		}
		
		return true;
	}

}
