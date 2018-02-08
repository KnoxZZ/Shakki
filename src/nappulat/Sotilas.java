package nappulat;

public class Sotilas extends Nappula {
	boolean ekaAskel = true;	//true ennen kuin eka askel on otettu
	public Sotilas(boolean vari, String sijainti) {
		super(vari, sijainti);
	}
	
	@Override
	public String toString() {
		String tempvari = vari?"Valkoinen":"Musta";
		String tempEkaAskel = ekaAskel?"On":"Ei";
		return "Väri: " + tempvari + ", Sijainti: " + sijainti + ", Liikutettu: " + tempEkaAskel;
	}
}
