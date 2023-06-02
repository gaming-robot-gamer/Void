import java.util.ArrayList;

import Locations.LocManager;
import Locations.Location;
import Locations.Location.LocType;

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
        
        actionMenu();
        
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
        String input = DialogueManager.prompt("What would you like to do?" + currActions + "\n");

        switch(input) {
            case "Status Report":
            case "0":
                printStatus();
                break;
            case "Dock": 
            case "1":
                dock();
                break;
            case "Leave":
            case "2":
                leave();
                break;
            case "Travel":
            case "3":
                leave();
                break;
            case "Mine":
            case "4":
                mine();
                break;
            case "Attack":
            case "5":
                attack();
                break;
            case "Repair":
            case "6":
                repair();
                break; 
            case "Refuel":
            case "7":
                printCredits();
                refuel();
                break;
            case "Buy Ammo":
            case "8":
                printCredits();
                buyAmmo(DialogueManager.promptInt("How much ammo would you like to buy? \n Ammo is 1 credit per unit"));
                break;
            case "Sell Cargo":
            case "9":
                printCredits();
                sell(DialogueManager.promptInt("How much cargo would you like to sell? \n Cargo is 3 credits per unit"));
                break;
            case "Buy Oxygen":
            case "10":
                printCredits();
                buyOxygen(DialogueManager.promptInt("How much oxygen would you like to buy? \n Oxygen is 1 credit per unit"));
                break;
            default:
                DialogueManager.prompt("Invalid input");
                break;
        
        }
    }

    public static void printCredits() {
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits");
    }

    public static void printStatus() {
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits");
        DialogueManager.print("You have " + Void.SHIP.getAmmo() + " ammo");
        DialogueManager.print("You have " + Void.SHIP.getFuel() + " fuel");
        DialogueManager.print("You have " + Void.PLAYER.getOxygen() + " oxygen");
        DialogueManager.print("You have " + Void.SHIP.getCargo() + " cargo");
    }

    public static void buyAmmo(int ammo) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid");
            return;
        }
        if (Void.PLAYER.getCredits() >= ammo) {
            Void.PLAYER.loseCredits(ammo);
            Void.SHIP.reload(ammo);
        } else {
            DialogueManager.print("You do not have enough credits");
        }
    }

    public static void buyOxygen(int oxygen) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid");
            return;
        }
        if (Void.PLAYER.getCredits() >= oxygen) {
            Void.PLAYER.loseCredits(oxygen);
            Void.PLAYER.addOxygen(oxygen);
        } else {
            DialogueManager.print("You do not have enough credits");
        }
    }

    public static void refuel() {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy fuel at an asteroid");
            return;
        }
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits");
        int fuelToBuy = DialogueManager.promptInt("How much fuel would you like to buy? \n Fuel is 2 credits per unit");
        if (fuelToBuy * 2 > Void.PLAYER.getCredits()) {
            DialogueManager.print("You do not have enough credits");
            return;
        }
        Void.SHIP.refuel(fuelToBuy);
        Void.PLAYER.loseCredits(fuelToBuy * 2);
        Void.PLAYER.loseOxygen(1);
    }
    /**
     * Allows the player to dock at a location
     */
    public static void dock() {
        DialogueManager.print("You have docked at " + LocManager.currentLocation.getName());
        status = Status.DOCKED;
        currActions = LocManager.currentLocation.getLocActions();
    }
    /**
     * Allows the player to travel to a new location
     */
    public static void travel() {
        LocManager.generateLocation();
        DialogueManager.print("You have traveled to " + LocManager.currentLocation.getName());
        LocManager.setCurrentLocation(LocManager.allLocs.get(LocManager.allLocs.size() - 1));
    }

    /**
     * Allows the player to sell cargo
     * @param cargo
     */
    public static void sell(int cargo) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid");
            return;
        }
        if (Void.SHIP.getCargo() >= cargo) {
            Void.SHIP.removeCargo(cargo);
            Void.PLAYER.addCredits(cargo * 3);
        } else {
            DialogueManager.print("You do not have enough cargo");
        }
    }

    
    /**
     * Allows the player to leave a location
     */
    public static void leave() {
        status = Status.TRAVEL;
        LocManager.setCurrentLocation(Location.LocType.VOID);
        currActions = "1. Dock, \n 3. Travel, \n 6. Repair";
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
        if (status != Status.DOCKED) {
            DialogueManager.print("You cannot mine unless docked");
            return;
        }
        Void.SHIP.addCargo(10);
        Void.PLAYER.loseOxygen(1);
        DialogueManager.print("You have mined 10 cargo");
        DialogueManager.print("You now have " + Void.SHIP.getCargo() + " cargo");
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
        if (status == Status.BATTLE) {
            DialogueManager.print("You cannot repair while in battle");
            return;
        }

        if ((Void.SHIP.getCargo() >= 10) && (Void.SHIP.getDurability() < Void.SHIP.getMaxDurability())) {
            Void.SHIP.removeCargo(10);
            Void.SHIP.repair(10);
        } else {
            DialogueManager.print("You do not have enough cargo");
        }
    }

    
}
