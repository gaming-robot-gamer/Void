public class NPC {
    // NPC variables
    public String name;
    public int health;
    public int strength;

    public enum NPCType {
        FRIENDLY, HOSTILE, NEUTRAL
    }

    public NPC(String name, int health, NPCType type) {
        this.name = name;
        this.strength = 10;
        this.health = 100;
        // Set different variables for different types
    }
}
