package fr.nargit.game.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * (c) 17-janv.-2016
 *
 * @author NargiT
 */
public class Match {
  private Set<Player> players;
  private Set<Player> losers;
  private Set<Player> winners;
  private Set<Player> draws;
  private Date date;

  public Match(Date date, Player... players) {
    this.date = date;
    if (players.length > 0) {
      this.players = new HashSet<>(Arrays.asList(players));
    }
    losers = new HashSet<>();
    winners = new HashSet<>();
    draws = new HashSet<>();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void addWinner(Player newWinner) {
    if (players.contains(newWinner)) {
      winners.add(newWinner);
      draws.remove(newWinner);
      losers.remove(newWinner);
    }
  }

  public void addLoser(Player newLooser) {
    if (players.contains(newLooser)) {
      losers.add(newLooser);
    }
  }

  public void addDraw(Player newDrawPlayer) {
    if (players.contains(newDrawPlayer)) {
      draws.add(newDrawPlayer);
    }
  }

  public Set<Player> getPlayers() {
    return players;
  }

  public Set<Player> getLosers() {
    return losers;
  }

  public Set<Player> getWinners() {
    return winners;
  }

  public Set<Player> getDraws() {
    return draws;
  }

  public Date getDate() {
    return date;
  }
}
