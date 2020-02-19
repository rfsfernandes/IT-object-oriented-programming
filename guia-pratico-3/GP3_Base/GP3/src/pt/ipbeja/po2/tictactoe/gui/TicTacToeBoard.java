package pt.ipbeja.po2.tictactoe.gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import pt.ipbeja.po2.tictactoe.model.TicTacToeGame;

/**
 * Created by DiogoPM on 14/03/2018.
 */

public class TicTacToeBoard extends GridPane {

   public static final int SIZE = 3;
   private TicTacToeGame gameModel;

   public TicTacToeBoard() {
      gameModel = new TicTacToeGame(this);
      this.createBoard();
   }

   /**
    * Creates the game board with a grid of TicTacToeButtons
    */
   private void createBoard() {

      TicTacToeButtonHandler handler = new TicTacToeButtonHandler();

      for (int line = 0; line < SIZE; line++) {
         for (int col = 0; col < SIZE; col++) {
            TicTacToeButton btn = new TicTacToeButton(line, col);

            gameModel.boardData[col][line] = TicTacToeGame.Place.EMPTY;

            btn.setOnAction(handler);
            this.add(btn, col, line);
         }
      }
   }

   void playerWins(int player){

   }

   void draw(){

   }


   /**
    * Click handler for the TicTacToeButtons
    */
   class TicTacToeButtonHandler implements EventHandler<ActionEvent> {


      @Override

      public void handle(ActionEvent event) {

         TicTacToeButton button = (TicTacToeButton) event.getSource();

         gameModel.placeClicked(button.getLine(), button.getCol(), button);

      }
   }


}