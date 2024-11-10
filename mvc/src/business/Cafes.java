package business;

public class Cafes {

	
	private String name;
	private String ort;
	
	private String beschreibung;
	private int baeckerei ;
	
	private String[] kaffeeprodukte;
	
	public Cafes(String name, String ort , String beschreibung,
	int baekerei, String[] kaffeeprodukte){
	this.name = name;
	this.ort = ort;
	this.beschreibung = beschreibung;
	this.baeckerei = baeckerei;
	this.kaffeeprodukte = kaffeeprodukte;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getOrt() {
	return ort;
	}
	
	public void setOrt(String ort) {
	this.ort = ort;
	}
	
	public String getBeschreibung() {
	return beschreibung;
	}
	
	public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
	}
	
	public int getBaeckerei () {
	return baeckerei;
	}
	
	public void setBaeckerei(int baeckerei) {
	this.baeckerei = baeckerei;
	}
	
	public String[] getKaffeeprodukte() {
	return kaffeeprodukte;
	}
	
	public void setKaffeeprodukte(String[] kaffeeprodukte) {
	this.kaffeeprodukte = kaffeeprodukte;
	}
	
	public String getKaffeeprodukteAlsString(char trenner) {
	String ergebnis = "";
	int i = 0;
	for(i = 0; i < this.getKaffeeprodukte().length - 1; i++) {
	ergebnis = ergebnis + this.getKaffeeprodukte()[i] + trenner;
	}
	return ergebnis + this.getKaffeeprodukte()[i];
	}
	
	public String gibCafesZurueck(char trenner){
	return this.getName() + trenner
	+ this.getOrt() + trenner
	+ this.getBeschreibung() + trenner
	+ this.getBaeckerei() + trenner + "\n"
	+ this.getKaffeeprodukteAlsString(trenner) + "\n";
	}
}
