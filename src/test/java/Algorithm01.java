import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by NargiT on 04/01/2016
 */
public class Algorithm01 {

  private static final int SIZE = Integer.MAX_VALUE/1000;

  @Test
  public void firstTest() {
    List<Integer> numbers = new LinkedList<Integer>();
    for (int i = 0; i < SIZE; i++) {
      numbers.add(i, (int) Math.random());
    }

    Instant start = Instant.now();
    Arrays.sort(numbers.toArray());
    Instant end = Instant.now();
    System.out.printf(String.valueOf(Duration.between(start, end).toMillis()));
  }
}
