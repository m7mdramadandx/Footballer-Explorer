package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller_coach implements Initializable {

    public AnchorPane t;
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
    public ComboBox<String> player_position;
    public TextField rule_number_delete;
    public TextField rule_number_edit;

    private ObservableList<String> list = FXCollections.observableArrayList(null, "High", "Low");
    private ObservableList<String> leg_list = FXCollections.observableArrayList(null, "Right", "Left");
    private ObservableList<String> age_list = FXCollections.observableArrayList(null, "Above 26", "Under 26");
    private ObservableList<String> player_list = FXCollections.observableArrayList(null, "Goal-Keeper", "Centre-Back", "Left-Back", "Right-Back", "Central-Midfield", "Left-Wing", "Right-Wing", "Centre-Forward");


    public void submit(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leg.setItems(leg_list);
        age.setItems(age_list);
        player_position.setItems(player_list);
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

    public void edit(ActionEvent actionEvent) {
        FileWriter fr = null;
        try {
            // ------- Update --------
            ComboBox c[] = {long_pass, short_pass, shooting, speed, leg, jump, strength, heading, finishing,
                    shoot_stopping, dribbling, positioning, onetoone_situations, ball_control, principles_of_defence,
                    running_with_the_ball, age, principles_of_attack};

            String skill = "";
            String rule_edit = rule_number_edit.getText();
            for (int i = 0; i < c.length; i++) {
                if (c[i].getValue() != null) {
                    skill += "(" + c[i].getId() + " " + c[i].getValue() + ")";
                }
            }

            String player_position_ = player_position.getValue();

            skill = skill.replaceAll(" ", " ");
            player_position_ = player_position_.replaceAll(" ", " ");

            String test1 = "    (properties " + skill + ")\n";
            String test2 = "=>\n";
            String test3 = "    (assert (categories (" + player_position_ + " yes)))(printout t \" This player is a " + player_position_ + "\" crlf))";

            File fileToBeModified = new File("E:\\FCI\\Knowledge Based System\\footballer_explorer_kbs_project\\footballer_explorer\\src\\sample\\rules.clp");
            fr = new FileWriter(fileToBeModified, true);
            String oldContent = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            int y = 0;
            while (line != null) {

                if (line.equals("(defrule rule_" + rule_edit)) {
                    line = reader.readLine();
                    oldContent = oldContent + "(defrule rule_" + rule_edit + "\n" + test1 + System.lineSeparator();

                    line = reader.readLine();
                    oldContent = oldContent + test2 + System.lineSeparator();

                    line = reader.readLine();
                    oldContent = oldContent + test3 + System.lineSeparator();
                    line = reader.readLine();

                } else {

                    oldContent = oldContent + line + System.lineSeparator();
                    y++;
                    line = reader.readLine();
                }
            }
            FileWriter fr2 = new FileWriter(fileToBeModified);
            fr2.close();
            fr.write(oldContent);
            reader.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

    public void delete(ActionEvent actionEvent) {
        // ------ Delete ------
        try {
            File fileToBeModified = new File("E:\\FCI\\Knowledge Based System\\footballer_explorer_kbs_project\\footballer_explorer\\src\\sample\\rules.clp");
            FileWriter fr = new FileWriter(fileToBeModified, true);
            String oldContent = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();

            String test = "(defrule rule_" + rule_number_delete.getText();
            int n = Integer.parseInt(rule_number_delete.getText());
            n++;
            int y = 0;
            while (line != null) {

                if (line.equals(test)) {
                    line = reader.readLine();
                    for (int i = 0; i < 5; i++) {
                        if (line.equals("(defrule rule_" + n) || line.equals("(run)")) {
                            break;
                        } else {
                            line = reader.readLine();
                        }
                    }

                } else {

                    System.out.println(y + ">> " + oldContent);
                    oldContent = oldContent + line + System.lineSeparator();
                    y++;
                    line = reader.readLine();
                }
            }
            FileWriter fr2 = new FileWriter(fileToBeModified);
            fr2.close();
            System.out.println("oldContent >> " + oldContent);
            fr.write(oldContent);
            reader.close();
            fr.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }


    }

    public void insert(ActionEvent actionEvent) {
        try {

            ComboBox c[] = {long_pass, short_pass, shooting, speed, leg, jump, strength, heading, finishing,
                    shoot_stopping, dribbling, positioning, onetoone_situations, ball_control, principles_of_defence,
                    running_with_the_ball, age, principles_of_attack};
            String s = "(defrule rule_3\n"
                    + "    (properties ";

            for (int i = 0; i < c.length; i++) {
                if (c[i].getValue() != null) {
                    s = s + "(" + c[i].getId() + " " + c[i].getValue() + ")";
                }
            }
            s = s + ")\n" +
                    "=>\n"
                    + "    (assert (categories (" + player_position.getValue() + " yes)))(printout t \"This player is a " + player_position.getValue() + "\" crlf))";
            System.out.println(s);

            File file = new File("E:\\FCI\\Knowledge Based System\\footballer_explorer_kbs_project\\footballer_explorer\\src\\sample\\rules.clp");
            FileWriter fr = new FileWriter(file, true);
            fr.write(s);
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void back(MouseEvent mouseEvent) {
        Controller_main.coach_stage.close();
        Main.window.show();
    }

    public void exit(MouseEvent mouseEvent) {
        Controller_main.coach_stage.close();
    }
}
