package se.newton.sysjg3.newtonchess.controllers;

import javafx.scene.Scene;

/**
 * A generic controller from which all of our other controllers will inherit.
 * This allows us to add fields that are shared between all controllers and
 * thus we can pass around data much easier.
 *
 * @author Alexander Rundberg:w
 */
public abstract class GenericController {
  Scene scene;

  GenericController() {
    scene = null;
  }

  /**
   * Look at the settings/fields of another controller and inherit those settings.
   * Very useful for passing around things like tokens and so on that needs to
   * persist throughout the session.
   * @param controller
   */
  public void inheritSettings(GenericController controller) {
    scene = controller.getScene();
  }

  /**
   * This method is overridden by controllers that need to run something after their
   * regular initialization has completed. It is called whenever we replace a scene
   * with another one, and if a class hasn't overridden it it does nothing.
   */
  public void postInitialization() {
    // Does nothing by default
  }

  //----- Setters -----//
  public void setScene(Scene scene) {
    this.scene = scene;
  }

  //----- Getters -----//

  public Scene getScene() {
    return scene;
  }
}
