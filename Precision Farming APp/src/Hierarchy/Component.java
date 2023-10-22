package Hierarchy;

import java.util.ArrayList;

public abstract class Component {
    
    private String name;

/*
 * Figured that instead of having "Container" and "Item" inherit every variable and setter/getter from here, that I could
 * set the constructor of Component to only use String, that way when making the TreeView, each item would display its name and it would
 * be easier. I was wrong, but have coded to far in to change anything draastically.
 * 
 */
    public Component(String name) { 
        this.name = name;          
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract Methods that "Container" and "Item" will inherit
    public abstract void addComponent(Component component);

    public abstract void deleteComponent(Component component);

    public abstract ArrayList<Component> gatherComponents();

    public abstract void setLength(int length);

    public abstract int getLength();

    public abstract void setWidth(int width);
     

    public abstract int getWidth();
      

    public abstract void setHeight(int height);
     

    public abstract int getHeight();
     

    public abstract void setX(int xCord);
    

    public abstract int getX();
    

    public abstract void setY(int yCord);
    

    public abstract int getY();
     

    public abstract void setPrice(int price);
    

    public abstract int getPrice();
     


    public void updateItem(Component item, boolean b){

    }
    


}
