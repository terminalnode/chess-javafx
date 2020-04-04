package se.newton.sysjg3.newtonchess.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.apache.commons.io.input.BoundedInputStream;

import javafx.scene.input.MouseEvent;

public class MainWindowController extends GenericController {

  @FXML private Button logIn;
  @FXML private Button signUp;

  @FXML
  protected void initialize() {

    logIn.setOnMouseClicked(this::logInButtonClicked);

    signUp.setOnMouseClicked(this::signUpButtonClicked);
  }

  @FXML
  public void logInButtonClicked(MouseEvent mouseEvent) {
    logIn.setText("Clicked!");
    // TODO make API call and use replace scene here.
  }

  @FXML
  public void signUpButtonClicked(MouseEvent mouseEvent) {
    signUp.setText("Clicked!");
    // TODO make API call here.
  }
}
