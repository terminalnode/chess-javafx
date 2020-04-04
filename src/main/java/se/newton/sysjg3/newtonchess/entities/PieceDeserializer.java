package se.newton.sysjg3.newtonchess.entities;

import com.example.newtonchess.chesscomponents.pieces.Bishop;
import com.example.newtonchess.chesscomponents.pieces.King;
import com.example.newtonchess.chesscomponents.pieces.Knight;
import com.example.newtonchess.chesscomponents.pieces.Pawn;
import com.example.newtonchess.chesscomponents.pieces.Piece;
import com.example.newtonchess.chesscomponents.pieces.Queen;
import com.example.newtonchess.chesscomponents.pieces.Rook;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * JsonDeserializer for converting data from our JSON response to Piece objects.
 * The pieces do not save any data that's not in the JSON, and as such we can have
 * a deserialize them whenever we receive a new GameEntity from the server and
 * replace the list of pieces in our ChessBoard object with this list. Replacing them
 * in the ChessBoard class will automatically trigger an invalidation of that boards
 * state forcing it to redraw the chessboard.
 *
 * @author Alexander Rundberg
 */
public class PieceDeserializer implements JsonDeserializer<Piece> {
  @Override
  public Piece deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonObject json = jsonElement.getAsJsonObject();
    String type = json.get("class").getAsString();

    Piece newPiece;
    switch (type) {
      case "bishop":  newPiece = new Bishop(); break;
      case "knight":  newPiece = new Knight(); break;
      case "king":    newPiece = new King(); break;
      case "queen":   newPiece = new Queen(); break;
      case "rook":    newPiece = new Rook(); break;
      default:        newPiece = new Pawn(); break;
    }

    newPiece.setInternalId(json.get("internalId").getAsInt());
    newPiece.setX(json.get("x").getAsInt());
    newPiece.setY(json.get("y").getAsInt());
    newPiece.setMoved(json.get("moved").getAsBoolean());
    newPiece.setWhite(json.get("white").getAsBoolean());

    return newPiece;
  }
}
