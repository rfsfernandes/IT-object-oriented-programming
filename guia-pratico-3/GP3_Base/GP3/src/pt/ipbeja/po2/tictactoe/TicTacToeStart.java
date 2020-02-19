package pt.ipbeja.po2.tictactoe;
/**
 * Created by DiogoPM on 14/03/2018.
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipbeja.po2.tictactoe.gui.TicTacToeBoard;

public class TicTacToeStart extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) {

      TicTacToeBoard board = new TicTacToeBoard();
      Scene scene = new Scene(board);
      primaryStage.setScene(scene);
      primaryStage.show();

   }
}
