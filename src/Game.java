import java.util.Scanner;

public class Game {
    /* UNIVERSAL VARIABLES */
    public static String NAME;
    public static String SHIP_NAME;
    public static Ship SHIP;

    /* PRINT FUNCTIONS */
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void await() {
        Scanner waitScanner = new Scanner(System.in);
        waitScanner.nextLine();
    }

    public static void wait(double seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* GAME FUNCTIONS */
    public static void title() {
        clearScreen();
        wait(1);
        System.out.println("\033[1;31m");
        System.out.println("▌ ▌▞▀▖▜▘▛▀▖");
        System.out.println("▚▗▘▌ ▌▐ ▌ ▌");
        System.out.println("▝▞ ▌ ▌▐ ▌ ▌");
        System.out.println(" ▘ ▝▀ ▀▘▀▀ ");
        System.out.println("\033[0m");
        wait(1.5);
        print("Created by \033[1mSpencer Boggs\033[0m and \033[1mRohan Reddy\033[0m\n\n", 2);
        wait(2);
        print("Press ENTER to begin");
        await();
        clearScreen();
    }

    public static void createPlayer() {
        Scanner scan = new Scanner(System.in);

        print("Enter your name: ");
        NAME = scan.nextLine();

        print("\nWelcome, " + NAME + "!\n");
        wait(1);
        clearScreen();
    }

    public static void createPlayerShip() {
        Scanner scan = new Scanner(System.in);
        print("Name your ship: ");
        String shipName = scan.nextLine();
        clearScreen();

        // Implement ship creation here

    }
}
