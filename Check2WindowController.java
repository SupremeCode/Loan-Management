package application;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Check2WindowController {
	private Main main;
	private Stage primaryStage;
	@FXML Label firstNameLabel, lastNameLabel, balanceLabel;
	String url = "jdbc:mysql://localhost:3306/loans";
	String uname = "root";
	String pword = "yourPassword";
	int id;
	List<Float> bal = new ArrayList<Float>();
	List<Integer> id_ = new ArrayList<Integer>();
	Set<String> last = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	Set<String> first = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	private float currentBalance;
	ObservableList<LoanModel> historyList = FXCollections.observableArrayList(); //THIS

	public void setMain(Main main, Stage primaryStage){
			this.main = main;
			this.primaryStage = primaryStage;
			scan();
	}
	public void scan(){ //SCAN MYSQL DATA FOR THE QUERY INSIDE RESULTSET
		try{
			Connection con = DriverManager.getConnection(url, uname, pword);//these 3 lines let this connect to MySQL Workbench
			Statement stmnt = con.createStatement();	//CHANGE QUERY AFTER FINALIZING SQL TABLES		
			ResultSet rs = stmnt.executeQuery("SELECT * FROM borrowers where lastName = '" + main.LastNm.get(0)+"'");
												
			while(rs.next()){			//While the list has proceeding items, continue populating the TREESET:
				last.add(rs.getString(2)); //TREESET is used for the two Strings to ignore caps from user input.
				first.add(rs.getString(3));
				bal.add(rs.getFloat(4));
				id_.add(rs.getInt(1));			//STORE EACH DATA FROM SQL TO OBSERVABLELIST
				historyList.add(new LoanModel(rs.getString(2), rs.getString(3), rs.getFloat(4)));
				main.LastNmList.add(rs.getString(2));
				main.FirstNmList.add(rs.getString(3));
				main.BalanceList.add(rs.getFloat(4));
			}
			con.close();				//Close DB
		}catch(Exception e){
				e.printStackTrace();
		}finally{
		System.out.println(id_ + " " + last + " " + first + " " + bal);
		compare();
		}
	}
	public void compare(){ //check if there's a match on Last name and First Name inside ArrayLists
		if(last.containsAll(main.LastNm) && first.containsAll(main.FirstNm)){
			String firstUP = main.FirstNm.get(0).toUpperCase();	//make the stored user input ALL CAPS
			String lastUP = main.LastNm.get(0).toUpperCase();	
			firstNameLabel.setText(firstUP); //Make the entered names on JavaFX Label ALL CAPS
			lastNameLabel.setText(lastUP);
			
			List<String> lastList = new ArrayList<>(last); //put TreeSet to ArrayList to get index
			List<String> firstList = new ArrayList<>(first);
			List<Float> balList = new ArrayList<>(bal);
			List<Integer> idNum = new ArrayList<>(id_);
			
			for(int i=0; i < lastList.size(); i++) {		//Make ALL ArrayList ALL CAPS to match entered names
				  lastList.set(i, lastList.get(i).toUpperCase());
				}
			for(int i=0; i < firstList.size(); i++) {
				  firstList.set(i, firstList.get(i).toUpperCase());
				}
			//compare the ALL CAPS ArrayList lastList to ALL CAPS user input lastUP to get index.
			int lastIndex =  lastList.indexOf(lastUP);		

			currentBalance = balList.get(lastIndex);		//get balance with respect to the last name via index#
			balanceLabel.setText(balList.get(lastIndex).toString()); //set the JavaFX Label
			main.Balance.add(currentBalance);				//store the selected balance to a temporary Array.

			System.out.println("Last name index: " + lastIndex);
			System.out.println("Current Balance = " + currentBalance);
			System.out.println("ID number is: " + idNum.get(lastIndex));
	
		}else{
			firstNameLabel.setText("Not Found");
			lastNameLabel.setText("Not Found");
		}
	
	}
	public void checkHistory() throws Exception{
		//this saves the history information to Excel
		Writer writer = null;
		main.alertSaved();
		try{							//csv works for commas "," and arranges the list on Excel
		File file = new File("C:/Users/Edessa/Desktop/Receipt.csv"); //PREPARE EXCEL FILE
		writer = new BufferedWriter(new FileWriter(file));
		
		//STORE EACH DATA FROM OBSERVABLELIST TO EXCEL
		for(int i=0; i<main.LastNmList.size(); i++){
		String text = main.LastNmList.get(i) + "," + main.FirstNmList.get(i) + "," + main.BalanceList.get(i) + "\n";
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
	public float getCurrentBalance(){
		return currentBalance;
	}
	public void goBack(){
		main.check();
	}
	public void makePayment(){
		main.makePayment();
	}

}
