package main;
	
	import gui.CafesControl;
	import gui.CafesView;
	import javafx.application.Application;
	import javafx.stage.Stage;
	
	public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {		
	new CafesControl( primaryStage);
	}
	
	public static void main(String[] args){
	launch(args);
	}
	} 