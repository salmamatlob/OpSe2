package guiGastronomieEinrichtungen;
	
	import business.CafesModel;
	import javafx.stage.Stage;
	
	public class GastronomieControl {	
		
		private GastronomieView
	 		gastronomienView;
		private CafesModel cafesModel;
		public GastronomieControl(Stage primaryStage){
	 		this.cafesModel = CafesModel.getInstance(); 		
			this.gastronomienView= new GastronomieView(this, primaryStage,cafesModel);
		}


}
