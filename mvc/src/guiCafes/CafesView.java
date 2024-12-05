package guiCafes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Cafes;
import business.CafesModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class CafesView implements Observer {

private CafesModel cafesModel;
private CafesControl cafesControl;



	private Pane pane = new Pane();
	private Label lblEingabe = new Label("Eingabe");
	private Label lblAnzeige = new Label("Anzeige");
	private Label lblName = new Label("Name:");
	private Label lblOrt = new Label(" Ort ist :");
	private Label lblBeschreibung = new Label("Beschreibung: :");
	private Label lblBaeckerei = new Label("Baeckerei ?:");
	private Label lblKaffeeprodukte = new Label("Kaffeeprodukte:");
	private TextField txtName = new TextField();
	private TextField txtOrt = new TextField();
	private TextField txtBeschreibung = new TextField();
	private TextField txtBaeckerei = new TextField();
	private TextField txtKaffeeprodukte = new TextField();
	private TextArea txtAnzeige = new TextArea();
	private Button btnEingabe = new Button("Eingabe");
	private Button btnAnzeige = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport = new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport = new MenuItem("csv-Export");
	
	
	public CafesView(CafesModel cafesModel, CafesControl cafesControl,Stage primaryStage) {
	this.cafesModel = cafesModel;
	this.cafesControl = cafesControl;
	 this.cafesModel.addObserver(this);
	 
	Scene scene = new Scene(this.pane, 700, 340);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Verwaltung von Cafes");
	primaryStage.show();
	this.initKomponenten();
	this.initListener();
	}
	
	
	private void initKomponenten(){
	lblEingabe.setLayoutX(20);
	lblEingabe.setLayoutY(40);
	Font font = new Font("Arial", 24);
	lblEingabe.setFont(font);
	lblEingabe.setStyle("-fx-font-weight: bold;");
	lblAnzeige.setLayoutX(400);
	lblAnzeige.setLayoutY(40);
	lblAnzeige.setFont(font);
	lblAnzeige.setStyle("-fx-font-weight: bold;");
	lblName.setLayoutX(20);
	lblName.setLayoutY(90);
	lblOrt.setLayoutX(20);
	lblOrt.setLayoutY(130);
	lblBeschreibung.setLayoutX(20);
	lblBeschreibung.setLayoutY(170);
	lblBaeckerei.setLayoutX(20);
	lblBaeckerei.setLayoutY(210);
	lblKaffeeprodukte.setLayoutX(20);
	lblKaffeeprodukte.setLayoutY(250);
	pane.getChildren().addAll(lblEingabe, lblAnzeige,lblName, lblOrt, lblBeschreibung,lblBaeckerei, lblKaffeeprodukte);
	txtName.setLayoutX(170);
	txtName.setLayoutY(90);
	txtName.setPrefWidth(200);
	txtOrt.setLayoutX(170);
	txtOrt.setLayoutY(130);
	txtOrt.setPrefWidth(200);
	txtBeschreibung.setLayoutX(170);
	txtBeschreibung.setLayoutY(170);
	txtBeschreibung.setPrefWidth(200);
	txtBaeckerei.setLayoutX(170);
	txtBaeckerei.setLayoutY(210);
	txtBaeckerei.setPrefWidth(200);
	txtKaffeeprodukte.setLayoutX(170);
	txtKaffeeprodukte.setLayoutY(250);
	txtKaffeeprodukte.setPrefWidth(200);
	pane.getChildren().addAll(txtName, txtOrt, txtBeschreibung,txtBaeckerei, txtKaffeeprodukte);
	
	txtAnzeige.setEditable(false);
	txtAnzeige.setLayoutX(400);
	txtAnzeige.setLayoutY(90);
	txtAnzeige.setPrefWidth(270);
	txtAnzeige.setPrefHeight(185);
	pane.getChildren().add(txtAnzeige); 
	btnEingabe.setLayoutX(20);
	btnEingabe.setLayoutY(290);
	btnAnzeige.setLayoutX(400);
	btnAnzeige.setLayoutY(290);
	pane.getChildren().addAll(btnEingabe, btnAnzeige); 
    
	this.mnbrMenuLeiste.getMenus().add(mnDatei);
	this.mnDatei.getItems().add(mnItmCsvImport);
	this.mnDatei.getItems().add(mnItmTxtImport);
	this.mnDatei.getItems().add(new SeparatorMenuItem());
	this.mnDatei.getItems().add(mnItmCsvExport);
	pane.getChildren().add(mnbrMenuLeiste);
}
	
	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				nehmeCafesAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeCafesAn();
			} 
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeCafesInCsvDatei();
			}	
		});
	}
	
	private void nehmeCafesAuf() {
		try {
			this.cafesModel.setCafes(new Cafes(
				txtName.getText(), 
				txtOrt.getText(),txtBeschreibung.getText(),
				Integer.parseInt(txtBaeckerei.getText()),
				txtKaffeeprodukte.getText().split(";"))
			);
			zeigeInformationsfensterAn("Der Cafes wurde aufgenommen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}
   
	private void zeigeCafesAn() {
		if (this.cafesModel != null) {
			txtAnzeige.setText(
				this.cafesModel.getCafes().gibCafesZurueck(' ')
			);
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Cafes aufgenommen!");
		}
	} 
    
	public void leseAusDatei(String typ) {
		cafesControl.leseAusDatei(typ);

	
	}

	public void schreibeCafesInCsvDatei() {

		cafesControl.schreibeCafesInCsvDatei();
	}
    
	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}	
	
	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}


	@Override
	public void update() {
		this.zeigeCafesAn();
		
	}
}
	
	
