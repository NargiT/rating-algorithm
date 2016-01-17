package fr.nargit.game.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * (c) 17-janv.-2016
 *
 * @author NargiT
 */
public class Tournament {
  private final Set<Player> participants;
  private final List<Match> matches;

  public Tournament(Player ... players) {
    participants = new HashSet<>(Arrays.asList(players));
    matches = new LinkedList<>();
  }

  public boolean hasAll(Player ... players) {
    return participants.containsAll(Arrays.asList(players));
  }

  public Set<Player> getParticipants() {
    return participants;
  }

  public List<Match> getMatches() {
    return matches;
  }

  public void addParticipant(final Player player) {
    participants.add(player);
  }

  public boolean addMatch(final Match match) {
    return matches.add(match);
  }
}
