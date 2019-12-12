import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

public class ZombiePlayerPane {

    @FXML
    private CheckBox onePlayer;

    @FXML
    private CheckBox twoPlayer;

    @FXML
    NumberOfPlayers singlePlayer(ActionEvent event) {
        NumberOfPlayers num = new NumberOfPlayers(1);
        return num;
    }

    @FXML
    NumberOfPlayers multiplayer(ActionEvent event) {
        NumberOfPlayers num = new NumberOfPlayers(2);
        return num;
    }


}
