package Hierarchy;
// this class might be entirely unnecessary
import java.util.ArrayList;

public class Drone extends Component{

    private int length;
    private int width;
    private int height;
    private int xCord;
    private int yCord;
    private int price;
    //Drone specific properties
    private Component Dronelocation; // Current location of the drone
    private Component DroneDestination; // Where the drone is currently heading (not sure if this is needed)
    private String DroneStatus; // what the drone is currently doing ex: "Scanning", "Travelling", "Maintenance"
    



    public Drone(String name, int length, int width, int height, int xCord, int yCord, int price, Component Dronelocation, Component DroneDestination) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
        this.xCord = xCord;
        this.yCord = yCord;
        this.price = price;

        this.Dronelocation = Dronelocation;
        this.DroneDestination = DroneDestination;
        this.DroneStatus = "Waiting for command";


        //adding drone to the farmgrid when created


    }



    @Override
    public void addComponent(Component component) {
        throw new ClassCastException();
    }

    @Override
    public void deleteComponent(Component component) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteComponent'");
    }

    @Override
    public ArrayList<Component> gatherComponents() {
        throw new UnsupportedOperationException("Unimplemented method 'gatherComponents'");
    }

    // Setters and Getters
    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setX(int xCord){
        this.xCord = xCord;
    }

    public int getX(){
        return xCord;
    }

    public void setY(int yCord){
        this.yCord = yCord;
    }

    public int getY(){
        return yCord;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    //Drone specific getter and setter methods
    public Component getDronelocation(){
        return Dronelocation;
    }

    public void setDronelocation(Component Dronelocation){
        this.Dronelocation = Dronelocation;
    }

    public Component getDroneDestination(){
        return DroneDestination;
    }

    public void setDroneDestination(Component DroneDestination){
        this.DroneDestination = DroneDestination;
    }

    public String getDroneStatus(){
        return DroneStatus;
    }
    
    public void setDroneStatus(String DroneStatus){
        this.DroneStatus = DroneStatus;
    }

    
}
