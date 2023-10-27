package MenuView;

import java.io.IOException;

import Controller.LookandFeelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Main View");

        initializeMenu();
    }

    public void initializeMenu() {
        try {
            // Load the FXML file using the correct path
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MenuView/LookandFeel.fxml"));
            Parent root = (Pane) loader.load();

            // Get the controller instance
            LookandFeelController controller = LookandFeelController.getInstance();

            // Set the controller for the loaded FXML
            loader.setController(controller);

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);

    }
}
