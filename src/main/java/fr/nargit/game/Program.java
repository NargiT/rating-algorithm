package fr.nargit.game;

import fr.nargit.game.ranking.algorihtm.elo.EloAlgorithm;
import fr.nargit.game.ranking.algorihtm.elo.performance.DefaultEloPerformance;

/**
 * (c) 17-janv.-2016
 *
 * @author tigran-mac
 */
public class Program {

  public static void main(String[] args) {
    EloAlgorithm eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());

  }
}
