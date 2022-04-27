package utils;

public class Utils {
    public static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add Data");
        System.out.println("2. Read Data");
        System.out.println("3. Update Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
    }

    public static String getInput() {
        System.out.print("Enter your choices");
        return System.console().readLine();
    }
}
