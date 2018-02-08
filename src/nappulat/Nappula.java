package nappulat;

public class Nappula {
	boolean vari;	// vari true == valkoinen, vari false == musta
	String sijainti;
	public Nappula(boolean vari, String sijainti) {
		this.vari = vari;
		this.sijainti = sijainti;
	}
	@Override
	public String toString() {
		String tempvari = vari?"Valkoinen":"Musta";
		return "Vari: "+tempvari+", Sijainti: "+sijainti;
	}
}
