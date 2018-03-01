package utils;

public class OsCheck {
	private static String OS = null;
	final static String[] unixCodes = {"♕ ","♔ ","♖ ","♗ ","♘ ","♙ ","♛ ","♚ ","♜ ","♝ ","♞ ","♟ "};
	final static String[] winCodes = {"K ","Q ","T ","L ","H ","S ","k ","q ","t ","l ","g ","s "};
	   public static String[] getChars()
	   {
	      if(OS == null) { OS = System.getProperty("os.name"); }
	      if(OS.equals("Linux")) {
	    	  System.out.println(OS);
	    	  return unixCodes;
	      }
	      else {
	    	  return winCodes;
	      }
	   }
}
