package pt.ipbeja.po2.tictactoe.model;

import pt.ipbeja.po2.tictactoe.gui.TicTacToeBoard;
import pt.ipbeja.po2.tictactoe.gui.TicTacToeButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static pt.ipbeja.po2.tictactoe.gui.TicTacToeBoard.SIZE;

public class TicTacToeGame {

   public Place[][] boardData = new Place[SIZE][SIZE];

   TicTacToeBoard ticTacToeBoard;

   ArrayList<Place> moves = new ArrayList<>();

   public TicTacToeGame(TicTacToeBoard ticTacToeBoard) {
      this.ticTacToeBoard = ticTacToeBoard;
   }

   public enum Place{
      EMPTY,
      O,
      X
   }

   public void placeClicked(int line, int col, TicTacToeButton ticTacToeButton){
      if (isFree(line,col)){
         if(moves.size() == 0 ||moves.get(moves.size() - 1) == Place.O){
            boardData[line][col] = Place.X;
            moves.add(Place.X);
            ticTacToeButton.setTic();
         }else if (moves.get(moves.size() - 1) == Place.X){
            boardData[line][col] = Place.O;
            moves.add(Place.O);
            ticTacToeButton.setTac();
         }

      }

   }

   public boolean isFree(int line, int col){
      return boardData[line][col] == Place.EMPTY;
   }

}
