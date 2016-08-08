package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CompleteWindowController{
	private Main main;
	private Stage primaryStage;
	@FXML TableColumn<LoanModel, String> lastNameColumn, firstNameColumn;
	@FXML TableColumn<LoanModel, Float> balanceColumn;
	@FXML TableView<LoanModel> table;
	private String ln, fn;
	private float b;
	String url = "jdbc:mysql://localhost:3306/loans";
	String uname = "root";
	String pword = "imsuccessful1";
	ObservableList<LoanModel> loanList = FXCollections.observableArrayList();
	
	public void setMain(Main main, Stage primaryStage){
	
			this.main = main;
			this.primaryStage = primaryStage;
			lastNameColumn.setCellValueFactory(new PropertyValueFactory<LoanModel, String>("lastName"));
			firstNameColumn.setCellValueFactory(new PropertyValueFactory<LoanModel, String>("firstName"));
			balanceColumn.setCellValueFactory(new PropertyValueFactory<LoanModel, Float>("balance"));
			
			table.setItems(getLoanModel()); //to populate Javafx table, use ObservableList
	}
	
	public ObservableList<LoanModel> getLoanModel(){
		
		try{
			
			Connection con = DriverManager.getConnection(url, uname, pword);
			Statement stmnt = con.createStatement();				//these 3 lines connect to MySQL Workbench
			ResultSet rs = stmnt.executeQuery("SELECT * FROM borrowers");
			
			while(rs.next()){			//While the list has proceeding items, assign the data to the variables
				ln = rs.getString(2);
				fn = rs.getString(3);
				b = rs.getFloat(4);
				System.out.println(ln + " " + fn +" " + b );
				loanList.add(new LoanModel(ln, fn, b));  // Fill in the LoanModel Object and save to loanList observablelist
				main.LastNmList.add(ln);
				main.FirstNm.add(fn);
				main.BalanceList.add(b);
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}
		return loanList;
	}
	
	@FXML public void saveToExcel() throws Exception{
	
		Writer writer = null;
		main.alertSaved();
		try{							//csv works for commas "," and arranges the list on Excel
		File file = new File("C:/Users/Edessa/Desktop/LoanCopy.csv");
		writer = new BufferedWriter(new FileWriter(file));
		
		//STORE EACH DATA FROM OBSERVABLELIST TO EXCEL
		for(LoanModel loan : loanList){
			String text = loan.getLastName() + "," + loan.getFirstName() + "," + loan.getBalance() + "\n";
			writer.write(text);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			writer.flush();
			writer.close();
		}
	}
	@FXML public void retrieve(){
	}
	public void goBack(){
		main.firstWindow();
	}


}
