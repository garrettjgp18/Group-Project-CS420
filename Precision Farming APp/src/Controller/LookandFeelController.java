package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.TextField;

public class LookandFeelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField detailsHeight;

    @FXML
    private TextField detailsLength;

    @FXML
    private TextField detailsName;

    @FXML
    private TextField detailsPrice;

    @FXML
    private TextField detailsWidth;

    @FXML
    private TextField detailsX;

    @FXML
    private TextField detailsY;

    @FXML
    private Group farmGrid;

    @FXML
    void initialize() {
        assert detailsHeight != null : "fx:id=\"detailsHeight\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsLength != null : "fx:id=\"detailsLength\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsName != null : "fx:id=\"detailsName\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsPrice != null : "fx:id=\"detailsPrice\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsWidth != null : "fx:id=\"detailsWidth\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsX != null : "fx:id=\"detailsX\" was not injected: check your FXML file 'Controller.fxml'.";
        assert detailsY != null : "fx:id=\"detailsY\" was not injected: check your FXML file 'Controller.fxml'.";
        assert farmGrid != null : "fx:id=\"farmGrid\" was not injected: check your FXML file 'Controller.fxml'.";

    }

}
