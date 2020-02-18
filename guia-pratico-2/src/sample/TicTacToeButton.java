package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Optional;

import static sample.TicTacToeBoard.*;

public class TicTacToeButton extends Button  {
   private ButtonHandler buttonHandler;

   public TicTacToeButton(String label) throws HeadlessException {
      super(label);

   }

   public TicTacToeButton(ButtonHandler buttonHandler) throws HeadlessException {
      this.setPrefSize(60,60);
      this.setGraphic(new ImageView(new Image("/resources/noplayer.png")));
      this.setStyle("" +
              "-fx-border-color: black;");
      this.setOnAction(new ButtonHandling());
      this.buttonHandler = buttonHandler;
   }

    class ButtonHandling implements EventHandler<ActionEvent> {

      @Override
      public void handle(ActionEvent event) {
         TicTacToeButton button = (TicTacToeButton) event.getSource();
         ImageView view = new ImageView();

         if(clicked % 2 == 0){
            view = new ImageView(new Image("/resources/player1.png"));
         }else{
            view = new ImageView(new Image("/resources/player2.png"));
         }

         clicked++;
         view.autosize();
         button.setGraphic(view);
         button.setDisable(true);

         if(clicked == SIZE * SIZE){
            buttonHandler.gameEnded();
         }
      }
   }

}
