package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_main implements Initializable {

    static Stage coach_stage = new Stage(), player_stage = new Stage();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("coach.fxml"));
            Scene scene = new Scene(parent, 1100, 760);
            coach_stage.setScene(scene);
            coach_stage.setTitle("Hi Coach");
            coach_stage.setResizable(false);
            coach_stage.initStyle(StageStyle.UNDECORATED);

        } catch (Exception e) {
            System.out.println("error in coach stage " + e);
        }
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("player.fxml"));
            Scene scene = new Scene(parent, 1100, 760);
            player_stage.setScene(scene);
            player_stage.setTitle("Hi Player");
            player_stage.setResizable(false);
            player_stage.initStyle(StageStyle.UNDECORATED);
        } catch (Exception e) {
            System.out.println("error in player stage " + e);
        }
    }

    public void coach(ActionEvent actionEvent) {
        coach_stage.show();
        Main.window.close();
    }

    public void player(ActionEvent actionEvent) {
        player_stage.show();
        Main.window.close();
    }

    public void exit(MouseEvent mouseEvent) {
        Main.window.close();
    }
}
