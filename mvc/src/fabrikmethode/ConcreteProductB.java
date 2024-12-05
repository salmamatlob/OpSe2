package fabrikmethode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product {
	
	private BufferedReader reader;
	
	public ConcreteProductB() throws IOException {
		this.reader = new BufferedReader(new FileReader("cafes.txt"));
	}


	@Override
	public String[] leseAusDatei() throws IOException {
		String [] array =  new String[5];
		String zeile = reader.readLine() ;
		int i = 0; 
		while (i < array.length) {
			array[i] = zeile;
			zeile =reader.readLine();
			i++;
			
		}
		return array;
	}


	@Override
	public void schliesseDatei() throws IOException {
		this.reader.close();
		
	}

}
