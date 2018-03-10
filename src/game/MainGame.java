package game;import java.io.IOException;import java.io.UnsupportedEncodingException;import java.util.Arrays;import java.util.Scanner;import nappulat.*;import utils.*;public class MainGame {	String[] codes = OsCheck.getChars();	final static String[] characters = {"A","B","C","D","E","F","G","H"};	static Scanner reader = new Scanner(System.in);	static Lauta pelilauta;	public static void main(String[] args) throws IOException, InterruptedException {		start();				boolean whitesTurn = true;		MoveChecker ch = new MoveChecker();				mainLoop: while(true) {			System.out.print(pelilauta);			String[] inputs = getInput();			int[][] numInputs = stringsToNumbers(inputs);									Position start = pelilauta.getPosition(numInputs[0][0], numInputs[0][1]);			Position end = pelilauta.getPosition(numInputs[1][0], numInputs[1][1]);						try{				boolean legitMove = ch.isValid(start, end, pelilauta, whitesTurn);				if(legitMove) {					pelilauta.setNappula(end.getX(), end.getY(), start.getNappula());					pelilauta.delNappula(start.getX(), start.getY());					whitesTurn = !whitesTurn;					if(whitesTurn)						Clear("Valkoisen vuoro:");					else						Clear("Mustan vuoro:");				} else {					Clear("Illegal move");				}			} catch(MoveException e) {				Clear(e.getMessage());			}		}	}		public static void start() throws InterruptedException, IOException {		pelilauta = new Lauta();		pelilauta.startPos();		Clear();	}		public static void Clear(String... errorMsg) throws InterruptedException, IOException {		OsCheck.clearConsole(errorMsg);	}		public static String[] getInput() throws InterruptedException, IOException {		System.out.println("From where to where? [xy;xy] (Example: A4;A6): ");		String n = reader.next();				if(n.equals("menu")) {			Menu.menu(pelilauta);		}					if (!legitString(n)){			System.out.println("Not proper input");			return getInput();		}				String[] inputs = n.split(";");		boolean temp = true;		for (String text : inputs) {			if(!legitPositionString(text)) {				temp = false;			}		}				if (!temp){			System.out.println("Not proper input");			return getInput();		} else {			return inputs;		}	}		public static boolean legitString(String str) {		if(str.length() == 5 && str.substring(2, 3).equals(";")) {			return true;		}				return false;	}		public static boolean legitPositionString(String pos) {		if(pos.length() == 2) {			String start = pos.substring(0, 1);			String end = pos.substring(1);			int endInt = 0;			try {				endInt = Integer.parseInt(end);			} catch (NumberFormatException e) {				return false;			}			if(Arrays.asList(characters).contains(start.toUpperCase()) && endInt-1 < 8) {				return true;			}		}				return false;	}		public static int[][] stringsToNumbers(String[] strs) {		int[][] ready = new int[strs.length][2];				for (int i = 0; i < strs.length; i++) {			ready[i][0] = strToInt(strs[i].substring(0, 1));			ready[i][1] = Integer.parseInt(strs[i].substring(1, 2))-1;		}				return ready;	}		public static int strToInt(String s) {		int counter = 0;		while(counter <= 8) {			if(characters[counter].equalsIgnoreCase(s)) {				break;			}			counter++;		}		return counter;	}	public static Lauta getLauta() {		return pelilauta;	}		public void setLauta(Lauta pelilauta) {		this.pelilauta = pelilauta;	}}