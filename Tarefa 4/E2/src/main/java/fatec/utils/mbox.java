package fatec.utils;

import java.util.Optional;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class mbox {

    public static void ShowMessageBox(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void ShowGifMessageBox(String title, String gifPath) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        
        VBox vbox = new VBox();
        Image image = new Image(gifPath);
        ImageView imageView = new ImageView(image);
        
        vbox.getChildren().add(imageView);
        
        Scene scene = new Scene(vbox);
        
        // Ajustar o tamanho da janela baseado no tamanho do GIF
        stage.setScene(scene);
        stage.setWidth(image.getWidth());
        stage.setHeight(image.getHeight());
        stage.show();
    }
    
    public static String ShowInputMessageBox(String title, String message) {
        Optional<String> result = ShowInputDialog(title, message);
        
        return result.orElse(null);
    }

    private static Optional<String> ShowInputDialog(String title, String message) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);
        
        return dialog.showAndWait();
    }
}
