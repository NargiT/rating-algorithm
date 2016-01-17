package fr.nargit.game.ranking.algorihtm;

/**
 * Created by NargiT on 14/01/2016
 */
public class StubEloPerformanceRating implements EloPerformanceRating {

  public static final double STRONGER_RESULT = 0.765;
  public static final double WEAKER_RESULT = 0.235;
  public static final double EQUIVALENT_RESULT = 0.500;

  @Override
  public double getWinningProbability(double playerRating, double opponentRating) {
    double difference = playerRating - opponentRating;
    if (difference > 0) {
      return STRONGER_RESULT;
    } else if (difference == 0) {
      return EQUIVALENT_RESULT;
    }
    return WEAKER_RESULT;
  }
}
