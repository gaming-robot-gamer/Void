import java.util.ArrayList;

import Locations.LocManager;
import Locations.Location;

public class ActionManager {

    public static Status status;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static String currActions = "";
    
    public ActionManager() {
        status = Status.DOCKED;
    }

    public enum Status {
        TRAVEL,
        BATTLE,
        DOCKED,
        GAMEOVER
    }

    public static void updateStatus(Status newStatus) {
        status = newStatus;
    }

    public static void run() {
        
        currActions = LocManager.currentLocation.getLocActions();
        
        
        /*switch (status) {
            case TRAVEL:
                travel();
                break;
            case BATTLE:
                //battle();
                break;
            case DOCKED:
                docked();
                break;
            case GAMEOVER:
                //gameover();
                break;
        } */
    }

    public static void actionMenu() {
        switch(DialogueManager.prompt("What would you like to do? \n" + currActions)) {
            case "Dock":
                dock();
                break;
            case "Leave":
                leave();
                break;
            case "Mine":
                mine();
                break;
            case "Attack":
                attack();
                break;
            case "Repair":
                repair();
                break; 
            case "Refuel":
                refuel();
                break;
            case "Buy Fuel":
                buyFuel(DialogueManager.promptInt("How much fuel would you like to buy? \n Fuel is 2 credits per unit"));
                break;
            case "Sell Cargo":
                DialogueManager.print("You have " + Void.SHIP.getCargo() + " cargo");
                sell(DialogueManager.promptInt("How much cargo would you like to sell? \n Cargo is 3 credits per unit"));
                break;
            default:
                DialogueManager.prompt("Invalid input");
                break;
        }
    }

    public static void refuel() {
        Void.SHIP.refuel(10);
        Void.PLAYER.loseOxygen(1);
    }
    /**
     * Allows the player to dock at a location
     */
    public static void dock() {
        status = Status.DOCKED;
    }
    /**
     * Allows the player to travel to a new location
     */
    public static void travel() {
        
    }

    /**
     * Allows the player to sell cargo
     * @param cargo
     */
    public static void sell(int cargo) {
        if (Void.SHIP.getCargo() >= cargo) {
            Void.SHIP.removeCargo(cargo);
            Void.PLAYER.addCredits(cargo * 3);
        } else {
            DialogueManager.print("You do not have enough cargo");
        }
    }

    public static void buyFuel(int fuel) {
        if (Void.PLAYER.getCredits() >= fuel * 2) {
            Void.PLAYER.loseCredits(fuel * 2);
            Void.SHIP.refuel(fuel);
        } else {
            DialogueManager.print("You do not have enough credits");
        }
    }
    /**
     * Allows the player to leave a location
     */
    public static void leave() {
        status = Status.TRAVEL;
    }
    /**
     * Allows the player to attempt to run from a battle
     */
    public static void flee() {

    }

    /**
     * Allows the player to mine for cargo
     */
    public static void mine() {
        Void.SHIP.addCargo(10);
        Void.PLAYER.loseOxygen(1);
    }

    /**
     * Allows the player to attack an enemy
     */
    public static void attack() {

    }

    /**
     * Allows the player to repair their ship
     */
    public static void repair() {

    }

    
}
