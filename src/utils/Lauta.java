package utils;

public class Lauta {
	Position[][] pelilauta;
	public Lauta() {
		 pelilauta = new Position[8][8];
		 for(int i = 1; i <= pelilauta.length; i++) {
			 for(int o = 1; o <= pelilauta[i].length; o++) {
				 pelilauta[i][o].setY(o);
				 pelilauta[i][o].setX(i);
			 }
		 }
	}
	
	public Position[][] getPelilauta() {
		return pelilauta;
	}
	
	public void setPelilauta(Position[][] pelilauta) {
		this.pelilauta = pelilauta;
	}
}