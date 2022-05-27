package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class playerInfoSceneController {

    @FXML
    private TableView tableView;

    private Stage stage;


    @FXML
    private TableColumn<playerInfoSceneController, String> Players;

    @FXML
    private TableColumn<playerInfoSceneController, Integer> Moves;

    @FXML
    private TableColumn<playerInfoSceneController, LocalDateTime> startTime;

    @FXML
    private TableColumn<playerInfoSceneController, LocalDateTime> EndTime;

    public void openPLayerInfo(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/FXML Files/playerInfo.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
}
