package fr.nargit.game;

import fr.nargit.game.domain.Match;
import fr.nargit.game.domain.Player;
import fr.nargit.game.domain.Tournament;

import java.util.Collections;
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

  public void updateResult(int matchId, Player winner, Player loser) {
    updateResult(matchId, Collections.singletonList(winner), Collections.singletonList(loser), Collections.EMPTY_LIST);
  }

  public void updateResult(int matchId, List<Player> winners, List<Player> losers, List<Player> draws) {
    Match match = tournament.getMatches().get(matchId);
    for (Player player : winners) {
      match.addWinner(player);
    }
    for (Player player : losers) {
      match.addLoser(player);
    }
    for (Player player : draws) {
      match.addDraw(player);
    }
  }
}
