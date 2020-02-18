package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button button = new Button("Button 1");
        Button button2 = new Button("Button 2");

        ButtonHandler buttonHandler = new ButtonHandler();

        button.setOnAction(buttonHandler);
        button2.setOnAction(buttonHandler);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(button,button2);

        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You pressed " + ((Button) event.getSource()).getText() + "");
            alert.showAndWait();
        }
    }

}
