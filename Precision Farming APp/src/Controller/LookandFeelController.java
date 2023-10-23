package Controller;

import Hierarchy.Component;
import Hierarchy.Container;
import Hierarchy.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
    private Pane farmGrid;

    @FXML
    private TreeView<Component> farmHierarchy;

    @FXML
    private Button farmScan;

    @FXML
    private Button goToItem;

    @FXML
    private TextArea pageAlerts;

    @FXML
    private Button btnSave;

    //----------------------------------------------------------------

    int CONSTRAIN_WIDTH = 600;
    int CONSTRAIN_LENGTH = 800;

    //----------------------------------------------------------------
    /*
     * Purpose: Initializes the TreeView and it's preset root, container, and example item
     * TODO: Possibly make it read from a file to save cells instead of wiping each run?
     * 
     * It also formats the cells to only display the objects name, instead of its class path and memory location.
     */
    @FXML
    private void initialize(){

        // Create object of class

        //TODO - go in and adjust length (y) and width (x) of root so that it doesnt draw black box over whole grid
        //TODO - Create constant variables and asign to Guards in saveDetails
        Container farm = new Container("Farm", 0, 0, 0, 0, 0 ,0);
        Container barn = new Container("Barn", 100, 100, 50, 150, 50, 50000);
        Item chicken = new Item("Chicken", 0, 0, 0, 0, 0, 0);

        // Add barn to component array
        farm.addComponent(barn);
        barn.addComponent(chicken);

    

        // Create an item of TreeView that passed in objcet of class
        TreeItem<Component> rootNode = new TreeItem<>(farm); // root (DO NOT DELETE NOR DUPLICATE)
        TreeItem<Component> barnNode = new TreeItem<>(barn); // Containers
        
        // Modifiers to root
        farmHierarchy.setRoot(rootNode); //Root will always be the "farm"
        farmHierarchy.getSelectionModel().selectFirst(); //unsure yet
        rootNode.setExpanded(true); //expands on launch automatically
        barnNode.setExpanded(true);

        // Add item to the desired "Container"
        rootNode.getChildren().add(barnNode);


        // Changes the name of the cells within TreeView to their set name, instead of memory + classpath.
        // https://stackoverflow.com/questions/44210453/how-to-display-only-the-filename-in-a-javafx-treeview

        // Lambda expression basically denotes that param is the argument, and -> {} signifies a block of code to come
        // Basically, we're editing the cells here to conver their name to the objects name
        farmHierarchy.setCellFactory(param -> {
            TreeCell<Component> cell = new TreeCell<Component>(){
                @Override
                protected void updateItem(Component item, boolean empty) {
                    super.updateItem(item, empty);
        
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getName()); 
                    }
            }
        };

        // Here, uses a similar idea to create a component, and uses cell from above to gather 
        // all data from the TreeView item. Calls it to Details textfields
        cell.selectedProperty().addListener((checking, selected, next) -> {
            Component cellItem = cell.getItem();

            if (next && (!cell.isEmpty())) {
                detailsName.setText(cellItem.getName());
                detailsLength.setText(String.valueOf(cellItem.getLength()));
                detailsWidth.setText(String.valueOf(cellItem.getWidth()));
                detailsHeight.setText(String.valueOf(cellItem.getHeight()));
                detailsX.setText(String.valueOf(cellItem.getX()));
                detailsY.setText(String.valueOf(cellItem.getY()));
                detailsPrice.setText(String.valueOf(cellItem.getPrice()));

                farmGrid.getChildren().clear();
                drawItems(farmHierarchy.getRoot());
            }
        });

        return cell;
    }); 
     
        // Will draw rootnode and the barn, but need to complete the TODO to fix the black grid
        farmGrid.getChildren().clear();
        drawItems(rootNode);
    }


    //----------------------------------------------------------------

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
            Container newContainer = new Container("New Container", detailsLength.getLength(), 0, 0, check.getValue().getX(), check.getValue().getY(), 0);
            TreeItem<Component> newContain = new TreeItem<>(newContainer);
            check.getChildren().add(newContain);

            // Clears grid and redraws all items
            farmGrid.getChildren().clear();
            drawItems(newContain);
        }
    }

    //----------------------------------------------------------------

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
            // Automatically sets X and Y cordinate to the container its being added too.
            Item newItem = new Item("New Item", 0, 0, 0, check.getValue().getX(), check.getValue().getY(), 0);
            TreeItem<Component> newTreeItem = new TreeItem<>(newItem);
            check.getChildren().add(newTreeItem);

            farmGrid.getChildren().clear();
            drawItems(newTreeItem);
            

        }
    }


    //----------------------------------------------------------------

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

            farmGrid.getChildren().clear();
            drawItems(farmHierarchy.getRoot());


        }
    }

    
    
    //----------------------------------------------------------------
    // Saves the changes made in the Details menu
    @FXML
    void saveChanges(ActionEvent event) {
        
        // Create variables to keep track of the roots width(x) and height(y)
        int rootsizeX = CONSTRAIN_WIDTH;
        int rootSizeY = CONSTRAIN_LENGTH;

        // Create variables that keep track of new coordinates from Details
        int x = Integer.parseInt(detailsX.getText());
        int y = Integer.parseInt(detailsY.getText());

        // Initialize component that keeps selected cell/TreeItem 
        Component item = farmHierarchy.getSelectionModel().getSelectedItem().getValue();
        
        // Root shoudl be unchangable - Base Case
        if (farmHierarchy.getSelectionModel().getSelectedItem().getParent() == null){
            pageAlerts.appendText("Cannot modify root\n");
            return; // Terminates save
        }

        // Ensure changing the location (x,y) does not push object out of bounds of farmGrid
        if (x > rootsizeX || y > rootSizeY) {
            pageAlerts.appendText("Object out of bounds of farm. Please ensure X < 600 and Y < 800\n");

        // Ensure width of container or item do not exceed their parent 
        } else if ( x + Integer.parseInt(detailsWidth.getText()) > rootsizeX || y + Integer.parseInt(detailsLength.getText()) > rootSizeY) {
            pageAlerts.appendText("Object out of bounds. Please ensure X + Width of item do not exceed 600, and Y + Length do not exceed 800\n");

        // If all pass, set new inputs to the textfields
        } else {
            item.setName(detailsName.getText());
            item.setLength(Integer.parseInt(detailsLength.getText()));
            item.setHeight(Integer.parseInt(detailsLength.getText()));
            item.setWidth((Integer.parseInt(detailsWidth.getText())));
            item.setX(Integer.parseInt(detailsX.getText()));
            item.setY(Integer.parseInt(detailsY.getText()));
            item.setPrice(Integer.parseInt(detailsPrice.getText()));
            

        }

        farmGrid.getChildren().clear();
        drawItems(farmHierarchy.getRoot());
    }

     public void drawFrame (String name, int x, int y, int width, int height, Color rgb) {
        // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Rectangle.html
        Rectangle rectangle = new Rectangle(width, height, Color.TRANSPARENT);
        rectangle.relocate(x, y);
        rectangle.setStrokeWidth(3);
        rectangle.setStroke(rgb);
        
        Text label = new Text(name);
        label.setX(x + 10);
        farmGrid.getChildren().addAll(rectangle, label);

    }


    public void drawItems (TreeItem<Component> root ) {
        
        // Ensures containers aren't deleted once items are added
        // No idea why the background turns black

        farmGrid.getChildren().clear();

        drawFrame(root.getValue().getName(), root.getValue().getX(), root.getValue().getY(), root.getValue().getWidth(), root.getValue().getHeight(), Color.RED);

        // Gets all TreeView items and redraws them accordingly
        for (TreeItem<Component> child : root.getChildren()) {
            if (child.getChildren().isEmpty()) {
                drawFrame(child.getValue().getName(), child.getValue().getX(), child.getValue().getY(), child.getValue().getWidth(), child.getValue().getHeight(), Color.BLUE);
            } else {
                drawItems(child);
            }
        }
    }  

    


    // Ignore these, too burnt out to go into fxml and remove them
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
