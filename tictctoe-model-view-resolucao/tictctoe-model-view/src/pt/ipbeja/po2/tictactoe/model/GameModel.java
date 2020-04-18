package pt.ipbeja.po2.tictactoe.model;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private View view;
    private List<Position> positions;
    public Place[][] grid; // in the real game should NOT be boolean as we will need three values: empty, X and O
    public Place currentPlayer = Place.X;

    public enum Place {
        O,
        X,
        EMPTY
    }

    public GameModel(View board)
    {
        this.view = board;
        this.positions = new ArrayList<>();
        this.grid = new Place[3][3];
    }

    public void selectedPosition(int line, int col) {
        this.grid[line][col] = currentPlayer;

        switch (currentPlayer){
            case X:
                currentPlayer = Place.O;
                break;
            case O:
                currentPlayer = Place.X;
                break;
        }

        this.positions.add(new Position(line, col));
        view.disablePosition(line, col, this.positions.size());
        if(this.allLineSelected(line))
        {
            this.view.allLineSelected(line);
        }

        view.updatePosition(currentPlayer, line, col);

    }

    private boolean allLineSelected(int line) {
        return this.grid[line][0] != null && this.grid[line][1] !=  null && this.grid[line][2] != null;
    }

    public void exit() {
        this.view.selectedPositions(this.positions);
        System.exit(0);
    }
}




