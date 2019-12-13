import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;

import java.io.IOException;

public class ZombiePlayerPane {

    @FXML
    private Button OnePlayer;

    @FXML
    private Button TwoPlayer;

    @FXML
    void singlePlayer(ActionEvent event) throws IOException
    {
        Parent single = FXMLLoader.load(getClass().getResource("./SinglePlayerPane.fxml"));
        OnePlayer.getScene().setRoot(single);
    }

    @FXML
    void multiplayer(ActionEvent event) throws IOException{
        Parent single = FXMLLoader.load(getClass().getResource("./MultiPlayerPane.fxml"));
        TwoPlayer.getScene().setRoot(single);
    }


}
