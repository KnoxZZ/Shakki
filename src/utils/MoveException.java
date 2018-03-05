package utils;

public class MoveException extends Throwable {

	/**
	 * ATM newswet. Firstnumber main version, second subversion
	 */
	private static final long serialVersionUID = 10L;

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
