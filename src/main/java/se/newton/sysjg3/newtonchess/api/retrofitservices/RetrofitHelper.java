package se.newton.sysjg3.newtonchess.api.retrofitservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.newton.sysjg3.newtonchess.api.entities.PieceAdapter;
import se.newton.sysjg3.newtonchess.chesscomponents.pieces.Piece;

/**
 * Helper class for creating Retrofit objects used to make API calls
 */
public class RetrofitHelper {
  public static final String INTERNAL_SERVER_ERROR = "InternalServerErrorException";
  private static final String BASE_URL = "https://newton-sysjg3-chessapi.herokuapp.com/api/";
  private static final String DEV_URL = "http://10.0.2.2:8080/api/";


  private static Retrofit getBase() {
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(Piece.class, new PieceAdapter())
        .setLenient()
        .create();

    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
  }

  public static PlayerService getPlayerService(){
    return getBase().create(PlayerService.class);
  }

  public static LoginService getLoginService() {
    return getBase().create(LoginService.class);
  }

  public static ChallengeService getChallengeService() {
    return getBase().create(ChallengeService.class);
  }

  public static GameService getGameService() {
    return getBase().create(GameService.class);
  }
}
