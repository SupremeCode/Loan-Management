package application;


import javafx.stage.Stage;

public class Alert3WindowController {
	
	Stage secondaryStage;
	Main main;
	
	public void setMain(Main main, Stage secondaryStage){
		
		this.main = main;
		this.secondaryStage = secondaryStage;
	
	}
	
	public void close(){
		secondaryStage.close();
	}
	
}
