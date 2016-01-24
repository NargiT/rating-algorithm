package fr.nargit.game.ranking.algorihtm;

/**
 * Created by NargiT on 13/01/2016
 */
public class DefaultEloPerformanceRating implements EloPerformanceRating {

  @Override
  public double getWinningProbability(double playerRating, double opponentRating) {
    //   return 1/(Math.pow(10,-(playerRating-opponentRating)/400)+1);
    return transformedRating(playerRating) / (transformedRating(playerRating) + transformedRating(opponentRating));
  }

  private double transformedRating(double value) {
    return Math.pow(10, value/400.0);
  }
}
