import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Character>> board;
    private int size;
    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for(int i=0 ; i<size ; i++) {
            ArrayList<Character> temp = new ArrayList<>();
            for(int j=0 ; j<size ; j++) {
                temp.add('_');
            }
            board.add(temp);
        }
    }

    public void printBoard() {
        for(int i=0 ; i<size ; i++) {
            for(int j=0 ; j<size ; j++) {
                System.out.print(board.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
