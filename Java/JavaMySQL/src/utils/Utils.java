package utils;

import java.io.IOException;

public class Utils {
    public static void mainMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1. Add Data");
        System.out.println("2. Read Data");
        System.out.println("3. Update Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
    }

    public static void getInput() {
        System.out.print("Enter your choices: ");
    }

    public static void clearScreen() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
