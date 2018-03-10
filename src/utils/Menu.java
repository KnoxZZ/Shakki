package utils;

import java.io.IOException;
import java.util.*;

public class Menu {
	static Scanner r = new Scanner(System.in);
	public void menu() throws InterruptedException, IOException {
		String input;
		OsCheck.clearConsole();
		System.out.println("1. Jatka\n2. Tallenna\n3. Lataa\n4. Lis‰‰ nappula \n5. Poista nappula");
		input = getInput();
		int inp = Integer.parseInt(input);
		switch (inp) {
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
		}
	}
	
	public String getInput() {
		String input;
		input = r.next();
		input.replaceAll("\\s+","");
		if(!legitInput(input)) {
			 System.out.println("Not proper input");
			 return getInput();
		}
		return input;
	}
	public boolean legitInput(String input) {
		if(input.length()==1&&isInteger(input)&&Integer.parseInt(input)<6&&Integer.parseInt(input)>0) {
			return true;
		}
		return false;
	}
	public boolean isInteger( String input )
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
