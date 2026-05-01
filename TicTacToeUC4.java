// author Sayantan
// version 1.0

public class TicTacToe {

    public static void main(String[] args) {
        int slot = 5; // example input

        int row = getRow(slot);
        int col = getCol(slot);

        System.out.println("Slot: " + slot);
        System.out.println("Row: " + row + ", Column: " + col);
    }

    // Convert slot to row
    public static int getRow(int slot) {
        return (slot - 1) / 3;
    }

    // Convert slot to column
    public static int getCol(int slot) {
        return (slot - 1) % 3;
    }
}