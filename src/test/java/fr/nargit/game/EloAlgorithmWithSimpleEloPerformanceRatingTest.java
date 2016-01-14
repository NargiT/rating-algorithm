package fr.nargit.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by NargiT on 14/01/2016
 */
public class EloAlgorithmWithSimpleEloPerformanceRatingTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() throws Exception {
    eloAlgorithm = new EloAlgorithm(new SimpleEloPerformanceRating());
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testEloStrongerWins3Times() throws Exception {
    double strongerElo = 2000;
    double weakerElo = 1800;
    for (int i = 0; i < 3; i++) {
      System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));
      strongerElo = eloAlgorithm.calculateNewElo(strongerElo, weakerElo, K_FACTOR, EloAlgorithm.Result.WIN);
      weakerElo = eloAlgorithm.calculateNewElo(weakerElo, strongerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);
    }
  }

  @Test
  public void testEloWeakerWins3Times() throws Exception {
    double strongerElo = 2000;
    double weakerElo = 1200;
    double newStrongerElo, newWeakerElo;
    for (int i = 0; i < 200; i++) {
      System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));
      newStrongerElo = eloAlgorithm.calculateNewElo(strongerElo, weakerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);
      newWeakerElo = eloAlgorithm.calculateNewElo(weakerElo, strongerElo, K_FACTOR, EloAlgorithm.Result.WIN);

      strongerElo = newStrongerElo;
      weakerElo = newWeakerElo;
    }
  }

}