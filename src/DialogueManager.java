import java.util.Scanner;
public class DialogueManager {
    /**
     * Prints a string character by character with a 50ms delay between each
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
     * @param str - the string to print
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
}
