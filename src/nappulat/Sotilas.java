package nappulat;

public class Sotilas extends Nappula {
	boolean ekaAskel;	//true ennen kuin eka askel on otettu
	public Sotilas(boolean vari, String sijainti) {
		super(vari, sijainti);
		ekaAskel = true;
	}
	
	@Override
	public String toString() {
		String tempvari = vari?"Valkoinen":"Musta";
		String tempEkaAskel = ekaAskel?"On":"Ei";
		return "Väri: " + tempvari + ", Sijainti: " + sijainti + ", Liikutettu: " + tempEkaAskel;
	}

	public boolean isEkaAskel() {
		return ekaAskel;
	}

	public void setEkaAskel(boolean ekaAskel) {
		this.ekaAskel = ekaAskel;
	}
	
}
