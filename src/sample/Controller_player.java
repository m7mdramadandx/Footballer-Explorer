package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_player implements Initializable {
    public ComboBox<String> long_pass;
    public ComboBox<String> short_pass;
    public ComboBox<String> shooting;
    public ComboBox<String> speed;
    public ComboBox<String> leg;
    public ComboBox<String> jump;
    public ComboBox<String> strength;
    public ComboBox<String> heading;
    public ComboBox<String> finishing;
    public ComboBox<String> shoot_stopping;
    public ComboBox<String> dribbling;
    public ComboBox<String> positioning;
    public ComboBox<String> onetoone_situations;
    public ComboBox<String> ball_control;
    public ComboBox<String> principles_of_defence;
    public ComboBox<String> running_with_the_ball;
    public ComboBox<String> age;
    public ComboBox<String> principles_of_attack;

    private ObservableList<String> list = FXCollections.observableArrayList(null,"High", "Low");
    private ObservableList<String> leg_list = FXCollections.observableArrayList(null,"Right", "Left");
    private ObservableList<String> age_list = FXCollections.observableArrayList(null,"Above 26", "Under 26");

    public void submit(ActionEvent actionEvent) {
        String tab2 = "(assert (properties (speed " + speed.getValue() + ") (jump " + jump.getValue() + ") (leg " + leg.getValue() + ") (long_pass " + long_pass.getValue() + ")" +
                " (short_pass " + short_pass.getValue() + ") (shooting " + shooting.getValue() + ") (dribbling " + dribbling.getValue() + ") (strength " + strength.getValue() + ")" +
                " (heading " + heading.getValue() + ") (finishing " + finishing.getValue() + ") (positioning " + positioning.getValue() + ") (shoot_stopping " + shoot_stopping.getValue() + ")" +
                " (onetoone_situations " + onetoone_situations.getValue() + ") (principles_of_attack " + principles_of_attack.getValue() + ") (principles_of_defence " + principles_of_defence.getValue() + ")" +
                " (ball_control " + ball_control.getValue() + ") (running_with_the_ball " + running_with_the_ball.getValue() + ") (age " + age.getValue() + ")))";
        kbs.queryInferenceEngine(tab2);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leg.setItems(leg_list);
        age.setItems(age_list);
        long_pass.setItems(list);
        short_pass.setItems(list);
        shooting.setItems(list);
        speed.setItems(list);
        jump.setItems(list);
        strength.setItems(list);
        heading.setItems(list);
        finishing.setItems(list);
        shoot_stopping.setItems(list);
        dribbling.setItems(list);
        positioning.setItems(list);
        onetoone_situations.setItems(list);
        ball_control.setItems(list);
        principles_of_defence.setItems(list);
        running_with_the_ball.setItems(list);
        principles_of_attack.setItems(list);
    }

    public void back(MouseEvent mouseEvent) {
        Controller_main.player_stage.close();
        Main.window.show();
    }

    public void exit(MouseEvent mouseEvent) {
        Controller_main.player_stage.close();
    }
}
