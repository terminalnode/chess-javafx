package se.newton.sysjg3.newtonchess.api;

import java.util.List;

import retrofit2.Call;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;
import se.newton.sysjg3.newtonchess.api.retrofitservices.RetrofitHelper;

public class ApiPlayer {
  public static Call<List<PlayerEntity>> getAll() {
    return RetrofitHelper
        .getPlayerService()
        .getAll();
  }

  public static Call<PlayerEntity> createPlayer(PlayerEntity player) {
    return RetrofitHelper
        .getPlayerService()
        .createPlayer(player);
  }

  public static Call<List<PlayerEntity>> getFriends(String token) {
    return RetrofitHelper
        .getPlayerService()
        .getFriends(token);
  }

  public static Call<PlayerEntity> addFriend(String token, PlayerEntity player) {
    return RetrofitHelper
        .getPlayerService()
        .addFriend(token, player);
  }

  public static Call<List<PlayerEntity>> searchFriend(String token, String searchTerm) {
    return RetrofitHelper
        .getPlayerService()
        .searchFriend(token, searchTerm);
  }
}
