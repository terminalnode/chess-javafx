package se.newton.sysjg3.newtonchess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.*;
import se.newton.sysjg3.newtonchess.controllers.GameWindowController;
import se.newton.sysjg3.newtonchess.controllers.GenericController;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainWindow) throws Exception {
    System.out.println("Starting Chess Application!");
    // First window must be loaded manually, other windows will use replaceWindow from HelperMethods.
    FXMLLoader loader = HelperMethods.getLoader(HelperMethods.gameWindowFXML);
    Parent root = loader.load();
    Scene scene = new Scene(root);

    // test stuff
    GameWindowController controller = loader.getController();
    List<Piece> pieces = new ArrayList<>();
    pieces.add(new Pawn(1, 0, 0, false));
    pieces.add(new Bishop(2, 1, 0, false));
    pieces.add(new King(3, 2, 0, false));
    pieces.add(new Knight(4, 3, 0, false));
    pieces.add(new Queen(5, 4, 0, false));
    pieces.add(new Rook(6, 5, 0, false));

    pieces.add(new Pawn(7, 0, 4, true));
    pieces.add(new Bishop(8, 1, 4, true));
    pieces.add(new King(9, 2, 4, true));
    pieces.add(new Knight(10, 3, 4, true));
    pieces.add(new Queen(11, 4, 4, true));
    pieces.add(new Rook(12, 5, 4, true));

    GameEntity game = new GameEntity();
    game.setPieces(pieces);
    controller.setGame(game);
    controller.postInitialization();
    // test stuff

    mainWindow.setTitle(HelperMethods.loginWindowTitle);
    mainWindow.setScene(scene);
    mainWindow.show();
    mainWindow.toFront();
  }
}
