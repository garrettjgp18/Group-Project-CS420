package Controller;

import Hierarchy.Component;
import Hierarchy.Container;
import Hierarchy.Item;
import MenuView.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
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
    private TreeView<Component> farmHierarchy;

    @FXML
    private Button farmScan;

    @FXML
    private Button goToItem;

    @FXML
    private TextArea pageAlerts;


    /*
     * Purpose: Initializes the TreeView and it's preset root, container, and example item
     * TODO: Possibly make it read from a file to save cells instead of wiping each run?
     * 
     * It also formats the cells to only display the objects name, instead of its class path and memory location.
     */
    @FXML
    private void initialize(){

        // Create object of class
        Container farm = new Container("Farm", 0, 0, 0, 800, 600 ,0);
        Container barn = new Container("Barn", 1000, 10, 15, 200, 100, 50);
        Item chicken = new Item("Chicken", 0, 0, 0, 0, 0, 0);

        // Add barn to component array
        farm.addComponent(barn);
        barn.addComponent(chicken);

        // Create an item of TreeView that passed in objcet of class
        TreeItem<Component> rootNode = new TreeItem<>(farm); // root (DO NOT DELETE NOR DUPLICATE)
        TreeItem<Component> barnNode = new TreeItem<>(barn); // Containers
        TreeItem<Component> itemNode = new TreeItem<>(chicken); // Items
        
        // Modifiers to root
        farmHierarchy.setRoot(rootNode); //Root will always be the "farm"
        farmHierarchy.getSelectionModel().selectFirst(); //unsure yet
        rootNode.setExpanded(true); //expands on launch automatically

        // Add item to the desired "Container"
        barnNode.getChildren().add(itemNode); //specify parent node, then what you're adding to said node
        rootNode.getChildren().add(barnNode);


        // Changes the name of the cells within TreeView to their set name, instead of memory + classpath.
        // https://stackoverflow.com/questions/44210453/how-to-display-only-the-filename-in-a-javafx-treeview

        farmHierarchy.setCellFactory(param -> new TreeCell<Component>() {
            @Override
            protected void updateItem(Component item, boolean empty) {
                super.updateItem(item, empty);
        
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName()); 
                }
            }
        });
    }



    // Button Stuff
    // Purpose: Add Contianer to cell depending on user click
    // Guards: Cannot add a container to an item
    @FXML
    void btnAddContainer(ActionEvent event) {
        // Base Cases
        // Ensure selected isn't an item - cannot add container to items
        TreeItem<Component> check = farmHierarchy.getSelectionModel().getSelectedItem();
        // Checks to see if clicked value is an instance of Item, if so throw error into Alerts
        if (check.getValue() instanceof Item) { 
            pageAlerts.appendText("Cannot add container to an item - Please choose either the root or another container!\n");
        // If not, initilize new Cotainer and add it to the clicked cell
        } else {
            // TODO 
            // Add funcitonality to side buttons to set the values of the new container
            Container newContainer = new Container("New Container", 0, 0, 0, 0, 0, 0);
            TreeItem<Component> newContain = new TreeItem<>(newContainer);

            check.getChildren().add(newContain);
        }
    }

    // Purpose: Add an item to a cell depending on if it's a container or the root
    // Guards: Cannot add an item to an item
    @FXML
    void btnAddItem(ActionEvent event) {
        // Base Case
        // Ensure selected isn't an item - cannot add item to items.
        TreeItem<Component> check = farmHierarchy.getSelectionModel().getSelectedItem();
        // Checks to see if selected cell is an instance of the Item class, or if it's not a Container (Aka drone).
        // If so, throw error in Alerts page.
        if (check.getValue() instanceof Item || !(check.getValue() instanceof Container) ) {
            pageAlerts.appendText("Cannot add an Item to another Item - please choose a valid Container!\n");
        } else {
            // Otherwise. initialize new Item and add it to the clicked cell.
            // TODO
            // Add functionality to side buttons to set the values of the new containe.
            Item newItem = new Item("New Item", 0, 0, 0, 0, 0, 0);
            TreeItem<Component> newTreeItem = new TreeItem<>(newItem);

            check.getChildren().add(newTreeItem);
        }
    }

    // Purpose: Delete a cell and all it's child cells 
    // Guards: Cannot delete the root
    @FXML
    void btnDelete(ActionEvent event) {
        // Base Case
        // Ensure a component is selected
        TreeItem<Component> check = farmHierarchy.getSelectionModel().getSelectedItem();
        if (check.getValue() == null){ //makes sure something is selected
            pageAlerts.appendText("Error: No cell selected!\n");
            // If something is selected, make sure it isn't the root by checking to see if it has parent cells
        } else if (check.getParent() == null) {
            pageAlerts.appendText("Error: Cannot delete the root!\n");
        } else {
            // If parent cells are detected, delete the selected node
            check.getParent().getValue().deleteComponent(check.getValue());
            // Delete any children cells (if any)
            check.getParent().getChildren().remove(check);
        }
    }

    @FXML
    void btnHeight(ActionEvent event) {

    }

    @FXML
    void btnLength(ActionEvent event) {

    }

    @FXML
    void btnName(ActionEvent event) {
        
    }

    @FXML
    void btnPrice(ActionEvent event) {

    }

    @FXML
    void btnWidth(ActionEvent event) {

    }

    @FXML
    void btnXCord(ActionEvent event) {

    }

    @FXML
    void btnYCord(ActionEvent event) {

    }

}
