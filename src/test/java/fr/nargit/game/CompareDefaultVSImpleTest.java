package fr.nargit.game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    double strongerElo = 2000;
    double weakerElo = 1800;
    System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));

    double defaultStrongerElo = defaultEloPerformanceRating.calculateNewElo(strongerElo, weakerElo, K_FACTOR, EloAlgorithm.Result.WIN);
    double simpleStrongerElo = simpleEloPerformanceRating.calculateNewElo(strongerElo, weakerElo, K_FACTOR, EloAlgorithm.Result.WIN);
    System.out.println(String.format("Default ELO = %.2f | Simple ELO = %.2f", defaultStrongerElo, simpleStrongerElo));

    double defaultWeakerElo = defaultEloPerformanceRating.calculateNewElo(weakerElo, strongerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);
    double simpleWeakerElo = simpleEloPerformanceRating.calculateNewElo(weakerElo, strongerElo, K_FACTOR, EloAlgorithm.Result.LOOSE);

    System.out.println(String.format("Default ELO = %.2f | Simple ELO = %.2f", defaultWeakerElo, simpleWeakerElo));

  }
}