package se.newton.sysjg3.newtonchess.chesscomponents.pieces;



import javafx.scene.image.Image;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

import java.net.URL;
import java.util.List;


public class Bishop extends Piece {
  public Bishop() {
    super();
  }


  public Bishop(int internalId, int x, int y, boolean isWhite) {
    super(internalId, x, y, isWhite);
  }

  @Override
  public List<int[]> getMoves(List<Piece> pieces) {
    return getDiagonalMoves(pieces);
  }

  @Override
  public URL getDrawable() {
    return isWhite() ?
        HelperMethods.getRes("drawable/wbishop.png") :
        HelperMethods.getRes("drawable/bbishop.png");
  }

  @Override
  public PieceType getPieceType() {
    return PieceType.BISHOP;
  }
}
