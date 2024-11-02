import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Tic Tac Toe");

        System.out.print("Enter the size of the Board : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        System.out.println();
        Board board = new Board(size);

        System.out.println("Enter the Player1 details : ");
        System.out.print("Enter the name of the Player : ");
        String name = sc.nextLine();
        System.out.print("Enter the Symbol for the Player " + name + " ('X'/'O'): ");
        char symbol = sc.nextLine().charAt(0);
        symbol = Character.toUpperCase(symbol);
        while(!(symbol=='X' || symbol=='O')) {
            System.out.print("Enter the valid symbol ('X'/'O') : ");
            symbol = sc.nextLine().charAt(0);
        }
        System.out.println();
        Player player1 = new Player(name, symbol);

        System.out.println("Enter the Player2 details : ");
        System.out.print("Enter the name of the Player : ");
        name = sc.nextLine();
        if(symbol == 'X') symbol = 'O';
        else symbol = 'X';
        System.out.println();
        Player player2 = new Player(name, symbol);

        player1.printPlayer();
        System.out.println();
        player2.printPlayer();
        System.out.println();
    
        Game game = new Game(board, player1, player2, sc);
        game.gameLogic();
    }
}
