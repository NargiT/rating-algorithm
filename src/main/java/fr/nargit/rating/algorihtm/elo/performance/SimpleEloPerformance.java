package fr.nargit.rating.algorihtm.elo.performance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by NargiT on 13/01/2016
 */
public class SimpleEloPerformance implements EloPerformance {

  private final Map<Double, Double> ratingsTable;

  public SimpleEloPerformance() {
    ratingsTable = new HashMap<>();
    ratingsTable.put(-800.0, 0.0);
    ratingsTable.put(-677.0, 0.01);
    ratingsTable.put(-366.0, 0.1);
    ratingsTable.put(-240.0, 0.2);
    ratingsTable.put(-149.0, 0.3);
    ratingsTable.put(-72.0, 0.4);
    ratingsTable.put(0.0, 0.5);
    ratingsTable.put(72.0, 0.6);
    ratingsTable.put(149.0, 0.7);
    ratingsTable.put(240.0, 0.8);
    ratingsTable.put(366.0, 0.9);
    ratingsTable.put(677.0, 0.99);
    ratingsTable.put(800.0, 1.0);
  }

  @Override
  public double getWinningProbability(double playerRating, double opponentRating) {
    double difference = playerRating - opponentRating;
    Double aDouble = ratingsTable.get(difference);
    if (aDouble == null) {
      return getClosestProbability(difference);
    }
    return aDouble;
  }

  private double getClosestProbability(double difference) {
    double rating = 0d;
    Set<Double> keySet = ratingsTable.keySet();
    Double[] ratingValues = new Double[keySet.size()];
    keySet.toArray(ratingValues);
    Arrays.sort(ratingValues);

    for (int i = 0; i < ratingValues.length; i++) {
      if (difference > ratingValues[i]) {
        if (i + 1 < ratingValues.length) {
          rating = ratingsTable.get(ratingValues[i + 1]);
        } else {
          rating = 1d;
        }
      }
    }
    return rating;
  }
}
