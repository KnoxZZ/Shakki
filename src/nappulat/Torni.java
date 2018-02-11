package nappulat;

public class Torni extends Nappula{
	public Torni(boolean vari) {
		super(vari);
	}
	
	@Override
	public String toString() {
		return super.toStringWithNappula(2);
	}
}
