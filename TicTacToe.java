import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static char computerSymbol = 'O';

    public static void computerMove() {
        Random random = new Random();
        int slot;
        int row, col;

        while (true) {
            // Generate random slot (1–9)
            slot = random.nextInt(9) + 1;

            // Convert slot to row and column
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            // Check if the cell is empty
            if (board[row][col] == ' ') {
                board[row][col] = computerSymbol;
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Method to print board
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("--+---+--");
        }
    }

    public static void main(String[] args) {
        printBoard();
        computerMove();
        printBoard();
    }
}