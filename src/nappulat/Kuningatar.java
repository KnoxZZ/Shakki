package nappulat;

public class Kuningatar extends Nappula {
	public Kuningatar(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(0);
	}
}
