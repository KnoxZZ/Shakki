package utils;

// Error Luokka kaytettavaksi MoveCheckerissa

public class MoveException extends Throwable {

	private static final long serialVersionUID = 10L;
	
	// Constructors auto created by eclipse
	public MoveException() {
		this("Can't do that move");
	}

	public MoveException(String arg0) {
		super(arg0);
	}

	public MoveException(Throwable arg0) {
		super(arg0);
	}

	public MoveException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MoveException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
