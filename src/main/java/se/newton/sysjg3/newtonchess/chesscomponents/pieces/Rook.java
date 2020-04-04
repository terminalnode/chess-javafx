package se.newton.sysjg3.newtonchess.chesscomponents.pieces;

import javafx.scene.image.Image;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

import java.net.URL;
import java.util.List;

public class Rook extends Piece {
  public Rook() {
    super();
  }

  public Rook(int internalId, int x, int y, boolean isWhite) {
    super(internalId, x, y, isWhite);
  }

  @Override
  public List<int[]> getMoves(List<Piece> pieces) {
    return getStraightMoves(pieces);
  }

  @Override
  public Image getDrawable() {
    URL imageUrl = isWhite() ?
        HelperMethods.getRes("drawable/wrook.png") : HelperMethods.getRes("drawable/brook.png");
    return new Image(imageUrl.toExternalForm());
  }

  @Override
  public PieceType getPieceType() {
    return PieceType.ROOK;
  }
}
