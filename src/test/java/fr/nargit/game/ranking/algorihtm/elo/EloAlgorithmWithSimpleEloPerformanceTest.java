package fr.nargit.game.ranking.algorihtm.elo;

import fr.nargit.game.ranking.algorihtm.elo.performance.SimpleEloPerformance;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by NargiT on 14/01/2016
 */
@Ignore
public class EloAlgorithmWithSimpleEloPerformanceTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() {
    eloAlgorithm = new EloAlgorithm(new SimpleEloPerformance());
  }

  @After
  public void tearDown() {

  }

  @Test
  public void testEloWeakerWins200Times() {
    double strongerElo = 2000;
    double weakerElo = 1200;
    double newStrongerElo, newWeakerElo;
    for (int i = 0; i < 200; i++) {
      System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));
      newStrongerElo = eloAlgorithm.calculateNewQuotation(strongerElo, weakerElo, 2, K_FACTOR);
      newWeakerElo = eloAlgorithm.calculateNewQuotation(weakerElo, strongerElo, 1, K_FACTOR);

      strongerElo = newStrongerElo;
      weakerElo = newWeakerElo;
    }
  }

}