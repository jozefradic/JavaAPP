package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Controller {

    public Button btnLogin;
    public TextField loginField;
    public PasswordField passwordField;
    public Label lblError;
    public Button btnLogout;
    public Button btnTests;
    public CheckBox checkA;
    public CheckBox checkB;
    public CheckBox checkC;
    public CheckBox checkD;
    public Label lblCHECK;
    public Button btnSUBMIT;
    public RadioButton radioA;
    public RadioButton radioB;
    public RadioButton radioC;
    public RadioButton radioD;


    public void clickLogin(ActionEvent event) {
        String login = loginField.textProperty().get();
        String password = passwordField.textProperty().get();

        if (login.length() < 1 || password.length() < 1)
            lblError.textProperty().set("Error input try again");
        else
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Main");
                stage.show();
                stage.setMaximized(true);
                stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                stage.setFullScreen(true);
                Stage primarystage = (Stage) btnLogin.getScene().getWindow();

                primarystage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void Checkbox(ActionEvent event) {
        if(event.getSource() == checkA){
            checkB.setSelected(false);
            checkC.setSelected(false);
            checkD.setSelected(false);
        }
        else if(event.getSource() == checkB){
            checkC.setSelected(false);
            checkD.setSelected(false);
            checkA.setSelected(false);
        }
        else if(event.getSource() == checkC){
            checkB.setSelected(false);
            checkA.setSelected(false);
            checkD.setSelected(false);
        }
        else if(event.getSource() == checkD){
            checkA.setSelected(false);
            checkB.setSelected(false);
            checkC.setSelected(false);
        }

    }


    public void MenuLogout(ActionEvent event) {
        try {
            Stage primarystage = (Stage) btnLogout.getScene().getWindow();
            //Stage primarystage = (Stage) MenuLOGOUT.getScene().getWindow();
            primarystage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickTests(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TestStage.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Testing");
            stage.show();
            stage.setMaximized(true);
            stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
            stage.setFullScreen(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestSubmit(ActionEvent event) {
        boolean a = checkA.isSelected();
        boolean b = checkB.isSelected();
        boolean c = checkC.isSelected();
        boolean d = checkD.isSelected();
        if (a == true && b == false && c == false && d == false) {
            try {
                Stage primarystage = (Stage) btnSUBMIT.getScene().getWindow();
                //Stage primarystage = (Stage) MenuLOGOUT.getScene().getWindow();
                primarystage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            lblCHECK.textProperty().set("Error");
        }


    }
}