package se.newton.sysjg3.newtonchess.api;

import java.util.ArrayList;
import java.util.List;

public class UserData {
  private String userName;
  private List<Friend> friendList = new ArrayList<>();

  //----- Constructors -----//
  public UserData(String userName) {
    this.userName = userName;
  }

  //----- Methods -----//
  public void addFriend(String friendName, int friendId) {
    friendList.add(new Friend(friendName, friendId));
  }


  //----- Getters and Setters -----//
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public List<Friend> getFriendList() {
    return this.friendList;
  }

  public void addFriendToList(Friend newFriend) {
    this.friendList.add(newFriend);
  }


}

