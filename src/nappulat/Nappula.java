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

	public boolean isVari() {
		return vari;
	}

	public void setVari(boolean vari) {
		this.vari = vari;
	}

	public String getSijainti() {
		return sijainti;
	}

	public void setSijainti(String sijainti) {
		this.sijainti = sijainti;
	}
	
}
