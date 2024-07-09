import java.util.*;

/**
 * LeagueDriver
 */
public class LeagueDriver {
  /**
   * Main method for the LeagueDriver class.
   * 
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    TeamsLeague league = new TeamsLeague("team.txt", "games.txt");
    league.quickSort(0,
        league.getNumberOfTeams() - 1);

    int teamsProcessed = league.getTeamsProcessed();
    System.out.println("Promoted");
    for (int i = league.getNumberOfTeams() - teamsProcessed; i < league.getNumberOfTeams(); i++) {
      System.out.println(league.getTeam(league.getTeamList().get(i)));
    }

    System.out.println("\nRelegation");
    for (int i = 0; i < teamsProcessed; i++) {

      System.out.println(league.getTeam(league.getTeamList().get(i)));
    }

  }

} 
