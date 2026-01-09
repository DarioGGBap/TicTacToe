import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public int getInt() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Ungültige Eingabe! Bitte gib eine Zahl zwischen 1 und 9 ein.");
                scanner.next();
            }
        }
    }
}