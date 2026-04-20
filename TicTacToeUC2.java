import java.util.Random;

public class TicTacToeUC2 {

    // Game state variables
    static char userSymbol;
    static char computerSymbol;
    static String currentPlayer;

    // Method to perform toss
    public static void toss() {
        Random random = new Random();
        int tossResult = random.nextInt(2); // 0 or 1

        if (tossResult == 0) {
            currentPlayer = "User";
            userSymbol = 'X';
            computerSymbol = 'O';
        } else {
            currentPlayer = "Computer";
            userSymbol = 'O';
            computerSymbol = 'X';
        }

        // Display results
        System.out.println("Toss Result: " + currentPlayer + " starts first!");
        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }

    public static void main(String[] args) {
        toss();
    }
}