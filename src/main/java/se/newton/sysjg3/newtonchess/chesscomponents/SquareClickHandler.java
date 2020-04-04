package se.newton.sysjg3.newtonchess.chesscomponents;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;

public class SquareClickHandler implements EventHandler<MouseEvent> {
  private Square mySquare;

  public SquareClickHandler(Square yourSquare) {
    mySquare = yourSquare;
  }

  @Override
  public void handle(MouseEvent event) {
    System.out.println(mySquare);
  }

  public Piece getPiece() {
    return mySquare.getPiece();
  }
}
