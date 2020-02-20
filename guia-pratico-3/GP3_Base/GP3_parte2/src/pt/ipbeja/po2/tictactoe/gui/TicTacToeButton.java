package pt.ipbeja.po2.tictactoe.gui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by DiogoPM on 14/03/2018.
 */

public class TicTacToeButton extends Button {

   private static final Image PLAY_EMPTY = new Image("/resources/noplayer.png");
   private static final Image PLAY_X = new Image("/resources/player1.png");
   private static final Image PLAY_O = new Image("/resources/player2.png");

   private ImageView imageView;

   int line;
   int col;

   public int getLine() {
      return line;
   }

   public void setLine(int line) {
      this.line = line;
   }

   public int getCol() {
      return col;
   }

   public void setCol(int col) {
      this.col = col;
   }

   public TicTacToeButton(int line, int col) {
      this.line = line;
      this.col = col;
      this.imageView = new ImageView(PLAY_EMPTY);
      this.setGraphic(imageView);
   }

   /**
    * Sets Tic image ('X')
    */
   public void setTic() {
      this.imageView.setImage(PLAY_X);
   }

   /**
    * Sets Tac image ('O')
    */
   public void setTac() {
      this.imageView.setImage(PLAY_O);
   }
}