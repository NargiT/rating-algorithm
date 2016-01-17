package fr.nargit.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

/**
 * Created by NargiT on 14/01/2016
 */
// TODO: use real tests
public class CompareDefaultVSImpleTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm simpleEloPerformanceRating;
  private EloAlgorithm defaultEloPerformanceRating;

  @Before
  public void setUp() throws Exception {
    simpleEloPerformanceRating = new EloAlgorithm(new SimpleEloPerformanceRating());
    defaultEloPerformanceRating = new EloAlgorithm(new DefaultEloPerformanceRating());
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testCompareStrongerWins() throws Exception {
    double strongerElo = 1000;
    double weakerElo = 1000;
    System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));

    double defaultStrongerElo = strongerElo, defaultWeakerElo = weakerElo;
    double simpleStrongerElo = strongerElo, simpleWeakerElo = weakerElo;

    for (int i = 0; i < 200; i++) {
      double newDefaultStrongerElo = defaultEloPerformanceRating.calculateNewElo(defaultStrongerElo, defaultWeakerElo, K_FACTOR, EloAlgorithm.Result.WIN);
      double newSimpleStrongerElo = simpleEloPerformanceRating.calculateNewElo(simpleStrongerElo, simpleWeakerElo, K_FACTOR, EloAlgorithm.Result.WIN);

      double newDefaultWeakerElo = defaultEloPerformanceRating.calculateNewElo(defaultWeakerElo, defaultStrongerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);
      double newSimpleWeakerElo = simpleEloPerformanceRating.calculateNewElo(simpleWeakerElo, simpleStrongerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);

      System.out.println(String.format("%.2f", newSimpleWeakerElo));
      defaultStrongerElo = newDefaultStrongerElo;
      simpleStrongerElo = newSimpleStrongerElo;

      defaultWeakerElo = newDefaultWeakerElo;
      simpleWeakerElo= newSimpleWeakerElo;
    }
  }
}