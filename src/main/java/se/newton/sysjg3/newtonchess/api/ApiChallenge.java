package se.newton.sysjg3.newtonchess.api;

import se.newton.sysjg3.newtonchess.api.entities.ChallengeEntity;
import se.newton.sysjg3.newtonchess.api.entities.GameEntity;
import se.newton.sysjg3.newtonchess.api.entities.PlayerEntity;

import java.util.List;

import retrofit2.Call;
import se.newton.sysjg3.newtonchess.api.retrofitservices.RetrofitHelper;

public class ApiChallenge {
  public static final String CHALLENGE_ALREADY_EXISTS = "ChallengeAlreadyExistsException";
  public static final String CHALLENGE_ID_MISMATCH = "ChallengeIdMismatchException";

  public static Call<ChallengeEntity> createNewChallenge(String token, PlayerEntity player) {
    return RetrofitHelper
        .getChallengeService()
        .createNewChallenge(token, player);
  }

  public static Call<List<ChallengeEntity>> getChallengesToMe(String token) {
    return RetrofitHelper
        .getChallengeService()
        .getChallengesToMe(token);
  }

  public static Call<GameEntity> acceptChallenge(String token, long challengeId) {
    return  RetrofitHelper
        .getChallengeService()
        .acceptChallenge(token, challengeId);
  }

  public static Call<String> denyChallenge(String token, long challengeId) {
    return  RetrofitHelper
        .getChallengeService()
        .denyChallenge(token, challengeId);
  }
}
