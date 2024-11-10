package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CafesModel {

private Cafes cafes;

	public Cafes getCafes() {
	return cafes;
	
	}
	public void setCafes(Cafes cafes) {
	this.cafes=cafes;
	
	}
	
	public void leseAusDatei(String typ) throws IOException{
	
	BufferedReader ein = new BufferedReader(new FileReader("cafes.csv"));
	String[] zeile = ein.readLine().split(";");
	this.cafes = new Cafes(zeile[0],zeile[1], (zeile[2]),Integer.parseInt(zeile[3]), zeile[4].split("_"));
	ein.close();
	
	}
	public void schreibeCafesInCsvDatei() throws IOException{
	
	BufferedWriter aus= new BufferedWriter(new FileWriter("CafesAusgabe.csv", true)); 
	aus.write(cafes.gibCafesZurueck(';'));
	aus.close();
	
	
	}
	}
