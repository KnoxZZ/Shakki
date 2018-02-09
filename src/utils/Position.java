package utils;

public class Position {
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	int x;
	int y;
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return characters[x-1] + "" + y;
	}
}
