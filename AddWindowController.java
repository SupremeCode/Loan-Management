package application;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AddWindowController {
	private Main main;
	private Stage primaryStage;
	
	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
	}
	public void goBack(){
		main.firstWindow();
	}
	
	public void add(){
	//mySQL INSERT INTO code here
		
	}
}
