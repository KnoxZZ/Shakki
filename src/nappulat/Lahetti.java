package nappulat;

public class Lahetti extends Nappula {
	public Lahetti(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(3);
	}
}
