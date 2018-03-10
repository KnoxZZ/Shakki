package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Saver {
	
	public void saveBoard(Lauta gameBoard, String name) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream("/tmp/" + name + ".shakki");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(gameBoard);
	        out.close();
	        fileOut.close();
	        System.out.printf("Saved with name: " + name + " in " + "/tmp/" + name + ".shakki");
		} catch (IOException i) {
			System.out.print("Can't save. Reason: " + i.getMessage());
		}
	}
	
	public Lauta loadBoard(String name) {
		Lauta gameBoard = null;
	    try {
	    	FileInputStream fileIn = new FileInputStream("/tmp/" + name + ".shakki");
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
