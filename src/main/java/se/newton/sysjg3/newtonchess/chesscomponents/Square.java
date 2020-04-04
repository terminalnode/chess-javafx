package se.newton.sysjg3.newtonchess.chesscomponents;

import javafx.scene.layout.VBox;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;

/**
 * A class representing a square on the board. When a piece is set it's put in the VBox
 * so that it will be displayed on the board.
 * @author Alexander Rundberg
 */
public class Square {
  Piece piece;
  VBox vbox;
  Square[][] allSquares;

  //----- Constructors -----//
  public Square(VBox vbox) {
    this.vbox = vbox;
    piece = null;
    allSquares = null;
  }

  //----- Methods -----//
  public void removePiece() {
    piece = null;
    vbox.getChildren().removeAll();
  }

  //----- Setters -----//
  public void setPiece(Piece piece) {
    this.piece = piece;
    if (piece != null) {
      vbox.getChildren().addAll(piece.getPieceGraphic());
    }
  }

  public void setVbox(VBox vbox) {
    this.vbox = vbox;
  }

  public void setAllSquares(Square[][] allSquares) {
    this.allSquares = allSquares;
  }

  //----- Getters -----//
  public Piece getPiece() {
    return piece;
  }

  public VBox getVbox() {
    return vbox;
  }

  public Square[][] getAllSquares() {
    return allSquares;
  }
}
