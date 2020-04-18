package pt.ipbeja.po2.tictactoe.model;

public class Position {
    private int line;
    private int col;

    public Position(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public int getLine() {
        return this.line;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public String toString() {
        return "(" + line + ", " + col + ")";
    }
}
