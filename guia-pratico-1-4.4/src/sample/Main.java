package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox vBox = new VBox();

        HBox hboxLabels = new HBox();
        hboxLabels.setMinWidth(200);

        Label label = new Label("0");
        label.setMinWidth(100);
        Label label2 = new Label("0");
        label2.setMinWidth(100);
        hboxLabels.setAlignment(Pos.CENTER);
        hboxLabels.getChildren().addAll(label,label2);


        HBox hboxButtons = new HBox();
        hboxButtons.setMinWidth(200);

        Button button = new Button("Increment label 1");
        button.minWidth(100);
        button.setOnAction(new ButtonHandler(label));

        Button button2 = new Button("Increment label 2");
        button2.minWidth(100);
        button2.setOnAction(new ButtonHandler(label2));
        hboxButtons.getChildren().addAll(button,button2);

        vBox.getChildren().addAll(hboxButtons,hboxLabels);

        Scene scene = new Scene(vBox,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ButtonHandler implements EventHandler<ActionEvent> {
        private Label label;

        public ButtonHandler(Label label) {
            this.label = label;
        }

        @Override
        public void handle(ActionEvent event) {

            int number = Integer.parseInt(label.getText()) + 1;

            label.setText(String.valueOf(number));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
