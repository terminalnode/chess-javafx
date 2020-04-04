package se.newton.sysjg3.newtonchess.chesscomponents;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;
import se.newton.sysjg3.newtonchess.controllers.GameWindowController;

import java.util.List;

// TODO: Deselect piece if same square is clicked twice.
// TODO: Mark selected square in some fashion.
// TODO: Implement API call.

/**
 * A clickhandler that's placed on the VBoxes contained in the squares, it checks if
 * moves are legal and makes API calls to try and make them.
 */
public class SquareClickHandler implements EventHandler<MouseEvent> {
  private Square mySquare;
  private GameWindowController controller;
  private int xHere, yHere;


  public SquareClickHandler(Square yourSquare) {
    mySquare = yourSquare;
  }

  @Override
  public void handle(MouseEvent event) {
    Piece pieceHere = mySquare.getPiece();
    Piece selectedPiece = mySquare.getParent().getSelectedPiece();
    System.out.println(String.format("Hello, I'm (%s,%s) and I contain %s.", xHere, yHere, pieceHere));

    // If neither this nor the last clicked box contained a piece, we're not interested.
    if (pieceHere == null && selectedPiece == null) {
      // Do nothing
      return;
    }

    // Both squares are not null, so we will try to carry out some kind of action
    if (pieceHere != null && selectedPiece == null) {
      selectThisSquare();

    } else {
      if (checkIfMoveIsLegal()) {
        if (tryToMakeApiMove()) {
          moveThePieceLocally();
          return;
        }
      }

      // Move was not legal
      selectUsIfWeHaveAPiece();
    }
  }

  /**
   * This square contains a piece, but the previously clicked one does not.
   * So we select this one.
   */
  private void selectThisSquare() {
    Piece thisPiece = mySquare.getPiece();
    controller.setSelectedPiece(thisPiece);
    controller.setSelectedX(thisPiece.getX());
    controller.setSelectedY(thisPiece.getY());

    // Sanity check
    System.out.println(String.format(
        "Selected square is (%s,%s) %s",
        thisPiece,
        thisPiece.getX(),
        thisPiece.getY()
    ));
  }

  /**
   * There was a piece on the previous square, lets see if it can move here.
   * @return Boolean indicating whether the move is possible
   */
  private boolean checkIfMoveIsLegal() {
    Piece selectedPiece = controller.getSelectedPiece();
    List<int[]> selectedMoves = selectedPiece.getMoves(controller.getGame().getPieces());

    for (int[] move : selectedMoves) {
      if (move[0] == xHere && move[1] == yHere) {
        System.out.println("Move is legal.");
        return true;
      }
    }
    System.out.println("Move is NOT legal.");
    return false;
  }

  /**
   * We think that the attempted move is legal, so we will try sending it to the
   * API and see if it is accepted.
   * @return Boolean indicating whether the move was accepted by the API.
   */
  private boolean tryToMakeApiMove() {
    return true;
  }

  /**
   * If the move was accepted by the API, we will move the piece's image to the
   * correct location.
   */
  private void moveThePieceLocally() {
    //int[] positionHere = new int[]{ mySquare.getX(), mySquare.getY() };
    //int[] positionThere = new int[]{ gwc.getSelectedX(), gwc.getSelectedY() };
    Piece pieceHere = mySquare.getPiece();
    Piece pieceThere = controller.getSelectedPiece();

    // Remove the piece here from the GameWindowController and this square.
    System.out.println("Pieces on board before move: " + controller.getGame().getPieces().size());
    controller.getGame()
       .getPieces()
       .remove(pieceHere);
    mySquare.removePiece();
    mySquare.setPiece(pieceThere);

    // Set the piece's new position
    pieceThere.setX(xHere);
    pieceThere.setY(yHere);

    // Unset the GameWindowControllers selected* variables.
    controller.setSelectedX(-1);
    controller.setSelectedY(-1);
    controller.setSelectedPiece(null);
    System.out.println("Pieces on board after move: " + controller.getGame().getPieces().size());
  }

  /**
   * Runs when an attempted move wasn't legal. If this square contains a piece
   * that piece will now be selected, if it does not then we will set selectedX,
   * selectedY and selectedPiece in the controller to -1, -1 and null respectively
   * to indicate that nothing is currently selected.
   */
  private void selectUsIfWeHaveAPiece() {
    Piece pieceHere = mySquare.getPiece();
    if (pieceHere != null) {
      controller.setSelectedX(xHere);
      controller.setSelectedY(yHere);
      controller.setSelectedPiece(pieceHere);
    }
  }

  //----- Setters -----//
  // This class doesn't really have any getters.
  public void setController(GameWindowController controller) {
    this.controller = controller;
  }

  public void setxHere(int xHere) {
    this.xHere = xHere;
  }

  public void setyHere(int yHere) {
    this.yHere = yHere;
  }
}
