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
    if (controller.isWhite() != controller.isWhitesTurn() || controller.isFinished()) {
      return; // The player can't play right now anyway
    }

    Piece pieceHere = mySquare.getPiece();
    Piece selectedPiece = mySquare.getParent().getSelectedPiece();
    System.out.println(String.format("Hello, I'm (%s,%s) and I contain %s.", xHere, yHere, pieceHere));

    // Check some conditions to make the process of deciding on an action a bit easier.
    boolean noPieceHereNoPiecePreviously = pieceHere == null && selectedPiece == null;
    boolean weHaveAPieceButPreviousSquareDidNot = pieceHere != null && selectedPiece == null;
    boolean movingPieceIsMyColor = selectedPiece != null && selectedPiece.isWhite() == controller.isWhite();

    // If neither this nor the last clicked box contained a piece, we're not interested.
    if (noPieceHereNoPiecePreviously) {
      return;
    }

    // Both squares are not null, so we will try to carry out some kind of action
    if (weHaveAPieceButPreviousSquareDidNot) {
      selectThisSquare();

    } else {
      // See if move is legal, if it is make it and return
      if (checkIfMoveIsLegal()) {
        if (tryToMakeApiMove()) {
          moveThePieceLocally();
          return;
        }
      }

      // Move was not legal
      selectThisSquare();
    }
  }

  /**
   * This square contains a piece, but the previously clicked one does not.
   * So we select this one.
   */
  private void selectThisSquare() {
    Piece thisPiece = mySquare.getPiece();
    if (thisPiece != null && thisPiece.isWhite() == controller.isWhite()) {
      System.out.println("Selecting square");
      controller.setSelectedPiece(thisPiece);
      controller.setSelectedX(thisPiece.getX());
      controller.setSelectedY(thisPiece.getY());
    } else {
      System.out.println("Deselecting square");
      controller.setSelectedPiece(null);
      controller.setSelectedX(-1);
      controller.setSelectedY(-1);
    }

    // Sanity check
    System.out.println(String.format(
        "Selected square is (%s,%s) %s",
        mySquare.getPiece(),
        mySquare.getX(),
        mySquare.getY()
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
    controller.incrementNumberOfTurns();
    controller.setIsWhitesTurn(!controller.isWhitesTurn());
    System.out.println("Pieces on board after move: " + controller.getGame().getPieces().size());
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
