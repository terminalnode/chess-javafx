package se.newton.sysjg3.newtonchess.api;

import java.util.List;

import retrofit2.Call;
import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.api.retrofitservices.RetrofitHelper;

public class ApiGame {
  public static Call<List<GameEntity>> getAllGames(String token) {
    return RetrofitHelper
        .getGameService()
        .getAllGames(token);
  }

  public static <MoveEntity> Call<MoveEntity> makeMove(String token, long gameId, MoveEntity move) {
    return (Call<MoveEntity>) RetrofitHelper
        .getGameService()
        .makeMove(token, gameId, move);
  }

  public static Call<GameEntity> getGame(String token, long gameId) {
    return RetrofitHelper
        .getGameService()
        .getGame(token, gameId);
  }
}
