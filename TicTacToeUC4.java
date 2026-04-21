public class TicTacToeUC4 {

    // Method to convert slot to row and column
    public static int[] getRowCol(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    public static void main(String[] args) {
        int slot = 5; // Example input

        int[] position = getRowCol(slot);

        System.out.println("Row: " + position[0]);
        System.out.println("Column: " + position[1]);
    }
}