package fr.nargit.game;

/**
 * Created by NargiT on 13/01/2016
 */
public interface EloPerformanceRating {

  double getWinningProbability(double playerRating, double opponentRating);
}
