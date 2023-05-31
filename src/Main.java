import java.util.Scanner;

public class Main {
    // Prints a string one character at a time
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

    // Starts the game
    public static void start() {

        // INTRO STUFF HERE

        
        // CHARACTER CREATION
        Scanner scan = new Scanner(System.in);

        print("Enter your name: ");
        String name = scan.nextLine();
        
        print(" Welcome, " + name + "!\n");

        // Maybe some introduction to your ship here?


        // SHIP CREATION
        print("Name your ship: ");
        String shipName = scan.nextLine();
        print(shipName);
        
        scan.close();
    }
    


    public static void main(String[] args) throws Exception {
        start();
    }
}