package utils;

import java.io.IOException;
import java.util.*;

import game.MainGame;

public class Menu {
	static Scanner r = new Scanner(System.in);
	
	public static void menu(Lauta lauta) throws InterruptedException, IOException {
		String input;
		OsCheck.clearConsole("");
		System.out.println("1. Jatka\n2. Tallenna\n3. Lataa\n4. Lis‰‰ nappula \n5. Poista nappula");
		input = getInput(0,6);
		int inp = Integer.parseInt(input);
		switch (inp) {
		case 1:	
			break;
		case 2:
			saveBoard(lauta);
			break;
		case 3:
			Lauta pelilauta = loadBoard();
			MainGame.start(pelilauta);
			break;
		case 4:
			addNappula();
			break;
		case 5:
			delNappula();
			break;
		}
	}
	
	public static void addNappula() {
		String posInput;
		System.out.println("Anna asetettavan nappulan sijainti(esim. A5): ");
		posInput = getPosInput();
		boolean vari;
		int temp = 0;
		System.out.println("Mink‰ v‰rinen(0 = musta, 1 = valkoinen): ");
		temp = Integer.parseInt(getInput(-1,2));
		vari = temp==1?true:false;
		String Nappula;
		int type;
		System.out.println("Mink‰ nappulan haluat lis‰t‰(1 = sotilas, 2 = torni, 3 = hevonen, 4 = l‰hetti, 5 = Kuningatar, 6 = Kuningas): ");
		type = Integer.parseInt(getInput(0, 7));
		switch (type) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		}
	}
	
	public static void delNappula() {
		String input;
		System.out.println("Anna poistettavan nappulan sijainti(esim. A5): ");
		input = getPosInput();
		MainGame.getLauta().delNappula(MainGame.strToInt(input.substring(0, 1)), Integer.parseInt(input.substring(1)));
	}
	
	public static String getPosInput() {
		String input;
		input = r.next();
		input.replaceAll("\\s+","");
		if(!MainGame.legitPositionString(input)) {
			System.out.println("Not proper input");
			return getPosInput();
		}
		return input;
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
	
	public static String getInput(int pieni, int suuri) {
		String input;
		input = r.next();
		input.replaceAll("\\s+","");
		if(!legitInput(input, pieni, suuri)) {
			 System.out.println("Not proper input");
			 return getInput(pieni, suuri);
		}
		return input;
	}
	public static boolean legitInput(String input, int pieni, int suuri) {
		if(input.length()==1&&isInteger(input)&&Integer.parseInt(input)<suuri&&Integer.parseInt(input)>pieni) {
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
