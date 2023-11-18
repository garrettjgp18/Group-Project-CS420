package Hierarchy;

import java.util.ArrayList;

public class Item extends Component {

    private int length;
    private int width;
    private int height;
    private int xCord;
    private int yCord;
    private int price;
    
    private int marketPrice;

    public Item(String name, int length, int width, int height, int xCord, int yCord, int price) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
        this.xCord = xCord;
        this.yCord = yCord;
        this.price = price;
        this.marketPrice = price;
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

    public void setMarketPrice(int marketPrice){
        this.marketPrice = marketPrice;
    }
    public int getMarketPrice(){
        return marketPrice;
    }

}


