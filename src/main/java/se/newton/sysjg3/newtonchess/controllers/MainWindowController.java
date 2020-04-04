package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
import se.newton.sysjg3.newtonchess.api.ApiLogin;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;
import se.newton.sysjg3.newtonchess.api.entities.TokenEntity;

import java.io.IOException;

public class MainWindowController extends GenericController {

  @FXML private Button logInButton;
  @FXML private Button signUpButton;

  @FXML private TextField userNameTextField;
  @FXML private PasswordField passwordTextField;

  private String loginFailedWarningString = "Warning: Login Failed. Please check you Username and Password.";

  @FXML
  protected void initialize() {

    logInButton.setOnMouseClicked(this::logInButtonClicked);

    signUpButton.setOnMouseClicked(this::signUpButtonClicked);
  }

  @FXML
  public void logInButtonClicked(MouseEvent mouseEvent) {
    disableButtons();

    logInButton.setText(userNameTextField.getText());

    //Get the login supplied login credentials.
    String username = userNameTextField.getText().strip();
    String password = passwordTextField.getText().strip();


    // Create the user we will send to the API
    PlayerEntity loginPlayer = new PlayerEntity(username, password);
    Call<TokenEntity> call = ApiLogin.login(loginPlayer);


    try {
      Response<TokenEntity> response = call.execute();
      if (response.body() != null) {
          handleSuccessfulLogin(response, mouseEvent);
      }
      else {
        Alert loginFailedAlert = new Alert(Alert.AlertType.ERROR, loginFailedWarningString, ButtonType.OK);
        loginFailedAlert.showAndWait();
      }
    }
    catch (IOException ioe) {

    }
  }

  @FXML
  public void signUpButtonClicked(MouseEvent mouseEvent) {
    signUpButton.setText(passwordTextField.getText());

  }

  private void disableButtons() {
    signUpButton.setDisable(true);
    logInButton.setDisable(true);

  }

  private void enableButtons() {
    signUpButton.setDisable(false);
    logInButton.setDisable(false);

  }

 private void handleSuccessfulLogin(Response<TokenEntity> response, MouseEvent mouseEvent) {
   System.out.println("We have a succesfull response!");
    this.setToken(response.body());
    try {
      HelperMethods.replaceScene(HelperMethods.listGamesWindowFXML, HelperMethods.listGamesWindowTitle ,mouseEvent, this);
    }
    catch (IOException ioe) {

   }


  }

  private void handleUnsuccessfulLogin(Response<TokenEntity> response) {
    System.out.println("The login attempt was unseccesfull.");
  }


}
