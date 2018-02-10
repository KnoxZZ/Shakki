package nappulat;

public class Sotilas extends Nappula {
	boolean ekaAskel;	//true ennen kuin eka askel on otettu
	public Sotilas(boolean vari) {
		super(vari);
		ekaAskel = true;
	}
	
	@Override
	public String toString() {
		String tempvari = vari?"Valkoinen":"Musta";
		String tempEkaAskel = ekaAskel?"On":"Ei";
		return "Vari: " + tempvari + ", Liikutettu: " + tempEkaAskel;
	}

	public boolean isEkaAskel() {
		return ekaAskel;
	}

	public void setEkaAskel(boolean ekaAskel) {
		this.ekaAskel = ekaAskel;
	}
	
}
