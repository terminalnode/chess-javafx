package se.newton.sysjg3.newtonchess.api.retrofitservices;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;
import se.newton.sysjg3.newtonchess.api.entities.TokenEntity;

public interface LoginService {
  @POST("login")
  Call<TokenEntity> login(@Body PlayerEntity player);

  @POST("logout")
  Call<String> logout(@Header("Token") String token);
}
