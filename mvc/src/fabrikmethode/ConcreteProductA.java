package fabrikmethode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	
	private BufferedReader reader;
	
	public ConcreteProductA() throws IOException {
		this.reader = new BufferedReader(new FileReader("cafes.csv"));
	}


	@Override
	public String[] leseAusDatei() throws IOException {
		
		String [] array= reader.readLine().split(";");
		return array;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.reader.close();
		
	}

}
