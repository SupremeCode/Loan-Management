package application;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoanModel {
	  private StringProperty firstName;
	  private StringProperty lastName;
	  private FloatProperty balance;
	
	 public LoanModel(String firstName, String lastName, float balance) {
	        this.firstName = new SimpleStringProperty(firstName);
	        this.lastName = new SimpleStringProperty(lastName);
	        this.balance = new SimpleFloatProperty(balance);
	 }
	 public String getFirstName() {
	        return firstName.get();
	 }

	 public void setFirstName(String firstName) {
	        this.firstName.set(firstName);
	 }

	 public String getLastName() {
	        return lastName.get();
	 }

	 public void setLastName(String lastName) {
	        this.lastName.set(lastName);
	 }

	 public float getBalance() {
	        return balance.get();
	 }

	 public void setBalance(float b) {
	        this.balance.set(b);
	 }
}
