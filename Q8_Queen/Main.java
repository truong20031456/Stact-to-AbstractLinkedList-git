public class Main {
    boolean[][] board = {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    public static void main(String[] args) {
        Main main = new Main();
        main.theWayOfWeen(main.board, 0);
        main.displayBoard(main.board);
    }

    static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                System.out.print(element ? "Q " : "- ");
            }
            System.out.println();
        }
    }

    static boolean theWayOfWeen(boolean[][] board, int row) {
        if (row == board.length) {
            return true; // Base case: All queens are placed successfully
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Place queen

                if (theWayOfWeen(board, row + 1)) {
                    return true; // If placing queen in current row leads to a solution
                }

                board[row][col] = false; // Backtrack if no solution found with this placement
            }
        }
        return false; // No solution for current row
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check the column on this row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
