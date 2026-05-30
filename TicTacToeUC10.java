public class TicTacToe {

    // Method to check draw condition
    public static boolean isDraw(char[][] board) {

        // Traverse entire board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // If empty cell exists, game is not draw
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        // No empty cells found
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
        };

        if (isDraw(board)) {
            System.out.println("Game is a Draw!");
        } else {
            System.out.println("Game still in progress.");
        }
    }
}