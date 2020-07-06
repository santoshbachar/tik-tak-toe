public class TicTacToe {
    private char[][] board = new char[3][3];

    public void newGame() {
        board[0][0] = '-';
        board[0][1] = '-';
        board[0][2] = '-';

        board[1][0] = '-';
        board[1][1] = '-';
        board[1][2] = '-';

        board[2][0] = '-';
        board[2][1] = '-';
        board[2][2] = '-';
    }

    public Status mark(int row, int column, char input) {
        if (row == 0 || row > 3) {
            return Status.INVALID_GRID;
        }
        if (column == 0 || column > 3) {
            return Status.INVALID_GRID;
        }

//        if (this.board[--row][--column] == 'X' || this.board[--row][--column] == 'O') {
//            return Status.INVALID_GRID;
//        }

        this.board[--row][--column] = input;

        if (this.checkHorizontal(row, input)) {
            if (input == 'O') {
                return Status.O_WINS;
            }
            return Status.X_WINS;
        }
        if (this.checkVertical(column, input)) {
            return Status.X_WINS;
        }
        if (this.checkCrossToRight(input)) {
            return Status.X_WINS;
        }
//        if (this.checkCrossToLeft(input) ) {
//            return Status.X_WINS;
//        }


        return Status.GAME_IN_PROGRESS;
    }

    public boolean checkHorizontal(int row, char input) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] != input) {
                System.out.println("My row is: " + row);
                System.out.println(board[i][row] + " against " + input);
                return false;
            }
        }
        return true;
    }

    public boolean checkVertical(int column, char input) {
        for (int i = 0; i < 3; i++) {
            if (board[i][column] != input) {
                System.out.println("My column is: " + column);
                System.out.println(board[i][column] + " against " + input);
                return false;
            }
        }
        return true;
    }

    public boolean checkCrossToRight(char input) {
        for (int i = 0; i < 3; i++) {
            if (board[i][i] != input) {
                // System.out.println("My column is: " + column);
                // System.out.println(board[i][column] + " against " + input);
                return false;
            }
        }
        return true;
    }

    public boolean checkCrossToLeft(char input) {
        for (int i = 3; i < 0; --i) {
            if (board[i][i] != input) {
                // System.out.println("My column is: " + column);
                // System.out.println(board[i][column] + " against " + input);
                return false;
            }
        }
        return true;
    }

    public void showBoard() {
        System.out.println("Current Board Status");

        for (int i = 0; i < 3; i++) {
            System.out.print(board[0][i]);
            if (i < 2) {
                System.out.print('|');
            }
        }
        System.out.print("\n-----\n");

        for (int i = 0; i < 3; i++) {
            System.out.print(board[1][i]);
            if (i < 2) {
                System.out.print('|');
            }
        }
        System.out.print("\n-----\n");

        for (int i = 0; i < 3; i++) {
            System.out.print(board[2][i]);
            if (i < 2) {
                System.out.print('|');
            }
        }
        System.out.println();
    }

}
