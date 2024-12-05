package main;
	
	import guiCafes.CafesControl;
	import guiCafes.CafesView;
	import javafx.application.Application;
	import javafx.stage.Stage;
	import guiGastronomieEinrichtungen.*;
	
	public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {		
	new CafesControl( primaryStage);
	
	Stage fensterGastronomieEinrichtungen=new Stage();
	new GastronomieControl(fensterGastronomieEinrichtungen);
	}
	public static void main(String[] args){
	launch(args);
	}
}
	