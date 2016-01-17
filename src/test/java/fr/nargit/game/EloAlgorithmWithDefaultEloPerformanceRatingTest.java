package fr.nargit.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by NargiT on 14/01/2016
 */
// TODO: use real tests
public class EloAlgorithmWithDefaultEloPerformanceRatingTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() throws Exception {
    eloAlgorithm = new EloAlgorithm(new DefaultEloPerformanceRating());
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testEloWeakerWins200Times() throws Exception {
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

  @Test
  public void testEloDefaultWithKFactor20() throws Exception {
    double playerOne = 1029.43;
    double playerTwo = 1010.3;
    int kFactor = 20;
    double newPLayerOne = eloAlgorithm.calculateNewElo(playerOne, playerTwo, kFactor, EloAlgorithm.Result.WIN);
    double newPlayerTwo = eloAlgorithm.calculateNewElo(playerTwo, playerOne, kFactor, EloAlgorithm.Result.LOOSE);
    System.out.println(String.format("Player One ELO = %.2f | Player Two ELO = %.2f", newPLayerOne, newPlayerTwo));
  }
}