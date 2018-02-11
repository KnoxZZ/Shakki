package utils;

public class Lauta {
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	Position[][] pelilauta;
	public Lauta() {
		 pelilauta = new Position[8][8];
		 for(int i = 0; i < pelilauta.length; i++) {
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 pelilauta[i][o].setY(o);
				 pelilauta[i][o].setX(i);
			 }
		 }
	}
	
	public Position[][] getPelilauta() {
		return pelilauta;
	}
	
	public Position getPosition(int x, int y) {
		return pelilauta[x][y];
	}
	
	public void setPelilauta(Position[][] pelilauta) {
		this.pelilauta = pelilauta;
	}
	
	public boolean legitMove(int x, int y) {
		return x <= 7 && y <= 7 ? true : false;
	}
	
	public boolean legitMove(String x, int y) {
		int tempX = 0;
		for (int i = 0; i < characters.length; i++) {
			if(("" + characters[i]).toLowerCase().equals(x.toLowerCase())){
				tempX = i;
			}
		}
		return legitMove(tempX, y-1);
	}
}