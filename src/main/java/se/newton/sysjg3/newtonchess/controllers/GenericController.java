package se.newton.sysjg3.newtonchess.controllers;

import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.api.entities.TokenEntity;

/**
 * A generic controller from which all of our other controllers will inherit.
 * This allows us to add fields that are shared between all controllers and
 * thus we can pass around data much easier.
 *
 * @author Alexander Rundberg
 */
public abstract class GenericController {
  TokenEntity token;
  GameEntity game;

  /**
   * Default constructor.
   * By default all the fields in the class are null, they can be set through
   * setter methods or the inheritSettings method.
   */
  GenericController() {
    token = null;
    game = null;
  }

  /**
   * Look at the settings/fields of another controller and inherit those settings.
   * Very useful for passing around things like tokens and so on that needs to
   * persist throughout the session.
   * @param controller The controller from which to inherit settings.
   */
  public void inheritSettings(GenericController controller) {
    token = controller.getToken();
    game = controller.getGame();
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
  public void setToken(TokenEntity token) {
    this.token = token;
  }

  public void setGame(GameEntity game) {
    this.game = game;
  }

  //----- Getters -----//
  public TokenEntity getToken() {
    return token;
  }

  public GameEntity getGame() {
    return game;
  }
}
