import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class represents a league of teams.
 */

public class TeamsLeague {

  /**
   * This class represents a Team in the league.
   * It implements Comparable interface to compare teams based on their points.
   */
  private class Team
      implements Comparable<Team> {
    private String teamName;
    private int wins;
    private int losses;
    private int ties;
    private int points;
    private int goalsScored;
    private int goalsAllowed;
    private int teamNumber;

    /**
     * Constructor for the Team class.
     * Initializes the team with the given name and zero wins, losses, ties, and
     * points.
     *
     * @param teamName The name of the team.
     */
    public Team(String teamName) {
      this.teamName = teamName;
      this.wins = 0;
      this.losses = 0;
      this.ties = 0;
      this.points = 0;
    }

    /**
     * Compares this team to another team based on their points.
     * Returns a positive integer if this team has more points, 0 if equal, and a
     * negative integer if less.
     *
     * @param o The other team to compare to.
     * @return A positive integer if this team has more points, 0 if equal, and a
     *         negative integer if less.
     */
    @Override
    public int compareTo(TeamsLeague.Team o) {
      if (this.points > o.points) {
        return 1;
      } else if (this.goalsScored > o.goalsScored) {
        return 1;
      } else if (this.goalsAllowed < o.goalsAllowed) {
        return 1;
      } else if (this.teamNumber < o.teamNumber) {
        return 1;

      } else {
        return -1;
      }

    }

    /*
     * Compares this team to another object for equality.
     * Returns true if the other object is a team with the same name, false
     * otherwise.
     * 
     * @param obj The other object to compare to.
     * 
     * @return True if the other object is a team with the same name, false
     * otherwise.
     */
    @Override
    public boolean equals(Object obj) {

      return super.equals(obj);
    }

    /*
     * Returns a hash code for this team.
     * 
     * @return A hash code for this team.
     */
    @Override
    public int hashCode() {

      return super.hashCode();
    }

    /*
     * Returns a string representation of this team.
     * 
     * @return A string representation of this team.
     */
    public String toString() {
      return String.format("%-20s %3d %3d %3d", this.teamName, this.points, this.goalsScored, this.goalsAllowed);
    }
  }

  private HashMap<Integer, Team> teams = new HashMap<>();
  private int numberOfTeams;
  private int teamsProcessed;
  private ArrayList<Integer> teamList = new ArrayList<>(numberOfTeams);

  /**
   * Constructor for the TeamsLeague class.
   * Initializes the league by reading team data from a file.
   * 
   * @param teamFile the name of the file containing team data.
   * @param gameFile the name of the file containing game data.
   */

  public TeamsLeague(String teamFile, String gameFile) {

    File teamsFile = new File(teamFile);
    Scanner teamInput = null;
    try {
      teamInput = new Scanner(teamsFile);
    } catch (Exception e) {
      System.out.println("File not found");
    }
    String details = teamInput.nextLine();
    Scanner detailsScanner = new Scanner(details);
    numberOfTeams = Integer.parseInt(detailsScanner.next());
    teamsProcessed = Integer.parseInt(detailsScanner.next());
    while (teamInput.hasNextLine()) {
      String lineString = teamInput.nextLine();
      Scanner lineScanner = new Scanner(lineString);
      String temp = lineScanner.next();
      int teamNumber = Integer.parseInt(temp.trim().substring(0, temp.length() - 1));
      String teamName = lineScanner.nextLine().trim();
      Team team = new Team(teamName);
      teams.put(teamNumber, team);
      teams.get(teamNumber).teamNumber = teamNumber;
      teamList.add(teamNumber);
    }
    teamInput.close();

    File gamesFile = new File(gameFile);
    Scanner gamesInput = null;
    try {
      gamesInput = new Scanner(gamesFile);
    } catch (Exception e) {
      System.out.println("File not found");
    }
    while (gamesInput.hasNextLine()) {
      String lineString = gamesInput.nextLine();
      Scanner lineScanner = new Scanner(lineString);
      int team1 = lineScanner.nextInt();
      int team2 = lineScanner.nextInt();
      int score1 = lineScanner.nextInt();
      int score2 = lineScanner.nextInt();
      processTeams(score1, score2, team1, team2);
      lineScanner.close();
    }
    gamesInput.close();

  }

