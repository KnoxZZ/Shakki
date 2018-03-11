package utils;

import java.io.IOException;

public class OsCheck {
	final static String[] unixCodes = {"♔ ","♕ ","♖ ","♗ ","♘  ","♙ ","♚ ","♛ ","♜ ","♝ ","♞ ","♟ "};
	final static String[] winCodes = {"Q ","K ","T ","L ","H ","S ","q ","K ","t ","l ","h ","s "};
	
	//Tarkistaa onko kayttojarjestelma Linux vai joku muu
	public static boolean osCheck() {
		String OS = null;
		if(OS == null) { OS = System.getProperty("os.name"); }
		if(OS.equals("Linux")) {
			return true;
		}
		return false;
	}
	
	//Palauttaa oikean merkkilistan 
	public static String[] getChars() {
	    if(osCheck()) {
	    	return unixCodes;
	    }
	    else {
	    	return winCodes;
	    }
	}
	
	//Tyhjentaa komentorivin
	public static void clearConsole(String... errorMsg) throws InterruptedException, IOException{
		if(osCheck()) {
			System.out.print("\033[H\033[2J");
			if(errorMsg != null) {
				System.out.println(errorMsg[0]);
			}
		}
		else {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			if(errorMsg != null) {
				System.out.println(errorMsg[0]);
			}
		}
	}
}
