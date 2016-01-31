package fr.nargit.game;

import fr.nargit.game.domain.Match;
import fr.nargit.game.domain.Player;
import fr.nargit.game.domain.Tournament;

import java.util.Date;
import java.util.List;

/**
 * (c) 17-janv.-2016
 *
 * @author tigran-mac
 */
public class TournamentManagement {

  private final Tournament tournament;

  public TournamentManagement(Player... players) {
    tournament = new Tournament(players);
  }

  public boolean createMatch(Date matchDate, Player... players) {
    if (tournament.hasAll(players)) {
      Match match = new Match(matchDate, players);
      return tournament.addMatch(match);
    }
    return false;
  }

  public List<Match> getMatches() {
    return tournament.getMatches();
  }
}
