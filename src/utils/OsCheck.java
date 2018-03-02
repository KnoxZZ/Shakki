package utils;

import java.io.IOException;

public class OsCheck {
	final static String[] unixCodes = {"♕ ","♔ ","♖ ","♗ ","♘ ","♙ ","♛ ","♚ ","♜ ","♝ ","♞ ","♟ "};
	final static String[] winCodes = {"K ","Q ","T ","L ","H ","S ","k ","q ","t ","l ","h ","s "};
	public static String osCheck() {
		String OS = null;
		if(OS == null) { OS = System.getProperty("os.name"); }
		return OS;
	}
	
	public static String[] getChars() {
	    if(osCheck().equals("Linux")) {
	    	return unixCodes;
	    }
	    else {
	    	return winCodes;
	    }
	}
	
	public static void clearConsole(String... errorMsg) throws InterruptedException, IOException{
		if(osCheck().equals("Linux")) {
			System.out.print("\033[H\033[2J");
		}
		else {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			if(errorMsg != null) {
				System.out.println(errorMsg[0]);
			}
		}
	}
}
