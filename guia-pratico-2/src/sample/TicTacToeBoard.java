package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Optional;


public class TicTacToeBoard extends GridPane {
   public static final int SIZE = 3;
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
            clicked = 0;
            createBoard();
         }

      }

   }

}
