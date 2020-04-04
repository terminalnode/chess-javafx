package se.newton.sysjg3.newtonchess.api.entities;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.*;

import java.io.IOException;

/**
 * TypeAdapter for pieces, used for serializing and deserializing Piece-type objects.
 * @author Alexander Rundberg
 */
public class PieceAdapter extends TypeAdapter<Piece> {
  @Override
  public void write(JsonWriter out, Piece value) throws IOException {

    // not implemented yet
  }

  @Override
  public Piece read(JsonReader in) throws IOException {

    Piece piece;
    String type = "unknown";
    int internalId = 0;
    int x = 0;
    int y = 0;
    boolean moved = false;
    boolean white = false;

    in.beginObject();
    while (in.hasNext()) {
      String field = in.nextName();
      switch (field) {
        case "class":       type = in.nextString(); break;
        case "internalId":  internalId = in.nextInt(); break;
        case "x":           x = in.nextInt(); break;
        case "y":           y = in.nextInt(); break;
        case "moved":       moved = in.nextBoolean(); break;
        case "white":       white = in.nextBoolean(); break;
        default:            in.skipValue();
      }
    }
    in.endObject();

    switch(type) {
      case "bishop":  piece = new Bishop(); break;
      case "king":    piece = new King(); break;
      case "knight":  piece = new Knight(); break;
      case "pawn":    piece = new Pawn(); break;
      case "queen":   piece = new Queen(); break;
      case "rook":    piece = new Rook(); break;
      default:
        internalId = 0;
        piece = new Pawn();
        break;
    }

    piece.setInternalId(internalId);
    piece.setX(x);
    piece.setY(y);
    piece.setMoved(moved);
    piece.setWhite(white);

    return piece;
  }
}
