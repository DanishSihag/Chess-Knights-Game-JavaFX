package Controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

public class GameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML Files/initialScene.fxml"));
        stage.setTitle("Knights Chess Game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Logger.debug("1st Scene initialized.");
    }
}
