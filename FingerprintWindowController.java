package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class FingerprintWindowController {
	private Main main;
	private Stage primaryStage;
	private HSSFCell cell;
	@FXML Label amtPaid, datePaid, first, last, fSaved;
	String fSavedString = "";
	@FXML TextField approvedBy;
	
	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
		amtPaid.setText(main.amountPaid[0]);
		printInfo();
	}
	public void printInfo(){
		Date date = new Date();
		datePaid.setText(date.toString());
		first.setText(main.FirstNm.get(0).toUpperCase());
		last.setText(main.LastNm.get(0).toUpperCase());
	}
	public void capture(){
		fSaved.setText("Fingerprint Saved");	
		fSavedString = fSaved.getText().toString();	//for if(fSavedString.equals(""))
	}
	public void save(){ //Confirm if Info is correct before saving
		if(fSavedString.equals("")){
			main.alert3();
		}else if(approvedBy.getText().equals("")){
			main.alertAuthorized();
		}else{
			updateDBPay();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Is the Information Correct?");
			alert.setContentText("Click OK to Confirm and SAVE");
			Optional<ButtonType> result = alert.showAndWait();
			
			if (result.get() == ButtonType.OK){
				main.firstWindow();
			} else {
			}
		}
	}
	public void updateDBPay(){
		
	}
	public void cancel(){
		main.makePayment();
	}
}
