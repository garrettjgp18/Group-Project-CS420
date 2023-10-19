package MenuView;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class App extends Application  {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("LookandFeel.fxml"));
			Scene scene = new Scene(root,2000,1200);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Main Menu");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
		
	
}
