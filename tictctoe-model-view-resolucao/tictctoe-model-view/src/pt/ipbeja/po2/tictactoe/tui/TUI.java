package pt.ipbeja.po2.tictactoe.tui;

import pt.ipbeja.po2.tictactoe.model.GameModel;
import pt.ipbeja.po2.tictactoe.model.Position;
import pt.ipbeja.po2.tictactoe.model.View;

import java.util.List;
import java.util.Scanner;

public class TUI implements View {

    private final GameModel gameModel;

    public TUI()
    {

        this.gameModel =  new GameModel( this );

    }

    public void disablePosition(int line, int col, int nSelected) {
        System.out.println("Disable position (" +
                            line + "), (" + col + ")");
    }

    @Override
    public void selectedPositions(List<Position> positions) {
        String s = "";
        for(Position pos : positions) s += pos;
        System.out.println(s);
    }

    @Override
    public void allLineSelected(int line) {
        System.out.println("All line " + line + " is selected");
    }

    @Override
    public void updatePosition(GameModel.Place p, int line, int col) {
        System.out.println("Player " + p + " - " + line + ", " + col);
    }

    private int counter;

    private void askValue()
    {
        do {
            System.out.println("Player " + this.gameModel.currentPlayer + " turn:");
            Scanner s = new Scanner(System.in);
            int line = s.nextInt();
            int col = s.nextInt();

            this.gameModel.selectedPosition(line, col);
            counter++;
        } while (counter < 9);
        this.gameModel.exit();
    }


    public static void main(String[] args)
    {
        TUI tui = new TUI();
        tui.askValue();

    }
}
