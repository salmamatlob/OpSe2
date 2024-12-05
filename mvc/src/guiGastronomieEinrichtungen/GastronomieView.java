package guiGastronomieEinrichtungen;

import business.CafesModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class GastronomieView implements Observer{
	
	private GastronomieControl
 	gastronomienControl;
	private CafesModel cafesModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeCafes     
 		= new Label("Anzeige Cafes");
    	private TextArea txtAnzeigeCafes  = new TextArea();
    	private Button btnAnzeigeCafes = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public GastronomieView(
 		GastronomieControl 
 		GastronomieControl, 
   	 	Stage primaryStage, 
 		CafesModel cafesmodel){
     		this.gastronomienControl 
 			= gastronomienControl;
 		this.cafesModel = cafesmodel;
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Gastronomien");
    		primaryStage.show();
    		 this.cafesModel.addObserver(this);
   
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeCafes.setLayoutX(310);
    		lblAnzeigeCafes.setLayoutY(40);
    		lblAnzeigeCafes.setFont(font);
    		lblAnzeigeCafes.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeCafes);           
// Textbereich	
        	txtAnzeigeCafes.setEditable(false);
     		txtAnzeigeCafes.setLayoutX(310);
    		txtAnzeigeCafes.setLayoutY(90);
     		txtAnzeigeCafes.setPrefWidth(220);
    		txtAnzeigeCafes.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeCafes);        	
        	// Button
          	btnAnzeigeCafes.setLayoutX(310);
        	btnAnzeigeCafes.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeCafes); 
   }
   
   private void initListener() {
	    btnAnzeigeCafes.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	update();
	        	} 
   	    });
    }
   /*
    private void zeigeCafesAn(){
    		if(cafesModel.getCafes() != null){
    			txtAnzeigeCafes.setText(
    				cafesModel.getCafes()
 				.gibCafesZurueck(' '));
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Cafe aufgenommen!");
    		}
    		
    }	*/
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }

	@Override
	public void update() {
		if(cafesModel.getCafes() != null){
			txtAnzeigeCafes.setText(
			cafesModel.getCafes().gibCafesZurueck(' '));
			}
			else{
			zeigeInformationsfensterAn("Bisher wurde kein Cafes aufgenommen!");
			}
			}
		
	}	
    