  /**
   * Processes the teams based on the scores of the games.
   * 
   * @param score1 the score of the first team.
   * @param score2 the score of the second team.
   * @param team1  the number of the first team.
   * @param team2  the number of the second team.
   */
  private void processTeams(int score1, int score2, int team1, int team2) {
    if (score1 > score2) {
      teams.get(team1).wins++;
      teams.get(team1).points += 3;
      teams.get(team2).losses++;
    } else if (score1 < score2) {
      teams.get(team2).wins++;
      teams.get(team2).points += 3;
      teams.get(team1).losses++;

    } else {
      teams.get(team1).ties++;
      teams.get(team2).ties++;
      teams.get(team1).points++;
      teams.get(team2).points++;
    }
    teams.get(team1).goalsScored += score1;
    teams.get(team1).goalsAllowed += score2;
    teams.get(team2).goalsScored += score2;
    teams.get(team2).goalsAllowed += score1;

  }

  /**
   * Sorts an array of teams using the quick sort algorithm.
   * 
   * @param low  the lowest index of the array to sort.
   * @param high the highest index of the array to sort.
   */
  public void quickSort(int low, int high) {
    int pivot = 0;
    if ((teamList.get(high).compareTo(teamList.get(low)) < 0)) {

      pivot = partition(low, high);
      quickSort(low, pivot - 1);
      quickSort(pivot + 1, high);
    }

  }

  /**
   * Partitions the array of teams for quick sort.
   * 
   * @param low  the lowest index of the array to sort.
   * @param high the highest index of the array to sort.
   * @return the index of the pivot item.
   */
  private int partition(int low, int high) {
    Team pivotItem = teams.get(teamList.get(low));
    int j = low;
    for (int i = low + 1; i <= high; i++) {
      if (teams.get(teamList.get(i)).compareTo(pivotItem) < 0) {
        j++;
        int temp = teamList.get(i);
        teamList.set(i, teamList.get(j));
        teamList.set(j, temp);
      }
    }

    int temp = teamList.get(j);
    teamList.set(j, teamList.get(low));
    teamList.set(low, temp);

    return j;
  }

  /**
   * Returns numbers of teams in the league.
   * 
   * @return the number of teams in the league.
   */
  public int getNumberOfTeams() {
    return numberOfTeams;
  }

  /**
   * Returns the list of teams in the league.
   * 
   * @return the list of teams in the league.
   */
  public ArrayList<Integer> getTeamList() {
    return teamList;
  }

  /**
   * Returns the name of the team.
   * 
   * @param teamNumber the number of the team.
   * @return the name of the team.
   */
  public String getTeamName(int teamNumber) {
    return teams.get(teamNumber).teamName;
  }

  /**
   * Returns the number of points of the team.
   * 
   * @param teamNumber the number of the team.
   * @return the number of points of the team.
   */
  public int getPoints(int teamNumber) {
    return teams.get(teamNumber).wins * 3 + teams.get(teamNumber).ties;
  }

  /**
   * Returns the number of goals scored by the team.
   * 
   * @param teamNumber the number of the team.
   * @return the number of goals scored by the team.
   */
  public int getGoalsScored(int teamNumber) {
    return teams.get(teamNumber).goalsScored;
  }

  /**
   * Returns the team number of the team.
   * 
   * @param teamNumber the number of the team.
   * @return the number of goals allowed by the team.
   */
  public int getTeamNumber(int teamNumber) {
    return teams.get(teamNumber).teamNumber;
  }

  /**
   * Returns the number of goals allowed by the team.
   * 
   * @param teamNumber the number of the team.
   * @return the number of goals allowed by the team.
   */
  public int getGoalsAllowed(int teamNumber) {
    return teams.get(teamNumber).goalsAllowed;
  }

  /**
   * Returns the number of teams processed.
   * 
   * @return the number of teams processed.
   */
  public int getTeamsProcessed() {
    return teamsProcessed;
  }

  /**
   * Returns the team at the given index.
   * 
   * @param i the index of the team.
   * @return the team at the given index.
   */

  public Team getTeam(int i) {
    return teams.get(i);
  }
}