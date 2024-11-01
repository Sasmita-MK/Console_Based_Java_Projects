public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.symbol = symbol;
        this.name = name;
    }

    public void printPlayer() {
        System.out.println("Player Name : " + name);
        System.out.println("Player Symbol : " + symbol);
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
