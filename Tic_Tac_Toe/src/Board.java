public class Board {
    private char board[][];
    private int size;
    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for(int i=0 ; i<size ; i++) {
            for(int j=0 ; j<size ; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for(int i=0 ; i<size ; i++) {
            for(int j=0 ; j<size ; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
