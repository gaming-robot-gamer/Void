public class Character {
    // Character variables
    public String name;
    public int health;
    public int strength;
    public int credits; //moneyyyy
    public int bounty; //bounty on your head

    public Character(String name, int health) {
        this.name = name;
        this.strength = 10;
        this.health = 100;
        this.credits = 100;
        this.bounty = 0;
    }
    
}
