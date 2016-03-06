package fr.nargit.rating.algorihtm.elo.performance.compare;

import fr.nargit.rating.algorihtm.elo.EloAlgorithm;
import fr.nargit.rating.algorihtm.elo.performance.DefaultEloPerformance;
import fr.nargit.rating.algorihtm.elo.performance.SimpleEloPerformance;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by NargiT on 14/01/2016
 */
@Ignore
public class DefaultVSImpleTest {

  public static final int K_FACTOR = 20;
  private EloAlgorithm simpleEloPerformanceRating;
  private EloAlgorithm defaultEloPerformanceRating;

  @Before
  public void setUp() {
    simpleEloPerformanceRating = new EloAlgorithm(new SimpleEloPerformance());
    defaultEloPerformanceRating = new EloAlgorithm(new DefaultEloPerformance());
  }

  @After
  public void tearDown() {

  }

  @Test
  public void testCompareStrongerWins() {
    double strongerElo = 1000;
    double weakerElo = 1000;
    System.out.println(String.format("Stronger ELO = %.2f | Weaker ELO = %.2f", strongerElo, weakerElo));

    double defaultStrongerElo = strongerElo, defaultWeakerElo = weakerElo;
    double simpleStrongerElo = strongerElo, simpleWeakerElo = weakerElo;

    for (int i = 0; i < 200; i++) {
      double newDefaultStrongerElo = defaultEloPerformanceRating.calculateNewQuotation(defaultStrongerElo, defaultWeakerElo, K_FACTOR, 1);
      double newSimpleStrongerElo = simpleEloPerformanceRating.calculateNewQuotation(simpleStrongerElo, simpleWeakerElo, K_FACTOR, 1);

      double newDefaultWeakerElo = defaultEloPerformanceRating.calculateNewQuotation(defaultWeakerElo, defaultStrongerElo, K_FACTOR, 2);
      double newSimpleWeakerElo = simpleEloPerformanceRating.calculateNewQuotation(simpleWeakerElo, simpleStrongerElo, K_FACTOR, 2);

      System.out.println(String.format("%.2f", newSimpleWeakerElo));
      defaultStrongerElo = newDefaultStrongerElo;
      simpleStrongerElo = newSimpleStrongerElo;

      defaultWeakerElo = newDefaultWeakerElo;
      simpleWeakerElo = newSimpleWeakerElo;
    }
  }
}