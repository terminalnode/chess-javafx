package se.newton.sysjg3.newtonchess.api;


public class Friend {
  private String name;
  private int userId;
  private int gameId;

  //----- Constructors -----//
  public Friend(String friendName, int friendId) {
    this(friendName, friendId, -1);
  }

  public Friend(String friendName, int friendId, int gameId) {
    this.name = friendName;
    this.userId = friendId;
    this.gameId = gameId;
  }

  @Override
  public String toString() {
    return name;
  }

  //----- Creator -----//
;

  //----- Methods -----//


  //----- Getters and Setters -----//
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getGameId() {
    return gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }
}
