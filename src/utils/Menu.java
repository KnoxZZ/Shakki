package utils;

import java.io.IOException;
import java.util.*;

public class Menu {
	static Scanner r = new Scanner(System.in);
	
	public static void menu(Lauta lauta) throws InterruptedException, IOException {
		String input;
		OsCheck.clearConsole();
		System.out.println("1. Jatka\n2. Tallenna\n3. Lataa\n4. Lis‰‰ nappula \n5. Poista nappula");
		input = getInput();
		int inp = Integer.parseInt(input);
		switch (inp) {
		case 1:	
			break;
		case 2:
			saveBoard(lauta);
			break;
		case 3:
			Lauta pelilauta = loadBoard();
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}
	
	public static void saveBoard(Lauta lauta) {
		Saver saver = new Saver();
		System.out.println("Anna tallennuksen nimi:");
		String name = r.next();
		saver.saveBoard(lauta, name);
	}
	
	public static Lauta loadBoard() {
		Saver saver = new Saver();
		System.out.println("Anna tallennuksen nimi:");
		String name = r.next();
		Lauta lauta = saver.loadBoard(name);
		return lauta;
	}
	
	public static String getInput() {
		String input;
		input = r.next();
		input.replaceAll("\\s+","");
		if(!legitInput(input)) {
			 System.out.println("Not proper input");
			 return getInput();
		}
		return input;
	}
	public static boolean legitInput(String input) {
		if(input.length()==1&&isInteger(input)&&Integer.parseInt(input)<6&&Integer.parseInt(input)>0) {
			return true;
		}
		return false;
	}
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e)
	   {
	      return false;
	   }
	}
}
