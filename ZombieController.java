import com.sun.prism.shader.Solid_ImagePattern_Loader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ZombieController {

    @FXML
    private Button play;

    @FXML
    void startGame(ActionEvent event) throws IOException {
        Parent single = FXMLLoader.load(getClass().getResource("./ZombieDicePlaying.fxml"));
        play.getScene().setRoot(single);
    }

}

