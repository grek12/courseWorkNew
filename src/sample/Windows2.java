package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Windows2 {
    public Windows2() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Риелторское агентство");
        stage.setScene(new Scene(root, 750, 450));
        //stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
