package nappulat;

public class Kuningas extends Nappula {
	public Kuningas(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(1);
	}
}
