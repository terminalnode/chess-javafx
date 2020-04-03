package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HelperMethods {
  // Window titles
  public static final String loginWindowTitle = "Login Window";

  // FXML paths
  public static final String loginWindowFXML = "fxml/loginWindow.fxml";

  /**
   * Retrieves a given resource.
   * @param fileName The resource we're retrieving.
   * @return A URL instance for the resource.
   */
  public static URL getRes(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResource(fileName);
  }

  public static InputStream getResAsStream(String fileName) {
    return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
  }

  /**
   * Retrieves an FXMLLoader instance preloaded with the desired FXML file.
   * @param fxmlPath Path to the FXML we're loading.
   * @return The FXMLLoader.
   */
  public static FXMLLoader getLoader(String fxmlPath) {
    return new FXMLLoader(getRes(fxmlPath));
  }

  /**
   * Replaces the scene in the current stage and passes on the GameEngine instance to the next controller.
   * @param fxmlPath Path to the FXML we're loading.
   * @param windowTitle The new title for the stage.
   * @param mouseEvent MouseEvent from which we can retrieve the stage.
   * @param oldController The old controller from which we can inherit gameEngine and clip
   * @throws IOException If the FXML can't be loaded.
   */
  static void replaceScene(String fxmlPath,
                           String windowTitle,
                           MouseEvent mouseEvent,
                           GenericController oldController) throws IOException {
    Stage stage = (Stage) ((Node) mouseEvent.getSource())
        .getScene()
        .getWindow();
    stage.setTitle(windowTitle);
    FXMLLoader loader = getLoader(fxmlPath);
    Parent root = loader.load();
    Scene scene = new Scene(root);
    GenericController controller = loader.getController();
    controller.inheritSettings(oldController);
    controller.postInitialization();
    stage.setScene(scene);
  }
}
