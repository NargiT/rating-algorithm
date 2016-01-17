package fr.nargit.game;

import org.hamcrest.CoreMatchers;
import org.junit.*;

/**
 * Created by NargiT on 13/01/2016
 */
public class EloAlgorithmTest {

  public static final int K_FACTOR = 15;
  private EloAlgorithm eloAlgorithm ;
  public static final int WEAKER_ELO = 1800;
  public static final int STRONGER_ELO = 2005;
  public static final int EQUIVALENT_ELO = 1400;

  @Before
  public void setUp() throws Exception {
    eloAlgorithm = new EloAlgorithm(new StubEloPerformanceRating());
  }

  @After
  public void tearDown() throws Exception {

  }


  @Test
  public void testEloDraw() throws Exception {
    double weakerResults = eloAlgorithm.calculateNewElo(WEAKER_ELO, STRONGER_ELO, K_FACTOR, EloAlgorithm.Result.DRAW);
    int weakerExpectedResult = 1804;
    verifyResult(weakerResults, weakerExpectedResult);

    double strongerResults = eloAlgorithm.calculateNewElo(STRONGER_ELO, WEAKER_ELO, K_FACTOR, EloAlgorithm.Result.DRAW);
    int strongerExpectedResult = 2001;
    verifyResult(strongerResults, strongerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int)(weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  @Test
  public void testEloWeakerWins() throws Exception {
    double weakerResults = eloAlgorithm.calculateNewElo(WEAKER_ELO, STRONGER_ELO, K_FACTOR, EloAlgorithm.Result.WIN);
    int weakerExpectedResult = 1811;
    verifyResult(weakerResults, 1811);

    double strongerResults = eloAlgorithm.calculateNewElo(STRONGER_ELO, WEAKER_ELO, K_FACTOR, EloAlgorithm.Result.LOOSE);
    int strongerExpectedResult = 1994;
    verifyResult(strongerResults, strongerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int)(weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  @Test
  public void testEloStrongerWins() throws Exception {
    double strongerResults = eloAlgorithm.calculateNewElo(STRONGER_ELO, WEAKER_ELO, K_FACTOR, EloAlgorithm.Result.WIN);
    int strongerExpectedResult = 2009;
    verifyResult(strongerResults, strongerExpectedResult);

    double weakerResults = eloAlgorithm.calculateNewElo(WEAKER_ELO, STRONGER_ELO, K_FACTOR, EloAlgorithm.Result.LOOSE);
    int weakerExpectedResult = 1796;
    verifyResult(weakerResults, weakerExpectedResult);

    int expectedResult = weakerExpectedResult + strongerExpectedResult;
    int actualResult = (int)(weakerResults + strongerResults);
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));
  }

  @Test
  public void testEloEquivalentDraw() throws Exception {
    double player1Result = eloAlgorithm.calculateNewElo(EQUIVALENT_ELO, EQUIVALENT_ELO, K_FACTOR, EloAlgorithm.Result.DRAW);
    int player1ExpectedResult = 1400;
    verifyResult(player1Result, player1ExpectedResult);
  }

  @Test
  public void testEloEquivalentWin() throws Exception {
    double player1Result = eloAlgorithm.calculateNewElo(EQUIVALENT_ELO, EQUIVALENT_ELO, K_FACTOR, EloAlgorithm.Result.WIN);
    int player1ExpectedResult = 1408;
    verifyResult(player1Result, player1ExpectedResult);

    double player2Result = eloAlgorithm.calculateNewElo(EQUIVALENT_ELO, EQUIVALENT_ELO, K_FACTOR, EloAlgorithm.Result.LOOSE);
    int player2ExpectedResult = 1393;
    verifyResult(player2Result, player2ExpectedResult);

    int expectedResult = player1ExpectedResult + player2ExpectedResult ;
    int actualResult = (int)(player1Result + player2Result) + 1;// because 0.5 is round up
    Assert.assertThat(actualResult, CoreMatchers.is(expectedResult));

  }

  public static void verifyResult(double actual, int expected) {
    Assert.assertThat(MathUtils.roundToHalf(actual), CoreMatchers.is(expected));
  }
}