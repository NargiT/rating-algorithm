package fr.nargit.game;

/**
 * Created by NargiT on 13/01/2016
 */
public class EloAlgorithm {

  private EloPerformanceRating eloPerformanceRating;

  public EloAlgorithm(EloPerformanceRating eloPerformanceRating) {
    this.eloPerformanceRating = eloPerformanceRating;
  }

  public double calculateNewElo(double playerElo, double opponentElo, int kFactor, Result result) {
    double difference = playerElo - opponentElo;
    return playerElo + calculateRatingDifference(kFactor, result, eloPerformanceRating.getWinningProbability(difference));
  }

  private double calculateRatingDifference(int kFactor, Result result, double winningProbabilityForPlayer) {
    return kFactor * (result.getValue() - winningProbabilityForPlayer);
  }

  enum Result {
    WIN(1), LOOSE(0), DRAW(0.5);

    private final double value;

    Result(double value) {
      this.value = value;
    }

    protected double getValue() {
      return value;
    }
  }
}
