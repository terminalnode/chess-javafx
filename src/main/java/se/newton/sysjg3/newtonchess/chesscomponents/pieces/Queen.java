package se.newton.sysjg3.newtonchess.chesscomponents.pieces;

import javafx.scene.image.Image;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

import java.net.URL;
import java.util.List;

public class Queen extends Piece {
  public Queen() {
    super();
  }

  public Queen(int internalId, int x, int y, boolean isWhite) {
    super(internalId, x, y, isWhite);
  }

  @Override
  public List<int[]> getMoves(List<Piece> pieces) {
    List<int[]> moves = getStraightMoves(pieces);
    moves.addAll(getDiagonalMoves(pieces));
    return moves;
  }

  @Override
  public Image getDrawable() {
    URL imageUrl = isWhite() ?
        HelperMethods.getRes("/drawable/wqueen.png") : HelperMethods.getRes("/drawable/bqueen.png");
    return new Image(imageUrl.toExternalForm());
  }

  @Override
  public PieceType getPieceType() {
    return PieceType.QUEEN;
  }
}
