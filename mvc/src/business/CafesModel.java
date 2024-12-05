package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import fabrikmethode.ConcreteCreatorA;
import fabrikmethode.ConcreteCreatorB;
import fabrikmethode.Creator;
import fabrikmethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class CafesModel implements Observable {
	
	private Vector<Observer>observers=new Vector<>();

 private Cafes cafes;
 private static CafesModel cafesmodel;

  private CafesModel() {
	
 }

  public static CafesModel getInstance() {
	  if(cafesmodel==null) {
		  cafesmodel=new CafesModel();
	  }
	  return cafesmodel;
  }

	public Cafes getCafes() {
	return cafes;
	
	}
	public void setCafes(Cafes cafes) {
	this.cafes=cafes;
	notifyObservers();
	
	}
	public void leseAusTxtDatei() throws IOException {
		Creator creator = new ConcreteCreatorB();
		Product product = creator.factoryMethod(); 	
		String [] zeile = product.leseAusDatei();
	    this.cafes = new Cafes(zeile[0],zeile[1],zeile[2],Integer.parseInt(zeile[3]), zeile[4].split("_"));
	    product.schliesseDatei(); 
	    notifyObservers();
	}

	
	
	public void leseAusCsvDatei(String typ) throws IOException{
	
		Creator creator= new ConcreteCreatorA();
		Product product= creator.factoryMethod();
		String[] zeile=product.leseAusDatei();
		this.cafes = new Cafes(zeile[0],zeile[1], (zeile[2]),Integer.parseInt(zeile[3]), zeile[4].split("_"));
	    product.schliesseDatei();
	    notifyObservers();
	
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
	    notifyObservers();


	
	
	}

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers){
		observer.update();
		
	}
	}
}
	
