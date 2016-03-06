package fr.nargit.rating.algorihtm.elo;

import fr.nargit.rating.algorihtm.elo.performance.DefaultEloPerformance;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by NargiT on 14/01/2016
 */
public class EloAlgorithmWithDefaultEloPerformanceTest {

  public static final int K_FACTOR = 20;
  private static final double BASE_RANK = 900;
  private EloAlgorithm eloAlgorithm;

  @Before
  public void setUp() {
    eloAlgorithm = new EloAlgorithm(new DefaultEloPerformance());
  }

  @After
  public void tearDown() {

  }

  @Test
  public void test1v1Wins() {
    List<Double> opponents = Collections.singletonList(BASE_RANK);

    double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1, K_FACTOR);
    double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 2, K_FACTOR);

    Assert.assertThat(player1NewQuotation, Matchers.greaterThan(player2NewQuotation));
    Assert.assertThat(player1NewQuotation + player2NewQuotation, Matchers.is(0.0));
  }

  @Test
  public void test1v1Draw() {
    List<Double> opponents = Collections.singletonList(BASE_RANK);

    double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1.5, K_FACTOR);
    double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1.5, K_FACTOR);

    Assert.assertThat(player1NewQuotation, Matchers.is(player2NewQuotation));
    Assert.assertThat(player1NewQuotation + player2NewQuotation, Matchers.is(0.0));
  }

  @Test
  public void testEloForMultiplayerWithoutDraws() {
    final int NB_OPPONENTS = 6;
    List<Double> opponents = new LinkedList<>();
    for (int i = 0; i < NB_OPPONENTS; i++) {
      opponents.add(BASE_RANK);
    }

    double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1, K_FACTOR);
    double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 2, K_FACTOR);
    double player3NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 3, K_FACTOR);
    double player4NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 4, K_FACTOR);
    double player5NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 5, K_FACTOR);
    double player6NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 6, K_FACTOR);
    double player7NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 7, K_FACTOR);

    Assert.assertThat(player1NewQuotation, Matchers.greaterThan(player2NewQuotation));
    Assert.assertThat(player2NewQuotation, Matchers.greaterThan(player3NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.greaterThan(player4NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.greaterThan(player5NewQuotation));
    Assert.assertThat(player5NewQuotation, Matchers.greaterThan(player6NewQuotation));
    Assert.assertThat(player6NewQuotation, Matchers.greaterThan(player7NewQuotation));

    double sum = player1NewQuotation + player2NewQuotation + player3NewQuotation + player4NewQuotation +
        player5NewQuotation + player6NewQuotation + player7NewQuotation;
    // the calculus is not very precise ....
    Assert.assertThat(sum, Matchers.lessThan(0.000000000));
    Assert.assertThat((int) sum, Matchers.is(0));
    Assert.assertThat(player1NewQuotation, CoreMatchers.is(K_FACTOR / 2.0));
  }

  @Test
  public void testEloForMultiplayerWithDraws() {
    final int NB_OPPONENTS = 6;
    List<Double> opponents = new LinkedList<>();
    for (int i = 0; i < NB_OPPONENTS; i++) {
      opponents.add(BASE_RANK);
    }

    double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 1, K_FACTOR);
    double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 2, K_FACTOR);
    double player3NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 3.5, K_FACTOR);
    double player4NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 3.5, K_FACTOR);
    double player5NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 5, K_FACTOR);
    double player6NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 6.5, K_FACTOR);
    double player7NewQuotation = eloAlgorithm.calculateDeltaQuotation(BASE_RANK, opponents, 6.5, K_FACTOR);

    double sum = player1NewQuotation + player2NewQuotation + player3NewQuotation + player4NewQuotation +
        player5NewQuotation + player6NewQuotation + player7NewQuotation;

    Assert.assertThat(player1NewQuotation, Matchers.greaterThan(player2NewQuotation));
    Assert.assertThat(player2NewQuotation, Matchers.greaterThan(player3NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.equalTo(player4NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.greaterThan(player5NewQuotation));
    Assert.assertThat(player5NewQuotation, Matchers.greaterThan(player6NewQuotation));
    Assert.assertThat(player6NewQuotation, Matchers.equalTo(player7NewQuotation));

    // the calculus is not very precise ....
    Assert.assertThat(sum, Matchers.lessThan(1.0));
    Assert.assertThat((int) sum, Matchers.is(0));
    Assert.assertThat(player1NewQuotation, CoreMatchers.is(K_FACTOR / 2.0));
  }

  @Test
  public void testEloForMultiplayerWithEverything() {
    final double quotation1 = 1000L;
    final double quotation2 = 1400L;
    final double quotation3 = 1800L;
    final double quotation4 = 1540L;
    final double quotation5 = 1000L;
    final double quotation6 = 980L;
    final double quotation7 = 950L;

    List<Double> allQuotations = Arrays.asList(quotation1, quotation2, quotation3,
        quotation4, quotation5, quotation6, quotation7);

    double player1NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation1, getOpponents(quotation1,
        allQuotations), 1, K_FACTOR);
    double player2NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation2, getOpponents(quotation2,
        allQuotations), 2, K_FACTOR);
    double player3NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation3, getOpponents(quotation3,
        allQuotations), 3.5, K_FACTOR);
    double player4NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation4, getOpponents(quotation4,
        allQuotations), 3.5, K_FACTOR);
    double player5NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation5, getOpponents(quotation5,
        allQuotations), 5, K_FACTOR);
    double player6NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation6, getOpponents(quotation6,
        allQuotations), 6.5, K_FACTOR);
    double player7NewQuotation = eloAlgorithm.calculateDeltaQuotation(quotation7, getOpponents(quotation7,
        allQuotations), 6.5, K_FACTOR);

    double sum = player1NewQuotation + player2NewQuotation + player3NewQuotation + player4NewQuotation +
        player5NewQuotation + player6NewQuotation + player7NewQuotation;

    Assert.assertThat(player1NewQuotation, Matchers.greaterThan(player2NewQuotation));
    Assert.assertThat(player2NewQuotation, Matchers.greaterThan(player3NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.lessThan(player4NewQuotation));
    Assert.assertThat(player3NewQuotation, Matchers.lessThan(player5NewQuotation));
    Assert.assertThat(player5NewQuotation, Matchers.greaterThan(player6NewQuotation));
    Assert.assertThat(player6NewQuotation, Matchers.lessThan(player7NewQuotation));

    // the calculus is not very precise ....
    Assert.assertThat(sum, Matchers.lessThan(0.1));
    Assert.assertThat((int) sum, Matchers.is(0));
  }

  private List<Double> getOpponents(double targetQuotation, List<Double> quotations) {
    List<Double> opponentQuotations = new LinkedList<>(quotations);
    for (Double quotation : opponentQuotations) {
      if (targetQuotation == quotation) {
        opponentQuotations.remove(quotation);
        break;
      }
    }
    return opponentQuotations;
  }

}