package nappulat;

public class Hevonen extends Nappula {
	public Hevonen(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(4);
	}
}
