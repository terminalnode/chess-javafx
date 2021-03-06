package se.newton.sysjg3.newtonchess.chesscomponents;

import javafx.scene.layout.VBox;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;
import se.newton.sysjg3.newtonchess.controllers.GameWindowController;


/**
 * A class representing a square on the board. When a piece is set it's put in the VBox
 * so that it will be displayed on the board.
 * @author Alexander Rundberg
 */
public class Square {
  private Piece piece;
  private VBox vbox;
  private Square[][] allSquares;
  private GameWindowController parent;
  private SquareClickHandler listener;
  int x, y;

  //----- Constructors -----//
  public Square(VBox vbox) {
    this.vbox = vbox;
    listener = new SquareClickHandler(this);
    this.vbox.setOnMouseClicked(listener);
    piece = null;
    allSquares = null;
    parent = null;
  }

  //----- Methods -----//
  public void removePiece() {
    piece = null;
    vbox.getChildren().clear();
  }

  public void informListener() {
    listener.setController(parent);
    listener.setxHere(x);
    listener.setyHere(y);
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

  public void setParent(GameWindowController parent) {
    this.parent = parent;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
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

  public GameWindowController getParent() {
    return parent;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
