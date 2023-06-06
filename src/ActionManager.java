import java.util.ArrayList;

import Locations.LocManager;
import Locations.Location;
import Locations.Space;
import Locations.Location.LocType;

public class ActionManager {

    public static Status status;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static String currActions = "";

    public ActionManager() {
       
    }

    public static void init() {
        status = Status.TRAVEL;
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

        LocManager.allLocs.get(0).updateOptions();
        currActions = LocManager.currentLocation.getLocActions();

        if (status == Status.BATTLE) {
            battleMenu();
        } else {
            actionMenu();
        }

        /*
         * switch (status) {
         * case TRAVEL:
         * travel();
         * break;
         * case BATTLE:
         * //battle();
         * break;
         * case DOCKED:
         * docked();
         * break;
         * case GAMEOVER:
         * //gameover();
         * break;
         * }
         */
    }

    public static void actionMenu() {
        String input = DialogueManager.prompt("\nWhat would you like to do?\n" + currActions + "\n >").toLowerCase();

        switch (input) {
            case "status report":
            case "status":
                printStatus();
                break;
            case "dock": 
                dock();
                break;
            case "leave":
                leave();
                break;
            case "travel":
                travel();
                break;
            case "mine":
                mine();
                break;
            case "attack":
                attack();
                break;
            case "repair":
                repair();
                break; 
            case "refuel":
                printCredits();
                refuel();
                break;
            case "buy ammo":
                printCredits();
                buyAmmo(DialogueManager.promptInt("How much ammo would you like to buy? \n Ammo is 1 credit per unit"));
                break;
            case "sell cargo":
                printCredits();
                sell(DialogueManager
                        .promptInt("How much cargo would you like to sell? \n Cargo is 3 credits per unit"));
                break;
            case "buy oxygen":
                printCredits();
                buyOxygen(DialogueManager
                        .promptInt("How much oxygen would you like to buy? \n Oxygen is 1 credit per unit"));
                break;
            default:
                DialogueManager.prompt("Invalid input");
                break;

        }
    }

    public static void battleMenu() {
        String input = DialogueManager.prompt("\nWhat would you like to do? \nAttack \nFlee \nEvade").toLowerCase();

        switch (input) {
            case "attack":
                attack();
                break;
            case "flee":
                flee();
                break;
            case "evade":
                evade();
                break;
            default:
                DialogueManager.prompt("Invalid input");
                break;
        }
    }

    public static void printCredits() {
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits \n");
    }

    public static void printStatus() {
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits \n");
        DialogueManager.print("You have " + Void.SHIP.getAmmo() + " ammo\n");
        DialogueManager.print("You have " + Void.SHIP.getFuel() + " fuel\n");
        DialogueManager.print("You have " + Void.PLAYER.getOxygen() + " oxygen\n");
        DialogueManager.print("You have " + Void.SHIP.getCargo() + " cargo\n");
    }

