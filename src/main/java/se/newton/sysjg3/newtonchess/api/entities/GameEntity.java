package se.newton.sysjg3.newtonchess.api.entities;

import com.google.gson.annotations.SerializedName;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;

import java.util.List;

/**
 * Entity class for deserializing GameEntities sent by the server.
 * Like all entities, this class is meant to represent a game as sent by the server.
 * The actual ChessBoard view class contains a lot more information than this, and as
 * such they are separated. However the ChessBoard class has getters and setters for
 * injecting the information contained in this object and thus alter it's state to
 * one representative of the information contained in the JSON.
 *
 * @author Alexander Rundberg
 */
public class GameEntity {
  @SerializedName("id")
  private long id;

  @SerializedName("whitePlayer")
  private PlayerEntity whitePlayer;

  @SerializedName("blackPlayer")
  private PlayerEntity blackPlayer;

  @SerializedName("whitesTurn")
  private boolean whitesTurn;

  @SerializedName("turnsTaken")
  private int turnsTaken;

  @SerializedName("finished")
  private boolean finished;

  @SerializedName("pieces")
  List<Piece> pieces;

  @SerializedName("gettingPlayerWhite")
  private boolean gettingPlayerWhite;

  @SerializedName("blackInCheck")
  private boolean blackInCheck;

  @SerializedName("whiteInCheck")
  private boolean whiteInCheck;
  //----- Constructors -----//
  public GameEntity() {
    // Required no-arg constructor
  }

  //----- Methods -----//
  @Override
  public String toString() {
    return String.format(
        "<Game id=%s, whitePlayer=%s blackPlayer=%s, whitesTurn=%s, turnsTaken=%s, finished=%s>",
        id, whitePlayer, blackPlayer, whitesTurn, turnsTaken, finished
    );
  }

  //----- Setters -----//
  public void setId(long id) {
    this.id = id;
  }

  public void setWhitePlayer(PlayerEntity whitePlayer) {
    this.whitePlayer = whitePlayer;
  }

  public void setBlackPlayer(PlayerEntity blackPlayer) {
    this.blackPlayer = blackPlayer;
  }

  public void setWhitesTurn(boolean whitesTurn) {
    this.whitesTurn = whitesTurn;
  }

  public void setTurnsTaken(int turnsTaken) {
    this.turnsTaken = turnsTaken;
  }

  public void setFinished(boolean finished) {
    this.finished = finished;
  }

  public void setPieces(List<Piece> pieces) {
    this.pieces = pieces;
  }

  public void setGettingPlayerWhite(boolean gettingPlayerWhite) {
    this.gettingPlayerWhite = gettingPlayerWhite;
  }

  public void setBlackInCheck(boolean blackInCheck) {
    this.blackInCheck = blackInCheck;
  }

  public void setWhiteInCheck(boolean whiteInCheck) {
    this.whiteInCheck = whiteInCheck;
  }

  //----- Getters -----//
  public long getId() {
    return id;
  }

  public PlayerEntity getWhitePlayer() {
    return whitePlayer;
  }

  public PlayerEntity getBlackPlayer() {
    return blackPlayer;
  }

  public boolean isWhitesTurn() {
    return whitesTurn;
  }

  public int getTurnsTaken() {
    return turnsTaken;
  }

  public boolean isFinished() {
    return finished;
  }

  public List<Piece> getPieces() {
    return pieces;
  }

  public boolean isGettingPlayerWhite() {
    return gettingPlayerWhite;
  }

  public boolean isBlackInCheck() {
    return blackInCheck;
  }

  public boolean isWhiteInCheck() {
    return whiteInCheck;
  }
}
