package fatec.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InicialController {

    @FXML
    private Button enterButton; 
    @FXML
    private void handleEnter(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fatec/views/class-view.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) enterButton.getScene().getWindow();
            Scene newScene = new Scene(root);

            currentStage.setScene(newScene);
            currentStage.setTitle("Classes");
    }
}