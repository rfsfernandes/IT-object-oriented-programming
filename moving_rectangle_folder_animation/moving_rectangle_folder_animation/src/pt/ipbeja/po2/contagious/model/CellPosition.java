package pt.ipbeja.po2.contagious.model;

import java.util.Objects;

public class CellPosition {
    private int line;
    private int col;

    public CellPosition(int line, int col) {
        this.line = line;
        this.col = col;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPosition cellPosition = (CellPosition) o;
        return line == cellPosition.line &&
                col == cellPosition.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, col);
    }

    public CellPosition move(int dx, int dy) {
        return new CellPosition(this.line + dy, this.col + dx);
    }

    public boolean isInside(int nLines, int nCols) {
        return 0 <= this.line && this.line < nLines && 0 <= this.col && this.col < nCols;
    }
}
