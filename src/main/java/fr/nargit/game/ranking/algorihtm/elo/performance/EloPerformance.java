package fr.nargit.game.ranking.algorihtm.elo.performance;

/**
 * Created by NargiT on 13/01/2016
 */
public interface EloPerformance {

  double getWinningProbability(double playerRating, double opponentRating);
}
