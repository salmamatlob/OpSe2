package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Cafes;
import business.CafesModel;
import javafx.stage.Stage;

public class CafesControl {

private CafesModel cafesmodel;
private CafesView cafesview;

	public CafesControl(Stage stage) {
	this.cafesmodel = new CafesModel();
	this.cafesview = new CafesView(cafesmodel,this,stage);
	}
	
	
	public void leseAusDatei(String typ){
	try {
	if("csv".equals(typ)){
		cafesmodel.leseAusDatei(typ);
			cafesview.zeigeInformationsfensterAn("Die Cafes wurden gelesen!");
	}
	else{
		cafesview.zeigeInformationsfensterAn("Noch nicht implementiert!");
	}
	}
	catch(IOException exc){
	cafesview.zeigeFehlermeldungsfensterAn(
	"IOException beim Lesen!");
	}
	catch(Exception exc){
	cafesview.zeigeFehlermeldungsfensterAn(
	"Unbekannter Fehler beim Lesen!");
	}
	}
	
	void schreibeCafesInCsvDatei() {
	try {
	
	cafesmodel.schreibeCafesInCsvDatei();;
	cafesview.zeigeInformationsfensterAn("Die Cafes wurden gespeichert");
	}
	catch(IOException exc){
	cafesview.zeigeFehlermeldungsfensterAn(
	"IOException beim Speichern!");
	}
	catch(Exception exc){
	cafesview.zeigeFehlermeldungsfensterAn(
	"Unbekannter Fehler beim Speichern!");
	}
	}

}
