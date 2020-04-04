package se.newton.sysjg3.newtonchess.chesscomponents;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;
import se.newton.sysjg3.newtonchess.controllers.GameWindowController;

import java.util.List;

/**
 * A clickhandler that's placed on the VBoxes contained in the squares, it checks if
 * moves are legal and makes API calls to try and make them.
 */
public class SquareClickHandler implements EventHandler<MouseEvent> {
  private Square mySquare;


  public SquareClickHandler(Square yourSquare) {
    mySquare = yourSquare;
  }

  @Override
  public void handle(MouseEvent event) {
    Piece pieceHere = mySquare.getPiece();
    Piece selectedPiece = mySquare.getParent().getSelectedPiece();

    // Sanity check
    System.out.println(
        String.format("Hello, I'm (%s,%s) and I contain %s.",
            mySquare.getX(), mySquare.getY(), pieceHere));

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
    GameWindowController gwc = mySquare.getParent();

    gwc.setSelectedPiece(thisPiece);
    gwc.setSelectedX(thisPiece.getX());
    gwc.setSelectedY(thisPiece.getY());

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
    int xHere = mySquare.getX();
    int yHere = mySquare.getY();
    GameWindowController gwc = mySquare.getParent();

    Piece selectedPiece = gwc.getSelectedPiece();
    List<int[]> selectedMoves = selectedPiece.getMoves(gwc.getGame().getPieces());

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
    GameWindowController gwc = mySquare.getParent();
    //int[] positionHere = new int[]{ mySquare.getX(), mySquare.getY() };
    //int[] positionThere = new int[]{ gwc.getSelectedX(), gwc.getSelectedY() };
    Piece pieceHere = mySquare.getPiece();
    Piece pieceThere = gwc.getSelectedPiece();

    // Remove the piece here from the GameWindowController and this square.
    System.out.println("Pieces on board before move: " + gwc.getGame().getPieces().size());
    gwc.getGame()
       .getPieces()
       .remove(pieceHere);
    mySquare.removePiece();
    mySquare.setPiece(pieceThere);

    // Set the piece's new position
    pieceThere.setX(mySquare.getX());
    pieceThere.setY(mySquare.getY());

    // Unset the GameWindowControllers selected* variables.
    gwc.setSelectedX(-1);
    gwc.setSelectedY(-1);
    gwc.setSelectedPiece(null);
    System.out.println("Pieces on board after move: " + gwc.getGame().getPieces().size());
  }

  /**
   * Runs when an attempted move wasn't legal. If this square contains a piece
   * that piece will now be selected, if it does not then we will set selectedX,
   * selectedY and selectedPiece in the controller to -1, -1 and null respectively
   * to indicate that nothing is currently selected.
   */
  private void selectUsIfWeHaveAPiece() {

  }
}
