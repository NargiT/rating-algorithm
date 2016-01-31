package fr.nargit.game.ranking.algorihtm.elo.performance;

/**
 * Created by NargiT on 13/01/2016
 */
public class DefaultEloPerformance implements EloPerformance {

  @Override
  public double getWinningProbability(double playerRating, double opponentRating) {
    //   return 1/(Math.pow(10,-(playerRating-opponentRating)/400)+1);
    return transformedRating(playerRating) / (transformedRating(playerRating) + transformedRating(opponentRating));
  }

  private double transformedRating(double value) {
    return Math.pow(10, value / 400.0);
  }
}
