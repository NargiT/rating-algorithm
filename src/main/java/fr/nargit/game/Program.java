package fr.nargit.game;

import fr.nargit.game.domain.Match;
import fr.nargit.game.domain.Player;

import java.util.Date;
import java.util.List;

/**
 * (c) 17-janv.-2016
 *
 * @author tigran-mac
 */
public class Program {

  public static void main(String[] args) {
    // Create Players
    Player michael = new Player("michael");
    Player tigran = new Player("tigran");
    Player nico = new Player("nico");
    Player quentin = new Player("quentin");

    // Create Tournament
    TournamentManagement tournamentManagement = new TournamentManagement(michael, tigran, nico, quentin);

    // Add matches
    Date today = new Date();
    tournamentManagement.createMatch(today, tigran, michael);
    tournamentManagement.createMatch(today, nico, quentin);
    tournamentManagement.createMatch(today, michael, quentin);
    tournamentManagement.createMatch(today, nico, tigran);
    tournamentManagement.createMatch(today, michael, nico);
    tournamentManagement.createMatch(today, quentin, tigran);

    showTournament(tournamentManagement);
  }

  private static void showTournament(TournamentManagement tournamentManagement) {
    int i = 0;
    for (Match match : tournamentManagement.getMatches()) {
      System.out.println(String.format("Match %d: all players %s", i, match.getPlayers()));
      System.out.println(String.format("Winners : %s", match.getWinners()));
      System.out.println(String.format("Losers  : %s", match.getLosers()));
      System.out.println(String.format("Draw    : %s \n", match.getDraws()));
      i++;
    }
  }
}
