package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fabrikmethode.ConcreteCreatorA;
import fabrikmethode.ConcreteCreatorB;
import fabrikmethode.Creator;
import fabrikmethode.Product;

public class CafesModel {

private Cafes cafes;

	public Cafes getCafes() {
	return cafes;
	
	}
	public void setCafes(Cafes cafes) {
	this.cafes=cafes;
	
	}
	public void leseAusTxtDatei() throws IOException {
		Creator creator = new ConcreteCreatorB();
		Product product = creator.factoryMethod(); 	
		String [] zeile = product.leseAusDatei();
	    this.cafes = new Cafes(zeile[0],zeile[1],zeile[2],Integer.parseInt(zeile[3]), zeile[4].split("_"));
	    product.schliesseDatei(); 
	}

	
	
	public void leseAusCsvDatei(String typ) throws IOException{
	
		Creator creator= new ConcreteCreatorA();
		Product product= creator.factoryMethod();
		String[] zeile=product.leseAusDatei();
		this.cafes = new Cafes(zeile[0],zeile[1], (zeile[2]),Integer.parseInt(zeile[3]), zeile[4].split("_"));
	    product.schliesseDatei();

	
	}
	public void schreibeCafesInCsvDatei() throws IOException{
	
		if (cafes == null) {
	        throw new IllegalStateException("Es wurde kein Cafe aufgenommen, der exportiert werden kann.");
	    }
	    try (BufferedWriter aus = new BufferedWriter(new FileWriter("CafesAusg.csv", true))) {
	        aus.write(cafes.gibCafesZurueck(';'));
	    } catch (IOException e) {
	        throw new RuntimeException("Fehler beim Schreiben in die Datei: " + e.getMessage(), e);
	    }


	
	
	}
	}
