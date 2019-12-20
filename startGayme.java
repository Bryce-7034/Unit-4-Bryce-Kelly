import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.io.IOException;


public class startGayme extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("./ZombieDieStartScreen.fxml"));
        scene = new Scene(menu);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
