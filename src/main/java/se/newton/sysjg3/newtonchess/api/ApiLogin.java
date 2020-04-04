package se.newton.sysjg3.newtonchess.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;
import se.newton.sysjg3.newtonchess.api.entities.TokenEntity;
import se.newton.sysjg3.newtonchess.api.retrofitservices.RetrofitHelper;

public class ApiLogin {
  public static Call<TokenEntity> login(PlayerEntity player) {
    return RetrofitHelper
        .getLoginService()
        .login(player);
  }

  public static void logout(String token) {
    Call<String> call = RetrofitHelper.getLoginService().logout(token);
    call.enqueue(new Callback<String>() {
      @Override
      @EverythingIsNonNull
      public void onResponse(Call<String> call, Response<String> response) {
        // Do nothing
      }

      @Override
      @EverythingIsNonNull
      public void onFailure(Call<String> call, Throwable t) {
        // Do nothing
      }
    });
  }
}
