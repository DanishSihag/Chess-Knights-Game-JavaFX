package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

/**
 * Creates a class that controls when the Scene should be switched after the initial scene.
 */
public class gameSceneController {

    private Stage stage;

    @FXML
    public TextField playerName;

    /**
     *{@return true if the player has not entered a name.}
     */
    public boolean checkIfPlayerNameNull(){
        var alert = new Alert(Alert.AlertType.INFORMATION);
        if (playerName.getText().isEmpty()) {
            alert.setContentText("Please Enter Your Name!");
            alert.showAndWait();
            Logger.error("Player Text Field is empty!");
            return true;
        }
        return false;
    }

    public void switchSceneAfterPlayerName(ActionEvent event) throws IOException {

        if (checkIfPlayerNameNull() == false) {

            Parent root = FXMLLoader.load(getClass().getResource("/FXML Files/chessBoard.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Logger.debug("Player name registered.");
            Logger.debug("2nd Scene initialized.");
        }
    }
}
