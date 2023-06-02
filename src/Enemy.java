public class Enemy extends Ship{
    
    public String name; // Name of the enemy ship
    
    public Enemy(String name, Ship.ShipType type) {
        super(name, type);
        this.name = name;
        
        // Set different variables for different types
    }
}
