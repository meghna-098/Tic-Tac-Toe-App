import java.util.Scanner;

public class TicTacToeUC3 {

    public static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);
        int slot;

        while (true) {
            System.out.print("Enter a slot number (1-9): ");
            slot = scanner.nextInt();

            if (slot >= 1 && slot <= 9) {
                break;
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
            }
        }

        return slot;
    }

    public static void main(String[] args) {
        int userSlot = getUserSlot();
        System.out.println("You selected slot: " + userSlot);
    }
}