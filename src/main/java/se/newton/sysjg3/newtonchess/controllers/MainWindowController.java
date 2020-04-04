package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;

public class MainWindowController extends GenericController {

  @FXML private Button logIn;
  @FXML private Button signUp;

  @FXML private TextField userNameTextField;
  @FXML private PasswordField passwordTextField;

  @FXML
  protected void initialize() {

    logIn.setOnMouseClicked(this::logInButtonClicked);

    signUp.setOnMouseClicked(this::signUpButtonClicked);
  }

  @FXML
  public void logInButtonClicked(MouseEvent mouseEvent) {
    logIn.setText(userNameTextField.getText());

    //Get the login supplied login credentials.
    String username = userNameTextField.getText().strip();
    String password = passwordTextField.getText().strip();

    PlayerEntity loginPlayer = new PlayerEntity(username, password);
    // TODO make API call and use replace scene here.
  }

  @FXML
  public void signUpButtonClicked(MouseEvent mouseEvent) {
    signUp.setText(passwordTextField.getText());
    // TODO make API call here.
  }
}
