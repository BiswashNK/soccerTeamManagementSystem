eamsLeague
Overview

The TeamsLeague project is a Java-based sports league management system. It reads team and game data from files and processes the results of games to update the league standings. Teams are ranked based on their performance in games (wins, losses, ties, goals scored/allowed). The project implements the quick sort algorithm to sort teams based on their points and other criteria, and displays teams eligible for promotion and relegation.
Features

    Team Management: Automatically manages and tracks teams' wins, losses, ties, goals scored, and goals allowed.
    Game Processing: Updates team performance based on the game outcomes.
    Sorting: Implements the Quick Sort algorithm to rank teams based on points, goals scored/allowed, and team numbers.
    File-Based Input: Reads team and game data from external files (team.txt and games.txt).
    Promotion & Relegation: Displays teams eligible for promotion and relegation based on their performance.

Technologies Used

    Java: Main programming language used for the project.
    Java Swing: For GUI if needed.
    File Handling: Java Scanner class to read data from text files.

Files Required

    team.txt: A file containing information about the teams in the league.
    games.txt: A file containing the results of games between teams.

Sample File Format

team.txt:

```
4 2  // numberOfTeams teamsProcessed
1. Team A
2. Team B
3. Team C
4. Team D
```
games.txt:
```
1 2 3 2  // Team 1 vs Team 2, Score: 3-2
3 4 1 1  // Team 3 vs Team 4, Score: 1-1
```
Installation

Clone the repository:

 
```
git clone https://github.com/yourusername/teams-league.git
```
Navigate to the project directory:
```
cd teams-league
```
Compile the Java files:
```
javac TeamsLeague.java LeagueDriver.java
```
Ensure team.txt and games.txt are present in the directory.

Run the program:

    java LeagueDriver

How to Use

    Add Teams: The program reads the list of teams from the team.txt file.
    Process Games: The games.txt file contains results of games, which the program reads to update team stats.
    Rank Teams: The teams are sorted using Quick Sort based on their points and additional criteria such as goals scored and allowed.
    Display Results: After sorting, teams are categorized as either promoted or relegated based on their rankings.

Example Output

```
Promoted
Team B        Points: 9  Goals Scored: 10  Goals Allowed: 3
Team A        Points: 7  Goals Scored: 8   Goals Allowed: 5

Relegation
Team C        Points: 3  Goals Scored: 6   Goals Allowed: 8
Team D        Points: 1  Goals Scored: 4   Goals Allowed: 10
```
Future Improvements

    Add a GUI for easier user interaction using Swing.
    Support for more file formats such as CSV or JSON for team and game data.
    Add more complex sorting options and tie-breaking rules.

License

This project is licensed under the MIT License - see the LICENSE file for details.
Contributions

Contributions are welcome! Feel free to submit issues or pull requests.
