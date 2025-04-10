/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package shopease;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button loginButton;
    @FXML
    private Label label1;
    @FXML
    private TextField textUsername;
    @FXML
    private TextField textPassword;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == loginButton) {
            String username = textUsername.getText();
            String password = textPassword.getText(); // Corrected from textUsername.getText() to textPassword.getText()

            if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("1234")) {
                System.out.println("Login Successful!");

                // Close the login window
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                // Open the dashboard window
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
            } else {
                System.out.println("Wrong Username or Password!");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
