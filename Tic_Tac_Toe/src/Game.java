import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1, player2;
    private boolean turn;
    private char[][] table;
    private int size;
    private int totTurns;
    private boolean[][] vis;
    private char currentSymbol;
    private Scanner sc;

    public Game(Board board, Player player1, Player player2, Scanner sc) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.sc = sc;
        //Player1 - true, Player2 - false
        turn = true;
        table = board.getBoard();
        size = board.getSize();
        //maximumTurns = size*size
        totTurns = 0;
        vis = new boolean[size][size];
        for(int i=0 ; i<size ; i++) {
            for(int j=0 ; j<size ; j++) {
                vis[i][j] = false;
            }
        }
    }

    @SuppressWarnings("unused")
    public void gameLogic() {
        while(true) {
            board.printBoard();
            if(turn) currentSymbol = player1.getSymbol();
            else currentSymbol = player2.getSymbol();
            System.out.println("Enter the position for the symbol " + currentSymbol + " : ");
            System.out.print("Row (0 - " + (size-1) + ") : ");
            int row = sc.nextInt();
            while(row<0 || row>=size) {
                System.out.println("Enter the valid Row!!");
                System.out.print("Row (0 - " + (size-1) + ") : ");
                row = sc.nextInt();
            }
            System.out.print("Column (0 - " + (size-1) + ") : ");
            int col = sc.nextInt();
            while(col<0 || col>=size) {
                System.out.println("Enter the valid Column!!");
                System.out.print("Column (0 - " + (size-1) + ") : ");
                col = sc.nextInt();
            }
            String outcome = play(row, col);
            if(outcome != null) {
                if(outcome.equals("Invalid")) {
                    System.out.println("The entered row or column is already filled!! \nEnter another position.");
                }
                else {
                    System.out.println(outcome);
                    break;
                }
            }
        }
    }

    public String play(int row, int col) {
        if(vis[row][col]) return "Invalid";
        totTurns++;
        vis[row][col] = true;
        table[row][col] = currentSymbol;
        if(totTurns>=2*size-1 && (isRow(row, currentSymbol) || isColumn(col, currentSymbol) 
            || (row == col && (isDiagonal(currentSymbol) || isAntiDiagonal(currentSymbol))))) {
                if(turn) return "Winner is " + player1.getName();
                else return "Winner is " + player2.getName();
        }
        if(isFull(totTurns)) {
            return "Draw";
        }
        turn = !turn;
        return null;
    }

    private boolean isRow(int row, char symbol) {
        for(int i=0 ; i<size ; i++) {
            if(table[row][i] != symbol) return false;
        }
        return true;
    }

    private boolean isColumn(int col, char symbol) {
        for(int i=0 ; i<size ; i++) {
            if(table[i][col] != symbol) return false;
        }
        return true;
    }

    private boolean isDiagonal(char symbol) {
        int r = 0, c = 0;
        while(r<size && c<size) {
            if(table[r][c] != symbol) return false;
            r++;
            c++;
        }
        return true;
    }

    private boolean isAntiDiagonal(char symbol) {
        int r = 0, c = size-1;
        while(r<size && c>=0) {
            if(table[r][c] != symbol) return false;
            r++;
            c--;
        }
        return true;
    }

    private boolean isFull(int totTurns) {
        if(totTurns == size*size) return true;
        return false;
    }
}
