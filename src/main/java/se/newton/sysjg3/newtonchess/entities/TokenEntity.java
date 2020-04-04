package se.newton.sysjg3.newtonchess.entities;

import com.google.gson.annotations.SerializedName;

public class TokenEntity {
  @SerializedName("tokenString")
  private String tokenString;

  @SerializedName("player")
  private PlayerEntity player;

  //----- Methods -----//
  @Override
  public String toString() {
    return String.format(
        "<TokenEntity string=\"%s\", player=%s>",
        tokenString,
        player
    );
  }

  //----- Getters -----//
  public String getTokenString() {
    return tokenString;
  }

  public PlayerEntity getPlayer() {
    return player;
  }

  //----- Setters -----//
  public void setTokenString(String tokenString) {
    this.tokenString = tokenString;
  }

  public void setPlayer(PlayerEntity player) {
    this.player = player;
  }

  public TokenEntity() {
  }

}
