import java.util.Scanner;

class TicTacToe {

    static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    static void placeMove(int pos, char symbol) {
        int row = 0, col = 0;

        switch (pos) {
            case 1 -> { row = 0; col = 0; }
            case 2 -> { row = 0; col = 2; }
            case 3 -> { row = 0; col = 4; }
            case 4 -> { row = 2; col = 0; }
            case 5 -> { row = 2; col = 2; }
            case 6 -> { row = 2; col = 4; }
            case 7 -> { row = 4; col = 0; }
            case 8 -> { row = 4; col = 2; }
            case 9 -> { row = 4; col = 4; }
        }

        if (board[row][col] == ' ') {
            board[row][col] = symbol;
        } else {
            System.out.println("Position already taken, try again.");
        }
    }

    static boolean checkWinner(char symbol) {
        // Rows
        for (int i = 0; i < 5; i += 2)
            if (board[i][0] == symbol && board[i][2] == symbol && board[i][4] == symbol) return true;

        // Columns
        for (int i = 0; i < 5; i += 2)
            if (board[0][i] == symbol && board[2][i] == symbol && board[4][i] == symbol) return true;

        // Diagonals
        if (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) return true;
        if (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol) return true;

        return false;
    }

    static boolean isFull() {
        for (int i = 0; i < 5; i += 2)
            for (int j = 0; j < 5; j += 2)
                if (board[i][j] == ' ') return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char currentPlayer = 'X';

        System.out.println("Tic-Tac-Toe Game");
        printBoard();

        while (true) {
            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            int pos = sc.nextInt();

            placeMove(pos, currentPlayer);
            printBoard();

            if (checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}
