public class TicTacToeUC1 {

    // Method to initialize the board
    public static char[][] createBoard() {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        return board;
    }

    // Method to print the board
    public static void printBoard(char[][] board) {
        System.out.println("Tic-Tac-Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Move to next row
        }
    }

    // Main method
    public static void main(String[] args) {
        char[][] board = createBoard();
        printBoard(board);
    }
}