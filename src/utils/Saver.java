package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Saver {
	
	//Tallentaa pelin nimella name
	public void saveBoard(Lauta gameBoard, String name) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream(name + ".shakki");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(gameBoard);
	        out.close();
	        fileOut.close();
	        System.out.println("Saved with name: " + name + ".shakki");
		} catch (IOException i) {
			i.printStackTrace();
			System.out.println("Can't save. Reason: " + i.getMessage());
		}
	}
	
	// Lataa pelin joka on tallennettu nimella name
	public Lauta loadBoard(String name) {
		Lauta gameBoard = null;
	    try {
	    	File file = new File(name + ".shakki");
	    	file.createNewFile();
	    	FileInputStream fileIn = new FileInputStream(name + ".shakki");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        gameBoard = (Lauta) in.readObject();
	        in.close();
	        fileIn.close();
	    } catch (IOException i) {
	        i.printStackTrace();
	        return null;
	    } catch (ClassNotFoundException c) {
	        System.out.println("Employee class not found");
	        c.printStackTrace();
	        return null;
	    }
	    
	    return gameBoard;
	}

}
