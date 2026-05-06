import java.util.Scanner;

public class TicTacToeUC9 {

    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {

            printBoard();

            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = sc.nextInt();

            if (!isValidMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            placeMove(move, currentPlayer);

            // ✅ UC9: Check Winning Condition
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameOver = true;
            }
            // Draw condition
            else if (isDraw()) {
                printBoard();
                System.out.println("Game is a draw!");
                gameOver = true;
            }
            // Switch turn
            else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // 🧩 Print Board
    static void printBoard() {
        System.out.println();
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    // ✅ Validate Move
    static boolean isValidMove(int move) {
        return move >= 1 && move <= 9 &&
               board[move - 1] != 'X' &&
               board[move - 1] != 'O';
    }

    // ✏️ Place Move
    static void placeMove(int move, char player) {
        board[move - 1] = player;
    }

    // 🏆 UC9: Check Winning Condition
    static boolean checkWin(char player) {

        int[][] winPositions = {
            {0, 1, 2}, // Row 1
            {3, 4, 5}, // Row 2
            {6, 7, 8}, // Row 3
            {0, 3, 6}, // Column 1
            {1, 4, 7}, // Column 2
            {2, 5, 8}, // Column 3
            {0, 4, 8}, // Diagonal
            {2, 4, 6}  // Diagonal
        };

        // 🔁 Loop-based pattern checking
        for (int[] pos : winPositions) {
            if (board[pos[0]] == player &&
                board[pos[1]] == player &&
                board[pos[2]] == player) {
                return true; // Winner found
            }
        }

        return false; // No winner
    }

    // 🤝 Check Draw
    static boolean isDraw() {
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }
}