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


}
