package utils;

import java.io.IOException;
import java.util.*;
import nappulat.*;

import game.MainGame;

public class Menu {
	static Scanner r = new Scanner(System.in);
	
	
	//Kysytaan kayttajalta mita han haluaa tehda
	public static void menu(Lauta lauta, MainGame game) throws InterruptedException, IOException {
		String input;
		OsCheck.clearConsole("");
		System.out.println("1. Jatka\n2. Tallenna\n3. Lataa\n4. Lisaa nappula \n5. Poista nappula");
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
			game.setLauta(pelilauta);
			break;
		case 4:
			addNappula(game);
			break;
		case 5:
			delNappula(game);
			break;
		}
		
		game.startTurns();
	}
	
	//Lisaa kayttajan haluaman nappulan kayttajan haluamaan paikkaan
	public static MainGame addNappula(MainGame game) throws InterruptedException, IOException {
		String posInput;
		System.out.println("Anna asetettavan nappulan sijainti(esim. A5): ");
		posInput = getPosInput();
		boolean vari;
		int temp = 0;
		System.out.println("Minka varinen(0 = musta, 1 = valkoinen): ");
		temp = Integer.parseInt(getInput(-1,2));
		vari = temp==1?true:false;
		int type;
		System.out.println("Minka nappulan haluat lisata(1 = sotilas, 2 = torni, 3 = hevonen, 4 = lahetti, 5 = Kuningatar, 6 = Kuningas, 7 = takaisin): ");
		type = Integer.parseInt(getInput(0, 8));
		int y = Integer.parseInt(posInput.substring(1))-1;
		int x = MainGame.strToInt(posInput.substring(0, 1));
		switch (type) {
			case 1:
				game.pelilauta.setNappula(x, y, new Sotilas(vari));
				break;
			case 2:
				game.pelilauta.setNappula(x, y, new Torni(vari));
				break;
			case 3:
				game.pelilauta.setNappula(x, y, new Hevonen(vari));
				break;
			case 4:
				game.pelilauta.setNappula(x, y, new Lahetti(vari));
				break;
			case 5:
				game.pelilauta.setNappula(x, y, new Kuningatar(vari));
				break;
			case 6:
				game.pelilauta.setNappula(x, y, new Kuningas(vari));
				break;
			case 7:
				menu(game.getLauta(), game);
		}
		return game;
	}
	
	//Poistetaan nappula kauttajan haluamasta paikasta
	public static void delNappula(MainGame game) {
		String input;
		System.out.println("Anna poistettavan nappulan sijainti(esim. A5): ");
		input = getPosInput();
		game.getLauta().delNappula(MainGame.strToInt(input.substring(0, 1)), Integer.parseInt(input.substring(1)));
	}
	
	//Vastaanotetaan kauttajan syotetta ja tarkistetaan etta se on oikeassa muodossa
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
	
	//Tallennetaan lauta
	public static void saveBoard(Lauta lauta) {
		Saver saver = new Saver();
		System.out.println("Anna tallennuksen nimi:");
		String name = r.next();
		saver.saveBoard(lauta, name);
	}
	
	//Ladataan tallennettu lauta
	public static Lauta loadBoard() {
		Saver saver = new Saver();
		System.out.println("Anna tallennuksen nimi:");
		String name = r.next();
		Lauta lauta = saver.loadBoard(name);
		return lauta;
	}
	
	// Vastaanotetaan kauttajan numeraali syotetta valilla pieni ja suuri
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
	
	// tarkistetaan onko syote oikein
	public static boolean legitInput(String input, int pieni, int suuri) {
		if(input.length()==1&&isInteger(input)&&Integer.parseInt(input)<suuri&&Integer.parseInt(input)>pieni) {
			return true;
		}
		return false;
	}
	
	//Tarkistetaan onko merkkijonon sisalto numero
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
