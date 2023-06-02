public class Character {
    // Character variables
    public String name;
    public int health;
    public int strength;
    public int credits; //moneyyyy
    public int bounty; //bounty on your head
    public int oxygen;

    public Character(String name) {
        this.name = name;
        this.strength = 10;
        this.health = 100;
        this.credits = 100;
        this.bounty = 0;
        this.oxygen = 100;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void heal(int heal) {
        health += heal;
    }

    public void addCredits(int credits) {
        this.credits += credits;
    }

    public void loseCredits(int credits) {
        this.credits -= credits;
    }

    public void addBounty(int bounty) {
        this.bounty += bounty;
    }

    public void removeBounty(int bounty) {
        this.bounty -= bounty;
    }

    public void addOxygen(int oxygen) {
        this.oxygen += oxygen;
    }

    public void loseOxygen(int oxygen) {
        this.oxygen -= oxygen;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getCredits() {
        return credits;
    }

    public int getBounty() {
        return bounty;
    }

    public int getOxygen() {
        return oxygen;
    }

    public String getName() {
        return name;
    }

    public void printStats() {
        DialogueManager.print("Name: " + name);
        DialogueManager.print("Health: " + health);
        DialogueManager.print("Oxygen: " + oxygen);
        DialogueManager.print("Credits: " + credits);
        DialogueManager.print("Bounty: " + bounty);
        
    }

}
