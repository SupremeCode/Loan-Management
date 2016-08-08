package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CheckWindowController {
	private Main main;
	private Stage primaryStage;
	private HSSFCell cell;
	private String lastName, firstName, balance;
	@FXML private TextField firstNm, lastNm;

	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
	}
	public void goBack(){
		main.firstWindow();
	}
	@FXML
	public void check(){ //add user input to the temporary ArrayList to use for comparison on the next controller
		main.FirstNm.add(firstNm.getText());
		main.LastNm.add(lastNm.getText());
		main.check2();
	}
	@FXML
	public void enterPressed(){
		lastNm.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER)  {
		           check();
		        }
			}
		});
	}
}
