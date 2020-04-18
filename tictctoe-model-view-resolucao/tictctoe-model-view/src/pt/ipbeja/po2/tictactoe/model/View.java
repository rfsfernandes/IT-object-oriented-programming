package pt.ipbeja.po2.tictactoe.model;

import java.util.List;

public interface View {

    void disablePosition(int line, int col, int nSelected);
    void selectedPositions(List<Position> positions);
    void allLineSelected(int line);
    void updatePosition(GameModel.Place p, int line, int col);
}

