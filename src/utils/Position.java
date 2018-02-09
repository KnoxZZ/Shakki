package utils;

public class Position {
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	int x;
	int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return characters[x-1] + "" + y;
	}
}
