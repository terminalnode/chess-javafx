package se.newton.sysjg3.newtonchess.chesscomponents.pieces;

import javafx.scene.image.Image;
import se.newton.sysjg3.newtonchess.controllers.HelperMethods;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
  public Knight() {
    super();
  }

  public Knight(int internalId, int x, int y, boolean isWhite) {
    super(internalId, x, y, isWhite);
  }

  @Override
  public List<int[]> getMoves(List<Piece> pieces) {
    List<int[]> moves = new ArrayList<>();
    int x = getX();
    int y = getY();

    int[][] theoreticalMoves = new int[][]{
        { x - 1, y - 2 },
        { x + 1, y - 2 },
        { x - 1, y + 2 },
        { x + 1, y + 2 },
        { x - 2, y - 1 },
        { x - 2, y + 1 },
        { x + 2, y - 1 },
        { x + 2, y + 1 }
    };

    for (int[] theoreticalMove : theoreticalMoves) {
      addMoveToList(moves, theoreticalMove[0], theoreticalMove[1], pieces);
    }

    return moves;
  }

  @Override
  public Image getDrawable() {
    URL imageUrl = isWhite() ?
        HelperMethods.getRes("drawable/wknight.png") : HelperMethods.getRes("drawable/bknight.png");
    return new Image(imageUrl.toExternalForm());
  }

  @Override
  public PieceType getPieceType() {
    return PieceType.KNIGHT;
  }
}
