package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class OverdueWindowController {
	private Main main;
	private Stage primaryStage;
	private String lastName, firstName, balance;
	@FXML private TableView tview;

	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
	}
	@FXML
	public void exit(){
		main.firstWindow();
	}
}
