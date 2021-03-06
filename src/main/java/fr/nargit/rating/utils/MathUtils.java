package fr.nargit.rating.utils;

/**
 * Created by NargiT on 13/01/2016
 */
public class MathUtils {

  private MathUtils() {
  }

  public static int roundToHalf(double value) {
    double decimals = value - (long) value;
    if (decimals >= 0.5) {
      double roundedValue = Math.round(value * 2.0) / 2.0;
      return (int) Math.ceil(roundedValue);
    }
    return (int) value;
  }

}
