import java.util.Scanner;

public class TicTacToeUC10 {

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

            // Check Win (UC9 logic reused)
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                gameOver = true;
            }
            // ✅ UC10: Detect Draw Condition
            else if (isDraw()) {
                printBoard();
                System.out.println("🤝 Game is a draw! No moves left.");
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

    // 🏆 Check Win (reused)
    static boolean checkWin(char player) {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] pos : winPositions) {
            if (board[pos[0]] == player &&
                board[pos[1]] == player &&
                board[pos[2]] == player) {
                return true;
            }
        }
        return false;
    }

    // 🤝 UC10: Detect Draw Condition
    static boolean isDraw() {

        // Loop Traversal + Counting Logic
        for (char cell : board) {
            if (cell != 'X' && cell != 'O') {
                return false; // Empty cell found → not a draw
            }
        }

        return true; // No empty cells → draw
    }
}