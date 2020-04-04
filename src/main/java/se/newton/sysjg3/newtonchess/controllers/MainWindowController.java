package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
import se.newton.sysjg3.newtonchess.api.ApiLogin;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;
import se.newton.sysjg3.newtonchess.api.entities.TokenEntity;

public class MainWindowController extends GenericController {

  @FXML private Button logInButton;
  @FXML private Button signUpButton;

  @FXML private TextField userNameTextField;
  @FXML private PasswordField passwordTextField;

  @FXML
  protected void initialize() {

    logInButton.setOnMouseClicked(this::logInButtonClicked);

    signUpButton.setOnMouseClicked(this::signUpButtonClicked);
  }

  @FXML
  public void logInButtonClicked(MouseEvent mouseEvent) {
    logInButton.setText(userNameTextField.getText());

    //Get the login supplied login credentials.
    String username = userNameTextField.getText().strip();
    String password = passwordTextField.getText().strip();

    PlayerEntity loginPlayer = new PlayerEntity(username, password);

    // Create the user we will send to the API
    PlayerEntity newPlayer = new PlayerEntity(username, password);
    Call<TokenEntity> call = ApiLogin.login(newPlayer);

    // Make API call
    call.enqueue(new Callback<TokenEntity>() {
      @Override
      @EverythingIsNonNull
      public void onResponse(Call<TokenEntity> call, Response<TokenEntity> response) {
        if (response.code() == 200) {
          handleSuccessfulLogin(response, );
        } else {
          handleUnsuccessfulLogin(response, );
        }
        enableButtons();
      }

      @Override
      public void onFailure(Call<TokenEntity> call, Throwable t) {

      }


      // TODO make API call and use replace scene here.
    }
  }

  @FXML
  public void signUpButtonClicked(MouseEvent mouseEvent) {
    signUpButton.setText(passwordTextField.getText());
    // TODO make API call here.
  }

  private void disableButtons() {
    signUpButton.setDisable(true);
    logInButton.setDisable(true);

  }

  private void enableButtons() {
    signUpButton.setDisable(false);
    logInButton.setDisable(false);

  }


}
