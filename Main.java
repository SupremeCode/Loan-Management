package application;
	
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage;
	protected HSSFCell cellMain;
	protected ArrayList<String> FirstNm = new ArrayList<>();
	protected ArrayList<String> LastNm = new ArrayList<>();
	protected ArrayList<Float> Balance = new ArrayList<>();
	protected String[] amountPaid = new String[1000];
	protected ArrayList<String> FirstNmList = new ArrayList<>();
	protected ArrayList<String> LastNmList = new ArrayList<>();
	protected ArrayList<Float> BalanceList = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		firstWindow();
	}
	public void firstWindow(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("FirstWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			FirstWindowController firstWindowController = loader.getController();
			firstWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void check(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("CheckWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			CheckWindowController checkWindowController = loader.getController();
			checkWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void completeList(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("CompleteWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			CompleteWindowController completeWindowController = loader.getController();
			completeWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void add(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("AddWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			AddWindowController addWindowController = loader.getController();
			addWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void check2(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Check2WindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Check2WindowController check2WindowController = loader.getController();
			check2WindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void alert2(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Alert2WindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Stage secondaryStage = new Stage();
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			
			Alert2WindowController alert2WindowController = loader.getController();
			alert2WindowController.setMain(this,secondaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			secondaryStage.setScene(scene);
			secondaryStage.setResizable(false);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void alert3(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("Alert3WindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Stage secondaryStage = new Stage();
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			
			Alert3WindowController alert3WindowController = loader.getController();
			alert3WindowController.setMain(this,secondaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			secondaryStage.setScene(scene);
			secondaryStage.setResizable(false);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void makePayment(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MakePaymentWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			MakePaymentWindowController makePaymentWindowController = loader.getController();
			makePaymentWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void alertAuthorized(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("AlertAuthorizedWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Stage secondaryStage = new Stage();
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			
			AlertAuthorizedWindowController alertAuthorizedWindowController = loader.getController();
			alertAuthorizedWindowController.setMain(this,secondaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			secondaryStage.setScene(scene);
			secondaryStage.setResizable(false);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void alertSaved(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("AlertSavedWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Stage secondaryStage = new Stage();
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			
			AlertSavedWindowController alertSavedWindowController = loader.getController();
			alertSavedWindowController.setMain(this,secondaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			secondaryStage.setScene(scene);
			secondaryStage.setResizable(false);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void overdue(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("OverdueWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			OverdueWindowController overdueWindowController = loader.getController();
			overdueWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void fingerprint(){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("FingerprintWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			FingerprintWindowController fingerprintWindowController = loader.getController();
			fingerprintWindowController.setMain(this,primaryStage);
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
		launch(args);
	}
}
