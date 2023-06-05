import java.util.Scanner;

public class DialogueManager {
    /**
     * Prints a string character by character with a 50ms delay between each
     * 
     * @param str - the string to print
     */
    public static void print(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Prints a string character by character with a 50ms/speed delay between each
     * 
     * @param str   - the string to print
     * @param speed - the speed will be 50ms/speed
     */
    public static void print(String str, int speed) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(50 / speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Waits for the specified amount of seconds
     * 
     * @param seconds - the amount of seconds to wait
     */
    public static void wait(double seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the specified amount of seconds
     * 
     * @param seconds - the amount of seconds to wait
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String prompt(String str) {
        Scanner input = new Scanner(System.in);
        System.out.print(str + " ");
        return input.nextLine();
    }

    public static int promptInt(String str) {
        Scanner input = new Scanner(System.in);
        System.out.print(str + " ");
        return input.nextInt();
    }

    public static void startScreen() {
        clearScreen();
        System.out.print("\033[1;31m");
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.out.print("▌ ▌▞▀▖▜▘▛▀▖\n");
            System.out.print("▚▗▘▌ ▌▐ ▌ ▌\n");
            System.out.print("▝▞ ▌ ▌▐ ▌ ▌\n");
            System.out.print(" ▘ ▝▀ ▀▘▀▀ \n");
        } else {
            System.out.print("▌ ▌▞▀▖▜▘▛▀▖\n");
            System.out.print("▚▗▘▌ ▌▐ ▌ ▌\n");
            System.out.print("▝▞ ▌ ▌▐ ▌ ▌\n");
            System.out.print(" ▘ ▝▀ ▀▘▀▀ \n");
        }
        System.out.print("\033[0m");
        wait(1);
        print("Created by \033[1mSpencer Boggs\033[0m and \033[1mRohan Reddy\033[0m");
        wait(2);
        clearScreen();
    }

    public static Ship createShip(String name) {
        clearScreen();
        print("Choose your ship type:\n", 5);
        print("1. Light\n", 5);
        print("2. Medium\n", 5);
        print("3. Heavy\n", 5);
        String choice = prompt("Enter your choice: ");
        if (choice.equals("1")) {
            return new Ship(name, Ship.ShipType.LIGHT);
        } else if (choice.equals("2")) {
            return new Ship(name, Ship.ShipType.MEDIUM);
        } else if (choice.equals("3")) {
            return new Ship(name, Ship.ShipType.HEAVY);
        } else {
            print("Invalid choice!\n");
            wait(1);
            return createShip(name);
        }
    }

    public static void showShipStats(Ship ship) {
        clearScreen();
        print("Your ship has been created!\n");
        print("Here are your ship's stats:\n");
        print(ship.getAllStats(), 3);
        wait(2);
    }

    public static void introduction() {
        clearScreen();
        print("Hello, " + Void.PLAYER.name + ".\n");
        wait(1);
        print("I am Minerva, the AI assistant for your ship.\n");
        wait(1.5);
        print("Before we begin, there are some things you should know.\n\n");
        wait(1.5);
        print("Current Year: 2570\n");
        wait(1);
        print("It is now two years after The Fracture, a solar system-wide war that \ndismantled all major governments and left the solar system in chaos.\n\n");
        wait(1.5);
        print("You are in the Jupiter Sector, which is controlled by the JLA, or Jovian \nLiberation Alliance. ");
        wait(1);
        print("The JLA consists of thousands of pirates who are trying \nto establish \"order\" in the sector through violent means. \n");
        wait(2.5);
    }

    public static void actionManagerInstructions() {
        clearScreen();
        print("Throughout the game you can perform the following actions\n in certain situations.");
        wait(1);
        print("1. Status Report - Displays your current stats and cargo\n");
        print("2. Dock - Dock at a space station to buy and sell cargo, refuel, and repair your ship\n");
        print("3. Leave - Leave the space station\n");
        print("4. Travel - Travel to a different location\n");
        print("5. Mine - Mine asteroids for cargo\n");
        print("6. Attack - Attack a hostile location\n");
        print("7. Repair - Repair your ship\n");
        print("8. Refuel - Refuel your ship\n");
        print("9. Buy Ammo - Buy ammo for your ship\n");
        print("10. Sell Cargo - Sell cargo for credits\n");
        print("11. Buy Oxygen - Buy oxygen for your ship\n");
        print("12. Quit - Quit the game\n");
        wait(5);
        print("\nTo use an action simply type out the name of the action and press enter\n");
        wait(1);
        print("Actions are case insensitive, so you can type them in all caps or all lowercase\n");
        wait(3);
    }
}
