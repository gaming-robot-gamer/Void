import Locations.*;

public class Void {
    public static Character PLAYER;
    public static Ship SHIP;

    public static void main(String[] args) throws Exception {
        // Display the title screen
        //DialogueManager.startScreen();

        // Player Creation
        String name = DialogueManager.prompt("Enter your name:");
        PLAYER = new Character(name);
        DialogueManager.print("Welcome, " + PLAYER.name + "!\n");

        // Ship Creation
        String shipName = DialogueManager.prompt("Name your ship:");
        SHIP = DialogueManager.createShip(shipName);
        DialogueManager.showShipStats(SHIP);

        // Introduction text
        //DialogueManager.introduction();

        // Display the current location
        DialogueManager.print("You are currently at " + LocManager.currentLocation.getName() + "\n");

        // Start the game
        ActionManager.run();
    }
}