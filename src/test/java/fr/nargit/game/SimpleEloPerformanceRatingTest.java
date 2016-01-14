package fr.nargit.game;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by NargiT on 13/01/2016
 */
public class SimpleEloPerformanceRatingTest {

  private SimpleEloPerformanceRating simpleEloPerformanceRating;
  @Before
  public void setUp() throws Exception {
    simpleEloPerformanceRating = new SimpleEloPerformanceRating();
  }

  @Test
  public void testGetBestProbability() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(800);
    Assert.assertThat(winningProbability, CoreMatchers.is(1.0));
  }

  @Test
  public void testGetBestProbability2() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(1900);
    Assert.assertThat(winningProbability, CoreMatchers.is(1.0));
  }

  @Test
  public void testGetWorstProbability() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(-800);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.0));
  }

  @Test
  public void testGetWorstProbability2() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(-1900);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.0));
  }

  @Test
  public void testGetEvenProbability() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(0);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.5));
  }

  @Test
  public void testGetSomeProbability() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(236);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.8));
  }

  @Test
  public void testGetSomeProbability2() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(150);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.8));
  }

  @Test
  public void testGetSomeProbability3() throws Exception {
    double winningProbability = simpleEloPerformanceRating.getWinningProbability(-150);
    Assert.assertThat(winningProbability, CoreMatchers.is(0.3));
  }
}