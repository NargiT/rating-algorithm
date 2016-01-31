package fr.nargit.game.ranking.algorihtm.elo;

import fr.nargit.game.ranking.algorihtm.elo.performance.EloPerformance;

/**
 * Created by NargiT on 13/01/2016
 */
public class EloAlgorithm {

  private EloPerformance eloPerformance;

  public EloAlgorithm(EloPerformance eloPerformance) {
    this.eloPerformance = eloPerformance;
  }

  /**
   * @param playerQuotation   - the current elo rank of the target player
   * @param opponentQuotation - the opponent elo rank the player was competing against
   * @param positionFactor    - the positionFactor of the player (1 : first, 1.5 : draw, 2 : second)
   * @param kFactor           - the weight applied to the quotation
   *
   * @return new quotation for targeted player
   */
  public double calculateNewQuotation(double playerQuotation, double opponentQuotation, double positionFactor, int kFactor) {
    double[] opponentsElo = {opponentQuotation};
    return calculateNewQuotation(playerQuotation, opponentsElo, positionFactor, kFactor);
  }

  /**
   * Calculate the new quotation for any type of game based on his positionFactor
   *
   * @param playerQuotation    - the current elo rank of the target player
   * @param opponentQuotations - the list of opponents elo rank the player was competing against
   * @param positionFactor     - the position of the player where a draw on position n is n.5
   * @param kFactor            - the weight applied to the quotation
   *
   * @return new quotation for targeted player
   */
  public double calculateNewQuotation(double playerQuotation, double[] opponentQuotations, double positionFactor, int kFactor) {
    return playerQuotation + calculateDeltaQuotation(playerQuotation, opponentQuotations, positionFactor, kFactor);
  }

  /**
   * @param playerQuotation - the current elo rank of the target player
   * @param opponentsElo    - the list of opponents elo rank the player was competing against
   * @param positionFactor  - the position of the player where a draw on position n is n.5
   * @param kFactor         - the weight applied to the quotation
   *
   * @return the delta quotation to add for the player
   */
  public double calculateDeltaQuotation(double playerQuotation, double[] opponentsElo, double positionFactor, int kFactor) {
    double opponentsEloSum = 0;
    for (double opponentElo : opponentsElo) {
      opponentsEloSum += eloPerformance.getWinningProbability(playerQuotation, opponentElo);
    }

    final int numberOfPlayers = numberOfPlayers(opponentsElo);
    final int numberOfGames = numberOfGames(numberOfPlayers);

    final double winingProbability = opponentsEloSum / numberOfGames;
    final double scoring = (numberOfPlayers - positionFactor) / numberOfGames;
    return calculateRatingDifference(kFactor, scoring, winingProbability);
  }

  private int numberOfPlayers(double[] opponentsElo) {
    return opponentsElo.length + 1;
  }

  private int numberOfGames(int numberOfPlayers) {
    return (numberOfPlayers * (numberOfPlayers - 1)) / 2;
  }

  private double calculateRatingDifference(int kFactor, double scoring, double winningProbabilityForPlayer) {
    return kFactor * (scoring - winningProbabilityForPlayer);
  }
}