    public static void buyAmmo(int ammo) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid \n");
            return;
        }
        if (Void.PLAYER.getCredits() >= ammo) {
            Void.PLAYER.loseCredits(ammo);
            Void.SHIP.reload(ammo);
            DialogueManager.print("You have bought " + ammo + " ammo \n");
        } else {
            DialogueManager.print("You do not have enough credits \n");
        }
    }

    public static void buyOxygen(int oxygen) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid \n");
            return;
        }
        if (Void.PLAYER.getCredits() >= oxygen) {
            Void.PLAYER.loseCredits(oxygen);
            Void.PLAYER.addOxygen(oxygen);
            DialogueManager.print("You have bought " + oxygen + " oxygen \n");
        } else {
            DialogueManager.print("You do not have enough credits \n");
        }
    }

    public static void refuel() {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy fuel at an asteroid \n");
            return;
        }
        DialogueManager.print("You have " + Void.PLAYER.getCredits() + " credits");
        int fuelToBuy = DialogueManager.promptInt("How much fuel would you like to buy? \n Fuel is 2 credits per unit \n");
        if (fuelToBuy * 2 > Void.PLAYER.getCredits()) {
            DialogueManager.print("You do not have enough credits \n");
            return;
        }
        DialogueManager.print("You have bought " + fuelToBuy + " fuel \n");
        Void.SHIP.refuel(fuelToBuy);
        Void.PLAYER.loseCredits(fuelToBuy * 2);
        Void.PLAYER.loseOxygen(1);
    }

    /**
     * Allows the player to dock at a location
     */
    public static void dock() {
        LocManager.setCurrentLocation(LocManager.getClosestLocation());
        DialogueManager.print("You have docked at " + LocManager.currentLocation.getName());
        status = Status.DOCKED;
        currActions = LocManager.currentLocation.getLocActions();
        Void.SHIP.loseFuel(1);
    }

    /**
     * Allows the player to travel to a new location
     */
    public static void travel() {
        if (status == Status.TRAVEL) {
            DialogueManager.print("Potential Destinations: \nMoon\nAsteroid\nSpace Station\n");
            String type = DialogueManager.prompt("What kind of location do you want to travel to?\n").toLowerCase();
            switch (type) {
                case "moon":
                    LocManager.generateMoon();
                    Void.SHIP.loseFuel(15);
                    break;
                case "asteroid":
                    LocManager.generateAsteroid();
                    Void.SHIP.loseFuel(5);
                    break;
                case "space station":
                    LocManager.generateSS();
                    Void.SHIP.loseFuel(10);
                    break;
                default:
                    DialogueManager.print("That's not a valid destination. \n");
                    return;
            }
            //DialogueManager.print(type);
            //LocManager.generateLocation();
            //LocManager.setCurrentLocation(LocManager.getClosestLocation());
            DialogueManager.print("You have traveled to " + LocManager.getClosestLocation().getName());
        } else {
            DialogueManager.print("You cannot travel while docked or in battle. \n");
        }

    }

    /**
     * Allows the player to sell cargo
     * 
     * @param cargo
     */
    public static void sell(int cargo) {
        if (LocManager.getCurrentLocation().getLocType() == LocType.ASTEROID) {
            DialogueManager.print("You cannot buy ammo at an asteroid \n");
            return;
        }
        if (Void.SHIP.getCargo() >= cargo) {
            Void.SHIP.removeCargo(cargo);
            Void.PLAYER.addCredits(cargo * 3);
        } else {
            DialogueManager.print("You do not have enough cargo \n");
        }
    }

    /**
     * Allows the player to leave a location
     */
    public static void leave() {
        if (status == Status.DOCKED) {
            DialogueManager.print("You have undocked. \n");
            Void.SHIP.loseFuel(1);
            status = Status.TRAVEL;
            LocManager.setCurrentLocation(LocManager.allLocs.get(0));
            currActions = "Dock \nTravel \nRepair";
        } else {
            DialogueManager.print("You cannot undock from somewhere you're not docked to, " + Void.PLAYER.name + ".");
        }

    }

    /**
     * Allows the player to mine for cargo
     */
    public static void mine() {
        if (status != Status.DOCKED) {
            if ((LocManager.getCurrentLocation().getLocType() != LocType.ASTEROID)
                    || (LocManager.getCurrentLocation().getLocType() != LocType.MOON))
                DialogueManager.print("You cannot mine unless docked at an asteroid or moon. \n");
            return;
        }
        Void.SHIP.addCargo(10);
        Void.PLAYER.loseOxygen(1);
        Void.SHIP.loseFuel(1);
        DialogueManager.print("You have mined 10 cargo. ");
        DialogueManager.print("You now have " + Void.SHIP.getCargo() + " cargo. \n");
    }

    public static void printCargo() {
        DialogueManager.print("You have " + Void.SHIP.getCargo() + " cargo. \n");
    }
    /**
     * Allows the player to attack an enemy
     */
    public static void attack() {
        
    }

    /**
     * Allows the player to attempt to run from a battle
     */
    public static void flee() {
        
    }

    /**
     * Allows the player to attempt to evade an attack
     */
    public static void evade() {
            
    }

    /**
     * Allows the player to repair their ship
     */
    public static void repair() {
        if (status == Status.BATTLE) {
            DialogueManager.print("You cannot repair while in battle \n");
            return;
        }

        if ((Void.SHIP.getCargo() >= 10) && (Void.SHIP.getDurability() < Void.SHIP.getMaxDurability())) {
            Void.SHIP.removeCargo(10);
            Void.SHIP.repair(10);
        } else {
            DialogueManager.print("You do not have enough cargo \n");
        }
    }

}
