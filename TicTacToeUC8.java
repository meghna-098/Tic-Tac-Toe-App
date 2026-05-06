import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC8 {

    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static char currentPlayer;
    static char human = 'X';
    static char computer = 'O';

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Toss to decide first player
        currentPlayer = rand.nextBoolean() ? human : computer;
        System.out.println("First Player: " + currentPlayer);

        boolean gameOver = false;

        // 🔁 Continuous Game Loop
        while (!gameOver) {

            printBoard();

            if (currentPlayer == human) {
                System.out.print("Enter your move (1-9): ");
                int move = sc.nextInt();

                if (isValidMove(move)) {
                    placeMove(move, human);
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue; // repeat same player
                }

            } else {
                // Computer random move
                int move;
                do {
                    move = rand.nextInt(9) + 1;
                } while (!isValidMove(move));

                System.out.println("Computer chose: " + move);
                placeMove(move, computer);
            }

            // ✅ Check Win
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            }
            // ✅ Check Draw
            else if (isDraw()) {
                printBoard();
                System.out.println("Game is a draw!");
                gameOver = true;
            }
            // 🔄 Switch Turn
            else {
                currentPlayer = (currentPlayer == human) ? computer : human;
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
        return move >= 1 && move <= 9 && board[move - 1] != 'X' && board[move - 1] != 'O';
    }

    // ✏️ Place Move
    static void placeMove(int move, char player) {
        board[move - 1] = player;
    }

    // 🏆 Check Win
    static boolean checkWin(char player) {
        int[][] winPositions = {
            {0,1,2}, {3,4,5}, {6,7,8}, // rows
            {0,3,6}, {1,4,7}, {2,5,8}, // cols
            {0,4,8}, {2,4,6}           // diagonals
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