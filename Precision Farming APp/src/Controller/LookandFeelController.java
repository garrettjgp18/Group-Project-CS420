package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;

public class LookandFeelController {

    @FXML
    private Button addContainer;

    @FXML
    private Button addItem;

    @FXML
    private VBox componentButtons;

    @FXML
    private Button deleteObject;

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
    private TreeView<?> farmHierarchy;

    @FXML
    private Button farmScan;

    @FXML
    private Button goToItem;

    @FXML
    private TextArea pageAlerts;




    @FXML
    void btnAddContainer(ActionEvent event) {

    }

}
