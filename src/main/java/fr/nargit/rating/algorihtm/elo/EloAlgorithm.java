package fr.nargit.rating.algorihtm.elo;

import fr.nargit.rating.algorihtm.elo.performance.EloPerformance;

import java.util.Collections;
import java.util.List;

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
    List<Double> opponentsElo = Collections.singletonList(opponentQuotation);
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
  public double calculateNewQuotation(double playerQuotation, List<Double> opponentQuotations, double positionFactor,
                                      int kFactor) {
    return playerQuotation + calculateDeltaQuotation(playerQuotation, opponentQuotations, positionFactor, kFactor);
  }

  /**
   * @param playerQuotation    - the current elo rank of the target player
   * @param opponentQuotations - the list of opponents elo rank the player was competing against
   * @param positionFactor     - the position of the player where a draw on position n is n.5
   * @param kFactor            - the weight applied to the quotation
   *
   * @return the delta quotation to add for the player
   */
  public double calculateDeltaQuotation(double playerQuotation, List<Double> opponentQuotations, double positionFactor, int kFactor) {
    double opponentsEloSum = 0;
    for (double opponentQuotation : opponentQuotations) {
      opponentsEloSum += eloPerformance.getWinningProbability(playerQuotation, opponentQuotation);
    }

    final int numberOfPlayers = numberOfPlayers(opponentQuotations);
    final int numberOfGames = numberOfGames(numberOfPlayers);

    final double winingProbability = opponentsEloSum / numberOfGames;
    final double scoring = (numberOfPlayers - positionFactor) / numberOfGames;
    return calculateRatingDifference(kFactor, scoring, winingProbability);
  }

  private int numberOfPlayers(List opponentsElo) {
    return opponentsElo.size() + 1;
  }

  private int numberOfGames(int numberOfPlayers) {
    // return (numberOfPlayers * (numberOfPlayers - 1)) / 2;
    return numberOfPlayers - 1;
  }

  private double calculateRatingDifference(int kFactor, double scoring, double winningProbabilityForPlayer) {
    return kFactor * (scoring - winningProbabilityForPlayer);
  }
}