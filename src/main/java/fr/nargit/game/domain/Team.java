package fr.nargit.game.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * (c) 23-janv.-2016
 *
 * @author tigran-mac
 */
public class Team {

  private Set<Player> teamates;

  public Team(Set<Player> teamates) {
    this.teamates = teamates;
  }

  public Team(Player... players) {
    this.teamates = new HashSet<>();
    Collections.addAll(this.teamates, players);
  }

  public double getQuotation() {
    double sum = 0;
    for (Player teamate : teamates) {
      sum += teamate.getQuotation();
    }
    return sum;
  }

  public boolean add(Player teammate) {
    return this.teamates.add(teammate);
  }

  public boolean remove(Player teammate) {
    return this.teamates.remove(teammate);
  }
}
