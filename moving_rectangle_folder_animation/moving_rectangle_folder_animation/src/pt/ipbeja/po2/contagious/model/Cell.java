package pt.ipbeja.po2.contagious.model;

import pt.ipbeja.po2.contagious.gui.ContagiousBoard;
import pt.ipbeja.po2.contagious.gui.WorldBoard;

public class Cell {
    private CellPosition cellPosition;
    private int dx;
    private int dy;

    public Cell(CellPosition cellPosition) {
        this.cellPosition = cellPosition;
    }

    public CellPosition cellPosition() {
        return cellPosition;
    }

    public boolean randomMove() {
        final int[] v = {-1, 0, 1};
        this.dx = v[WorldWithOneCell.rand.nextInt(3)];
        this.dy = v[WorldWithOneCell.rand.nextInt(3)];
        if (dx == 0 && dy == 0) {// to force a move
            dx = 1;
        }

        int cols = ContagiousBoard.world.nCols();

        int lines = ContagiousBoard.world.nLines();

        int x_position = this.cellPosition.getCol() + dx;
        int y_position = this.cellPosition.getLine() + dy;

        if(x_position + WorldBoard.CELL_SIZE > cols){
            x_position = cols - WorldBoard.CELL_SIZE;
        }else if(x_position < 0){
            x_position = 0;
        }

        if(y_position + WorldBoard.CELL_SIZE > lines){
            y_position = lines - WorldBoard.CELL_SIZE;
        }else if(y_position < 0){
            y_position = 0;
        }

        this.cellPosition = new CellPosition(
                y_position,
                x_position);

        return true;
    }

    public int dx() {
        return this.dx;
    }

    public int dy() {
        return this.dy;
    }
}
