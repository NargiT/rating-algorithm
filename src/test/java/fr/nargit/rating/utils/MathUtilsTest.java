package fr.nargit.rating.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NargiT on 13/01/2016
 */
public class MathUtilsTest {

  @Test
  public void testRoundToHalfUp() {
    Assert.assertThat(MathUtils.roundToHalf(1.6), CoreMatchers.is(2));
  }

  @Test
  public void testRoundToHalfDown() {
    Assert.assertThat(MathUtils.roundToHalf(1.4), CoreMatchers.is(1));
  }

  @Test
  public void testRoundExactlyToHalf() {
    Assert.assertThat(MathUtils.roundToHalf(1.5), CoreMatchers.is(2));
  }

}