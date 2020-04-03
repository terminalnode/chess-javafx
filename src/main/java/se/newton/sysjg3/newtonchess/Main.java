package se.newton.sysjg3.newtonchess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainWindow) throws Exception {
    // First window must be loaded manually, other windows will use replaceWindow from HelperMethods.
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.loginWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);

    mainWindow.setTitle(HelperMethods.loginWindowTitle);
    mainWindow.setScene(scene);
    mainWindow.show();
    mainWindow.toFront();
  }
}
