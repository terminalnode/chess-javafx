package se.newton.sysjg3.newtonchess.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import se.newton.sysjg3.newtonchess.chesscomponents.Square;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;

/**
 * The class that holds the board and lets you play the game.
 * @author Alexander Rundberg
 */
public class GameWindowController extends GenericController {
  @FXML VBox sq00, sq01, sq02, sq03, sq04, sq05, sq06, sq07;
  @FXML VBox sq10, sq11, sq12, sq13, sq14, sq15, sq16, sq17;
  @FXML VBox sq20, sq21, sq22, sq23, sq24, sq25, sq26, sq27;
  @FXML VBox sq30, sq31, sq32, sq33, sq34, sq35, sq36, sq37;
  @FXML VBox sq40, sq41, sq42, sq43, sq44, sq45, sq46, sq47;
  @FXML VBox sq50, sq51, sq52, sq53, sq54, sq55, sq56, sq57;
  @FXML VBox sq60, sq61, sq62, sq63, sq64, sq65, sq66, sq67;
  @FXML VBox sq70, sq71, sq72, sq73, sq74, sq75, sq76, sq77;
  private Square[][] squares;
  Piece selectedPiece;
  int selectedX, selectedY;

  @FXML
  protected void initialize() {
    // Initialize lastPiece to null and selectedX/Y to -1 (nothing selected)
    selectedPiece = null;
    selectedX = -1;
    selectedY = -1;

    // Instantiate all the squares
    squares = new Square[][]{
        { new Square(sq00), new Square(sq01), new Square(sq02), new Square(sq03), new Square(sq04), new Square(sq05), new Square(sq06), new Square(sq07) },
        { new Square(sq10), new Square(sq11), new Square(sq12), new Square(sq13), new Square(sq14), new Square(sq15), new Square(sq16), new Square(sq17) },
        { new Square(sq20), new Square(sq21), new Square(sq22), new Square(sq23), new Square(sq24), new Square(sq25), new Square(sq26), new Square(sq27) },
        { new Square(sq30), new Square(sq31), new Square(sq32), new Square(sq33), new Square(sq34), new Square(sq35), new Square(sq36), new Square(sq37) },
        { new Square(sq40), new Square(sq41), new Square(sq42), new Square(sq43), new Square(sq44), new Square(sq45), new Square(sq46), new Square(sq47) },
        { new Square(sq50), new Square(sq51), new Square(sq52), new Square(sq53), new Square(sq54), new Square(sq55), new Square(sq56), new Square(sq57) },
        { new Square(sq60), new Square(sq61), new Square(sq62), new Square(sq63), new Square(sq64), new Square(sq65), new Square(sq66), new Square(sq67) },
        { new Square(sq70), new Square(sq71), new Square(sq72), new Square(sq73), new Square(sq74), new Square(sq75), new Square(sq76), new Square(sq77) }
    };

    // Loop over the squares, giving each of them a copy of the list of squares as well as a reference to self
    // Reference to self is used to coordinate things like selectedPiece, selectedX, selectedY.
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        Square sq = squares[y][x];
        sq.setAllSquares(squares);
        sq.setX(x);
        sq.setY(y);
      }
    }
  }

  @Override
  public void postInitialization() {
    // Give all the squares their corresponding pieces.
    // We actually want a null pointer exception here if the pieces are not set, that's a serious error.
    // We should inherit the game from the old controller through GenericController
    for (Piece piece : game.getPieces()) {
      int x = piece.getX();
      int y = piece.getY();
      Square sq = squares[y][x];
      sq.setPiece(piece);
      sq.setParent(this);
    }
  }

  //----- Setters -----//
  public void setSelectedPiece(Piece selectedPiece) {
    this.selectedPiece = selectedPiece;
  }

  public void setSelectedX(int selectedX) {
    this.selectedX = selectedX;
  }

  public void setSelectedY(int selectedY) {
    this.selectedY = selectedY;
  }

  //----- Getters -----//
  public Piece getSelectedPiece() {
    return selectedPiece;
  }

  public int getSelectedX() {
    return selectedX;
  }

  public int getSelectedY() {
    return selectedY;
  }
}
