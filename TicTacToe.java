import java.util.Scanner;

public class TicTacToe {

    private static final char EMPTY = '-';
    private static final char X = 'X';
    private static final char O = 'O';

    private static char[][] board;
    private static char currentPlayer;

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        board = new char[3][3];
        currentPlayer = X;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY;
            }
        }

        while (true) {
            printBoard();

            System.out.println("It is " + currentPlayer + "'s turn.");
            System.out.print("Enter a row number: ");
            int row = scanner.nextInt();
            System.out.print("Enter a column number: ");
            int column = scanner.nextInt();

            if (isValidMove(row, column)) {
                board[row][column] = currentPlayer;
                currentPlayer = currentPlayer == X ? O : X;

                if (isWinner(currentPlayer)) {
                    System.out.println(currentPlayer + " wins!");
                    break;
                }

                if (isTie()) {
                    System.out.println("The game is a tie!");
                    break;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length && board[row][column] == EMPTY;
    }

    private static boolean isWinner(char player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static boolean isTie() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
