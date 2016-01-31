package fr.nargit.game.ranking.algorihtm.elo;

import fr.nargit.game.ranking.algorihtm.elo.performance.DefaultEloPerformance;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by NargiT on 14/01/2016
 */
@Ignore
public class EloAlgorithmWithDefaultEloPerformanceTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() {
    eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
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

  @Test
  public void testEloDefaultWithKFactor20() {
    double playerOne = 1029.43;
    double playerTwo = 1010.3;
    int kFactor = 20;
    double newPLayerOne = eloAlgorithm.calculateNewQuotation(playerOne, playerTwo, 1, kFactor);
    double newPlayerTwo = eloAlgorithm.calculateNewQuotation(playerTwo, playerOne, 2, kFactor);
    System.out.println(String.format("Player One ELO = %.2f | Player Two ELO = %.2f", newPLayerOne, newPlayerTwo));
  }

  @Test
  public void testEloForMultiplayer() {
    double playerOne = 900;
    double playerTwo = 1000;
    double playerThree = 980.0;
    int kFactor = 20;

    double newPLayerOne1 = eloAlgorithm.calculateNewQuotation(playerOne, new double[]{playerTwo, playerThree}, 1, kFactor);
    double newPLayerOne2 = eloAlgorithm.calculateNewQuotation(playerOne, new double[]{playerTwo, playerThree}, 2, kFactor);
    double newPLayerOne3 = eloAlgorithm.calculateNewQuotation(playerOne, new double[]{playerTwo, playerThree}, 3, kFactor);
    System.out.println(String.format("rank 1 ELO = %.2f \n rank 2 ELO = %.2f \n rank 3 ELO = %.2f", newPLayerOne1, newPLayerOne2, newPLayerOne3));
  }
}