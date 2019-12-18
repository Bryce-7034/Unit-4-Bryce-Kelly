import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class ZombiePlayerUi extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("./ZombieDicePlaying.fxml"));
        scene = new Scene(menu);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Player Count");
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
