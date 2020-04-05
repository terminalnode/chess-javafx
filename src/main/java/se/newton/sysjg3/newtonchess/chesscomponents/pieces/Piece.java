package se.newton.sysjg3.newtonchess.chesscomponents.pieces;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
  public static final boolean WHITE = true;
  public static final boolean BLACK = false;

  private int x;
  private int y;
  private int internalId;
  private boolean isWhite;
  private boolean moved;
  private ImageView pieceGraphic;
  private final int imageSize = 60; // defines the max height and width of an imageview
  DropShadow shadow;

  //----- Constructor ----//
  Piece() {
    // Empty constructor
  }

  Piece(int internalId, int x, int y, boolean isWhite) {
    this.internalId = internalId;
    this.x = x;
    this.y = y;
    this.moved = false;
    this.isWhite = isWhite;
    this.pieceGraphic = null;
    shadow = new DropShadow();
    shadow.setSpread(0.0001);
    if (isWhite) {
      shadow.setColor(Color.BLACK);
    } else {
      shadow.setColor(Color.WHITE);
    }
  }


  //----- Abstract methods ----//
  public abstract List<int[]> getMoves(List<Piece> pieces);
  public abstract URL getDrawable();
  public abstract PieceType getPieceType();


  //----- Methods -----//
  public void move(int x, int y) {
    this.x = x;
    this.y = y;
    this.moved = true;
  }

  List<int[]> getStraightMoves(List<Piece> pieces) {
    List<int[]> moves = new ArrayList<>();
    boolean downBlocked = false;
    boolean upBlocked = false;
    boolean rightBlocked = false;
    boolean leftBlocked = false;

    for (int i = 1; i < 8; i++) {
      int[] down = new int[]{x, y + i};
      int[] up = new int[]{x, y - i};
      int[] right = new int[]{x + i, y};
      int[] left = new int[]{x - i, y};

      if (!downBlocked) {
        downBlocked = !addMoveToList(moves, down, pieces);
      }

      if (!upBlocked) {
        upBlocked = !addMoveToList(moves, up, pieces);
      }

      if (!rightBlocked) {
        rightBlocked = !addMoveToList(moves, right, pieces);
      }

      if (!leftBlocked) {
        leftBlocked = !addMoveToList(moves, left, pieces);
      }
    }

    return moves;
  }

  List<int[]> getDiagonalMoves(List<Piece> pieces) {
    List<int[]> moves = new ArrayList<>();
    boolean upRightBlocked = false;
    boolean upLeftBlocked = false;
    boolean downRightBlocked = false;
    boolean downLeftBlocked = false;

    for (int i = 1; i < 8; i++) {
      int[] upRight   = new int[]{x + i, y - i};
      int[] upLeft    = new int[]{x - i, y - i};
      int[] downRight = new int[]{x + i, y + i};
      int[] downLeft  = new int[]{x - i, y + i};

      if (!upRightBlocked) {
        upRightBlocked = !addMoveToList(moves, upRight, pieces);
      }

      if (!upLeftBlocked) {
        upLeftBlocked = !addMoveToList(moves, upLeft, pieces);
      }

      if (!downRightBlocked) {
        downRightBlocked = !addMoveToList(moves, downRight, pieces);
      }

      if (!downLeftBlocked) {
        downLeftBlocked = !addMoveToList(moves, downLeft, pieces);
      }
    }

    return moves;
  }

  private Piece pieceAtPosition(int[] position, List<Piece> pieces) {
    int xHere = position[0];
    int yHere = position[1];

    for (Piece piece : pieces) {
      if (piece.getX() == xHere && piece.getY() == yHere) {
        return piece;
      }
    }
    return null;
  }

  private boolean isPositionOutOfBounds(int[] position) {
    int xHere = position[0];
    int yHere = position[1];

    return
        xHere < 0 || xHere > 7 ||
        yHere < 0 || yHere > 7;
  }

  public PieceType[] upgrade() {
    return null;
  }

  boolean addMoveToList(List<int[]> moves, int x, int y, List<Piece> otherPieces) {
    return addMoveToList(moves, new int[]{x, y}, otherPieces);
  }

  boolean addMoveToList(List<int[]> moves, int[] position, List<Piece> otherPieces) {
    if (isPositionOutOfBounds(position)) {
      return false;
    }

    Piece pieceHere = pieceAtPosition(position, otherPieces);
    boolean blockedByPiece = pieceHere != null;
    boolean blockedByOwnColorOrKing = blockedByPiece && (
        pieceHere.isWhite() == isWhite() ||
        pieceHere.getPieceType() == PieceType.KING
    );

    if (blockedByOwnColorOrKing) {
      return false;
    } else if (blockedByPiece) {
      moves.add(position);
      return false;
    } else {
      moves.add(position);
      return true;
    }
  }

  @Override
  public String toString() {
    return String.format(
        "<%s %s (%s,%s)>",
        isWhite ? "White" : "Black",
        this.getClass().getSimpleName(),
        x, y);
  }

  //----- Setters -----//
  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setInternalId(int internalId) {
    this.internalId = internalId;
  }

  public void setMoved(boolean moved) {
    this.moved = moved;
  }

  public void setWhite(boolean white) {
    isWhite = white;
  }

  public void setPieceGraphic(ImageView pieceGraphic) {
    this.pieceGraphic = pieceGraphic;
  }

  //----- Getters -----//
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getInternalId() {
    return internalId;
  }

  public boolean isMoved() {
    return moved;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public ImageView getPieceGraphic() {
    if (pieceGraphic == null) {
      Image image = new Image(
          this.getDrawable().toExternalForm(),
          imageSize, imageSize, // Requested height/width
          true,
          true);
      pieceGraphic = new ImageView(image);
      pieceGraphic.setEffect(shadow);
    }

    return pieceGraphic;
  }
}
