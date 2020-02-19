package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

import java.util.Optional;


public class TicTacToeBoard extends GridPane {
   public static final int SIZE = 3;
   public static boolean isClicked = false;
   public static int clicked = 0;

   public TicTacToeBoard() {

      this.createBoard();
   }

   private void createBoard() {
      for (int line = 0; line < SIZE; line++) {
         for (int col = 0; col < SIZE; col++) {
            TicTacToeButton button = new TicTacToeButton(this::showAlert);
            this.add(button, col, line);

         }
      }
   }

   public void showAlert() {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("GAME IS OVER!");
      alert.setContentText("Do you want to play again?");
      alert.setResult(ButtonType.OK);
      Optional<ButtonType> result = alert.showAndWait();

      if (result.isPresent()) {

         if (result.get() == ButtonType.OK) {
            isClicked = false;
            clicked = 0;
            createBoard();
         }

      }

   }

}
