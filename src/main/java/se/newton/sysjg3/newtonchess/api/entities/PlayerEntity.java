package se.newton.sysjg3.newtonchess.api.entities;

import com.google.gson.annotations.SerializedName;

public class PlayerEntity {
  @SerializedName("id")
  private int id;

  @SerializedName("name")
  private String name;

  @SerializedName("password")
  private String password;

  //----- Constructors -----//
  public PlayerEntity() {
    // Empty no-args constructor
  }

  public PlayerEntity(String name, String password) {
    this.name = name;
    this.password = password;
  }

  //----- Methods -----//
  @Override
  public String toString() {
    return String.format(
        "<PlayerEntity name=\"%s\">",
        name
    );
  }

  //----- Getters -----//
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  //----- Setters -----//
  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
