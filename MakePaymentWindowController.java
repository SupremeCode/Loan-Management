package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MakePaymentWindowController {
	private Main main;
	private Stage primaryStage;
	@FXML Label amount, firstN, lastN, currentBalance;
	@FXML TextField cent1, cent2, ones, tens, hundreds, thousands, tenThousands, hundredThousands, millions, authorized;
	private String amountRecord;
	private static final int LIMIT = 1;
	@FXML Button okBtn, fingerprintBtn;
	
	public void setMain(Main main, Stage primaryStage){
			this.main = main;
			this.primaryStage = primaryStage;
			firstN.setText(main.FirstNm.get(0).toUpperCase());
			lastN.setText(main.LastNm.get(0).toUpperCase());
			currentBalance.setText(main.Balance.get(0).toString());
			cent2method();		//every digit is separated per method
			cent1method();
			onesMethod();
			tensMethod();
			hundredsMethod();
			thousandsMethod();
			tenThousandsMethod();
			hundredThousandsMethod();
			millionsMethod();
	}
	@FXML public void cent2method(){ //limit the number to 1 character inside the digit textfield
		cent2.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (cent2.getText().length() >= LIMIT) {

	                        cent2.setText(cent2.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void cent1method(){ //limit the number to 1 character inside the textfield
		cent1.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (cent1.getText().length() >= LIMIT) {

	                        cent1.setText(cent1.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void onesMethod(){ //limit the number to 1 character inside the textfield
		ones.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (ones.getText().length() >= LIMIT) {

	                        ones.setText(ones.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void tensMethod(){ //limit the number to 1 character inside the textfield
		tens.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (tens.getText().length() >= LIMIT) {

	                        tens.setText(tens.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void hundredsMethod(){ //limit the number to 1 character inside the textfield
		hundreds.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (hundreds.getText().length() >= LIMIT) {

	                    	hundreds.setText(hundreds.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void thousandsMethod(){ //limit the number to 1 character inside the textfield
		thousands.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (thousands.getText().length() >= LIMIT) {

	                    	thousands.setText(thousands.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void tenThousandsMethod(){ //limit the number to 1 character inside the textfield
		tenThousands.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (tenThousands.getText().length() >= LIMIT) {

	                    	tenThousands.setText(tenThousands.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void hundredThousandsMethod(){ //limit the number to 1 character inside the textfield
		hundredThousands.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (hundredThousands.getText().length() >= LIMIT) {

	                    	hundredThousands.setText(hundredThousands.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	@FXML public void millionsMethod(){ //limit the number to 1 character inside the textfield
		millions.lengthProperty().addListener(new ChangeListener<Number>(){

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				 if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (millions.getText().length() >= LIMIT) {

	                    	millions.setText(millions.getText().substring(0, LIMIT));
	                    }
	                }
			}});
	}
	
	public void enterPressed1(){ //when Enter key is pressed while OK button is selected
		okBtn.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER)  {
		           ok();
		        }
			}
		});
	}
	public void enterPressed2(){	//when Enter key is pressed while Fingerprint button is selected
		fingerprintBtn.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER)  {
					fingerprint();
		        }
			}
		});
	}
	public void ok(){ //remove comma "," if less than million or thousands
		if(thousands.getText().equals("")){
			amountRecord = hundreds.getText() + tens.getText() 
			+ ones.getText() + "." + cent1.getText() + cent2.getText() ;
			amount.setText(amountRecord);
			main.amountPaid[0] = amountRecord;
			System.out.println("Amount paid = "+amountRecord);
		}
		else if(millions.getText().equals("")){
			amountRecord = hundredThousands.getText() + tenThousands.getText() 
			+ thousands.getText() + "," + hundreds.getText() + tens.getText() 
			+ ones.getText() + "." + cent1.getText() + cent2.getText() ;
			amount.setText(amountRecord);
			main.amountPaid[0] = amountRecord;
			System.out.println(amountRecord);
		}
		else{
		amountRecord = millions.getText() + "," + hundredThousands.getText() + tenThousands.getText() 
		+ thousands.getText() + "," + hundreds.getText() + tens.getText() 
		+ ones.getText() + "." + cent1.getText() + cent2.getText() ;
		amount.setText(amountRecord);
		main.amountPaid[0] = amountRecord;
		System.out.println(amountRecord);
		}
	}
	public void goBack(){
		main.check2();
	}
	public void fingerprint(){
		if (amountRecord == null){
			main.alert2();
		}else if (authorized.getText().equals("")){
			main.alertAuthorized();
		}else{
			main.fingerprint();
		}
	}

}