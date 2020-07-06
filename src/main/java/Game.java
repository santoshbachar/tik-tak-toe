import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.newGame();
        char user1 = 'X', user2 = 'O';

        int moves = 0;
        int maxMoves = 9;

        boolean someoneWins = false;
        boolean userTurns = true;

        run:
        while (moves < maxMoves) {
            int row, column;
            char xo_value;
            Scanner scan = new Scanner(System.in);

            if(userTurns) {
                xo_value = 'X';
            } else {
                xo_value = 'O';
            }
            System.out.println("User " + xo_value + " turn");
            userTurns = !userTurns;

            System.out.println("Enter row: ");
            row = scan.nextInt();
            System.out.println("Enter column: ");
            column = scan.nextInt();
            switch (ttt.mark(row, column, xo_value)) {
                case GAME_IN_PROGRESS:
                    System.out.println("Game in Progress...");
                    break;
                case INVALID_GRID:
                    System.out.println("Invalid Grid. Watch your moves.");
                    moves--;
                    break;
                case X_WINS:
                case O_WINS:
                    System.out.println(xo_value + " Wins");
                    someoneWins = true;
                    break run;
            }
            moves++;
            ttt.showBoard();
        }

        if (someoneWins) {
            System.out.println("Someone wins by " + (maxMoves - moves) + " moves");
        } else {
            System.out.println("It's a Draw");
        }
    }
}
