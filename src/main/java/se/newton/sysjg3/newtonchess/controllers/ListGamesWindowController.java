package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import retrofit2.Call;
import retrofit2.Response;
import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.api.retrofitservices.RetrofitHelper;

import java.io.IOException;
import java.util.List;

public class ListGamesWindowController extends GenericController {


  @FXML public VBox gameListContainer;

  private List<GameEntity> listOfGames;


  @FXML
  protected void initialize() {
    System.out.println("Initializing game's list");

  }

  @FXML
  @Override
  public void postInitialization() {
   updateGameListContainer();
  }

  @FXML
  private void updateListOfGames() {
    System.out.println("Calling API - Requesting active game's list.");
    System.out.println("Calling on token: " + token.getTokenString());
  Call<List<GameEntity>> call = RetrofitHelper
      .getGameService()
      .getAllGames(token.getTokenString());

    Response<List<GameEntity>> response;

    try
    {
      response = call.execute();
      if (response.body() != null) {
        System.out.println("Call successful");
        listOfGames = response.body();
      }
      else {
        System.out.println("Call was unsuccessful");
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
  @FXML
  private void updateGameListContainer() {
    gameListContainer.getChildren().removeAll();
    updateListOfGames();

    for (GameEntity game : listOfGames) {
      System.out.println("Adding game id: " + game.getId() + " to the list.");
      HBox gameBox = getGameBox(game);

      gameListContainer.getChildren().add(gameBox);
    }
  }

  @FXML
  private HBox getGameBox(GameEntity game) {
    String opponentsNameString = token.getPlayer().getName().equals(game.getWhitePlayer().getName()) ?
        game.getBlackPlayer().getName() : game.getWhitePlayer().getName();

    HBox gameBox = new HBox();

    Text opponentName = new Text(opponentsNameString);
    Button playButton = new Button("Play");
    playButton.setOnMouseClicked(mouseEvent -> {
      this.game = game;
      String gameWindowTitle = game.getWhitePlayer().getName().equals(token.getPlayer().getName()) ?
          game.getWhitePlayer().getName() + " vs " + game.getBlackPlayer().getName() :
          game.getBlackPlayer().getName() + " vs " + game.getWhitePlayer().getName();
      try {
        HelperMethods.replaceScene(HelperMethods.gameWindowFXML, gameWindowTitle ,mouseEvent, this);
      }
      catch (IOException ioe) {
        ioe.printStackTrace();
        System.exit(1);
      }
    });

    gameBox.getChildren().add(opponentName);
    gameBox.getChildren().add(playButton);

    return gameBox;
  }



}
