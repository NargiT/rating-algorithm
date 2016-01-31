package fr.nargit.game.ranking.algorihtm.elo.performance;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matchers;

/**
 * Created by NargiT on 13/01/2016
 */
public class DefaultEloPerformanceTest {

  private DefaultEloPerformance defaultEloPerformance;

  @Before
  public void setUp() {
    defaultEloPerformance = new DefaultEloPerformance();
  }

  @Test
  public void testGetBestProbability() {
    double winningProbability = defaultEloPerformance.getWinningProbability(1000, 200);
    Assert.assertThat(winningProbability, Matchers.lessThan(1.0));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.9));
  }

  @Test
  public void testGetBestProbability2() {
    double winningProbability = defaultEloPerformance.getWinningProbability(1900, 0);
    Assert.assertThat(winningProbability, Matchers.lessThan(1.0));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.9));
  }

  @Test
  public void testGetWorstProbability() {
    double winningProbability = defaultEloPerformance.getWinningProbability(200, 1000);
    Assert.assertThat(winningProbability, Matchers.lessThan(0.01));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.009));
  }

  @Test
  public void testGetWorstProbability2() {
    double winningProbability = defaultEloPerformance.getWinningProbability(0, 1900);
    Assert.assertThat(winningProbability, Matchers.lessThan(0.01));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.00));
  }

  @Test
  public void testGetEvenProbability() {
    double winningProbability = defaultEloPerformance.getWinningProbability(100, 100);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.5));
  }

  @Test
  public void testGetSomeProbability() {
    double winningProbability = defaultEloPerformance.getWinningProbability(236, 0);
    Assert.assertThat(winningProbability, Matchers.lessThan(0.8));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.7));
  }

  @Test
  public void testGetSomeProbability2() {
    double winningProbability = defaultEloPerformance.getWinningProbability(150, 0);
    Assert.assertThat(winningProbability, Matchers.lessThan(0.8));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.7));
  }

  @Test
  public void testGetSomeProbability3() {
    double winningProbability = defaultEloPerformance.getWinningProbability(0, 150);
    Assert.assertThat(winningProbability, Matchers.lessThan(0.3));
    Assert.assertThat(winningProbability, Matchers.greaterThan(0.2));
  }
}