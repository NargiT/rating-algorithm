package fr.nargit.game.ranking.algorihtm.elo.performance;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by NargiT on 13/01/2016
 */
public class SimpleEloPerformanceTest {

  private SimpleEloPerformance simpleEloPerformance;

  @Before
  public void setUp() {
    simpleEloPerformance = new SimpleEloPerformance();
  }

  @Test
  public void testGetBestProbability() {
    double winningProbability = simpleEloPerformance.getWinningProbability(1000, 200);
    Assert.assertThat(winningProbability, CoreMatchers.is(1.0));
  }

  @Test
  public void testGetBestProbability2() {
    double winningProbability = simpleEloPerformance.getWinningProbability(1900, 0);
    Assert.assertThat(winningProbability, CoreMatchers.is(1.0));
  }

  @Test
  public void testGetWorstProbability() {
    double winningProbability = simpleEloPerformance.getWinningProbability(200, 1000);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.0));
  }

  @Test
  public void testGetWorstProbability2() {
    double winningProbability = simpleEloPerformance.getWinningProbability(0, 1900);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.0));
  }

  @Test
  public void testGetEvenProbability() {
    double winningProbability = simpleEloPerformance.getWinningProbability(100, 100);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.5));
  }

  @Test
  public void testGetSomeProbability() {
    double winningProbability = simpleEloPerformance.getWinningProbability(236, 0);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.8));
  }

  @Test
  public void testGetSomeProbability2() {
    double winningProbability = simpleEloPerformance.getWinningProbability(150, 0);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.8));
  }

  @Test
  public void testGetSomeProbability3() {
    double winningProbability = simpleEloPerformance.getWinningProbability(0, 150);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.3));
  }
}