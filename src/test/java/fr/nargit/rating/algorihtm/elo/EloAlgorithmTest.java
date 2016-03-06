package fr.nargit.rating.algorihtm.elo;

import fr.nargit.rating.algorihtm.elo.performance.StubEloPerformance;
import fr.nargit.rating.utils.MathUtils;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by NargiT on 13/01/2016
 */
public class EloAlgorithmTest {

  public static final int K_FACTOR = 15;
  public static final int WEAKER_ELO = 1800;
  public static final int STRONGER_ELO = 2005;
  public static final int EQUIVALENT_ELO = 1400;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() {
    eloAlgorithm = new EloAlgorithm(new StubEloPerformance());
  }

  @After
  public void tearDown() {

  }


  @Test
  public void testEloDraw() {
    double weakerResults = eloAlgorithm.calculateNewQuotation(WEAKER_ELO, STRONGER_ELO, 1.5, K_FACTOR);
    int weakerExpectedResult = 1804;
    verifyResult(weakerResults, weakerExpectedResult);

    double strongerResults = eloAlgorithm.calculateNewQuotation(STRONGER_ELO, WEAKER_ELO, 1.5, K_FACTOR);
    int strongerExpectedResult = 2001;
    verifyResult(strongerResults, strongerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int) (weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  public static void verifyResult(double actual, int expected) {
    Assert.assertThat(MathUtils.roundToHalf(actual), CoreMatchers.is(expected));
  }

  @Test
  public void testEloWeakerWins() {
    double weakerResults = eloAlgorithm.calculateNewQuotation(WEAKER_ELO, STRONGER_ELO, 1, K_FACTOR);
    int weakerExpectedResult = 1811;
    verifyResult(weakerResults, 1811);

    double strongerResults = eloAlgorithm.calculateNewQuotation(STRONGER_ELO, WEAKER_ELO, 2, K_FACTOR);
    int strongerExpectedResult = 1994;
    verifyResult(strongerResults, strongerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int) (weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  @Test
  public void testEloStrongerWins() {
    double strongerResults = eloAlgorithm.calculateNewQuotation(STRONGER_ELO, WEAKER_ELO, 1, K_FACTOR);
    int strongerExpectedResult = 2009;
    verifyResult(strongerResults, strongerExpectedResult);

    double weakerResults = eloAlgorithm.calculateNewQuotation(WEAKER_ELO, STRONGER_ELO, 2, K_FACTOR);
    int weakerExpectedResult = 1796;
    verifyResult(weakerResults, weakerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int) (weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  @Test
  public void testEloEquivalentDraw() {
    double player1Result = eloAlgorithm.calculateNewQuotation(EQUIVALENT_ELO, EQUIVALENT_ELO, 1.5, K_FACTOR);
    int player1ExpectedResult = 1400;
    verifyResult(player1Result, player1ExpectedResult);
  }

  @Test
  public void testEloEquivalentWin() {
    double player1Result = eloAlgorithm.calculateNewQuotation(EQUIVALENT_ELO, EQUIVALENT_ELO, 1, K_FACTOR);
    int player1ExpectedResult = 1408;
    verifyResult(player1Result, player1ExpectedResult);

    double player2Result = eloAlgorithm.calculateNewQuotation(EQUIVALENT_ELO, EQUIVALENT_ELO, 2, K_FACTOR);
    int player2ExpectedResult = 1393;
    verifyResult(player2Result, player2ExpectedResult);

    int expectedResult = player1ExpectedResult + player2ExpectedResult;
    int actualResult = (int) (player1Result + player2Result) + 1;// because 0.5 is round up
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));

  }
}