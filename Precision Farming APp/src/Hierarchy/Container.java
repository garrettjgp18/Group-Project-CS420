package Hierarchy;

import java.util.ArrayList;

public class Container extends Component {
    
    private int length;
    private int width;
    private int height;
    private int xCord;
    private int yCord;
    private int price;

    // Stores containers for later - Composite Design 
    private ArrayList<Component> gatheredComp = new ArrayList<>();

    // Constructor for Container
    public Container(String name, int length, int width, int height, int xCord, int yCord, int price) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
        this.xCord = xCord;
        this.yCord = yCord;
        this.price = price;
    }

    // Inherited abstract methods from "Component"
    public void addComponent(Component component) {
        gatheredComp.add(component);
    }

    
    public void deleteComponent(Component component) {
        gatheredComp.remove(component);
    }

    
    public ArrayList<Component> gatherComponents() {
        return gatheredComp;
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

   

    
}
