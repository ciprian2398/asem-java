package utility;

import soccerPack.Game;
import soccerPack.Goal;
import soccerPack.Player;
import soccerPack.Team;

import java.util.List;

public class GameUtils {
    public void addGameGoals(Game game) {
        List<Goal> goals = game.getGoals();

        for (Goal goal : goals) {
            int teamNum = (int) (Math.random() * 2);
            Team team = teamNum == 0 ? game.getHomeTeam() : game.getAwayTeam();

            int playerIndex = (int) (Math.random() * team.getTotalPlayers());
            Player player = team.getPlayer(playerIndex);

            goal.setScoredTeam(team);
            goal.setScoredPlayer(player);
            goal.setTime((Math.random() * 90));
        }
    }

}
