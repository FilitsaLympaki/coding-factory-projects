package gr.aueb.cf.projects.project4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Project4 {

    static boolean winner = false;
    static boolean noWinner = false;
    static String[] board = new String[9];
    static boolean isPlayer1 = true;

    public static void main(String[] args) {
        System.out.println("Tic-Tac-Toe begins\n\n");

        while (!winner && !noWinner) {
            int input = getPlayerMove();
            updateBoard(input);
            checkWinner();
            checkNoWinner();

            isPlayer1 = !isPlayer1;
        }

        printBoard();
        System.out.println("\n\nTic-Tac-Toe ends");
    }

    public static int getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            printBoard();
            System.out.printf("\n%s", isPlayer1 ? "Player 1's turn (X)" : "Player 2's turn (O)\n");
            System.out.println("\nPlease choose a number between 1 and 9\n");

            try {
                input = scanner.nextInt();
                if (input < 1 || input > 9 || board[input - 1] != null) {
                    System.out.println("Try Again.\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer. Try Again.\n");
            }
        }
        return input - 1;
    }

    public static void printBoard() {
        System.out.printf("\n| %s | %s | %s |\n| %s | %s | %s |\n| %s | %s | %s |\n",
                board[0] == null ? 1 : board[0],
                board[1] == null ? 2 : board[1],
                board[2] == null ? 3 : board[2],
                board[3] == null ? 4 : board[3],
                board[4] == null ? 5 : board[4],
                board[5] == null ? 6 : board[5],
                board[6] == null ? 7 : board[6],
                board[7] == null ? 8 : board[7],
                board[8] == null ? 9 : board[8]);
    }

    public static void updateBoard(int input) {
        board[input] = isPlayer1 ? "X" : "O";
    }

    public static void checkWinner() {
        String winningComb = isPlayer1 ? "XXX" : "OOO";
        if ((board[0] + board[1] + board[2]).equals(winningComb)
                || (board[3] + board[4] + board[5]).equals(winningComb)
                || (board[6] + board[7] + board[8]).equals(winningComb)
                || (board[0] + board[3] + board[6]).equals(winningComb)
                || (board[1] + board[4] + board[7]).equals(winningComb)
                || (board[2] + board[5] + board[8]).equals(winningComb)
                || (board[0] + board[4] + board[8]).equals(winningComb)
                || (board[2] + board[4] + board[6]).equals(winningComb)) {
            winner = true;
            System.out.printf("The winner is %s", winningComb.equals("XXX") ? "Player 1" : "Player 2");
        }
    }

    public static void checkNoWinner() {
        if (board[0] != null
               && board[1] != null
               && board[2] != null
               && board[3] != null
               && board[4] != null
               && board[5] != null
               && board[6] != null
               && board[7] != null
               && board[8] != null
               && !winner) {
            noWinner = true;
            System.out.println("No winner");
        }
    }

}
