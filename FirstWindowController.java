package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FirstWindowController {
	private Main main;
	private Stage primaryStage;
	private String lastName, firstName, balance;
	@FXML private TableView tview;

	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
	}
	@FXML
	public void checkExistingLoans(){
		main.check();
	}
	@FXML
	public void addNewLoan(){
		main.add();
	}
	@FXML
	public void exit(){
		primaryStage.close();
	}
	@FXML
	public void completeList(){
		//go to CompleteWindowController via Main.java
		main.completeList();
	}
	@FXML
	public void overdue(){
		main.overdue();
	}
}
