package se.newton.sysjg3.newtonchess.api.retrofitservices;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.api.entities.MoveEntity;

/**
 * Retrofit service interface connecting to the /api/games endpoint.
 * @author Alexander Rundberg
 */
public interface GameService {
  @GET("games")
  Call<List<GameEntity>> getAllGames(
      @Header("Token") String token);

  @GET("games/{gameId}")
  Call<GameEntity> getGame(
      @Header("Token") String token,
      @Path("gameId") long gameId);

  @POST("games/{gameId}")
  Call<MoveEntity> makeMove(
      @Header("Token") String token,
      @Path("gameId") long gameId,
      @Body MoveEntity move);
}
