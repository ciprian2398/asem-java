package configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soccerPack.Game;
import soccerPack.League;
import soccerPack.Team;
import soccerPack.dataprovider.ClassDataProvider;
import soccerPack.dataprovider.DataProvider;
import utility.GameUtils;

import java.util.List;

@Configuration
public class MainBeans {

    @Bean
    public League getLeague() {
        return new League();
    }

    @Bean
    public DataProvider getDataProvider() {
        return new ClassDataProvider();
    }

    @Bean
    public GameUtils getGameUtils() {
        return new GameUtils();
    }

    @Bean
    public List<Game> getLeagueGames(League league){
        return league.createGame(league.createTeams());
    }

    @Bean
    @Autowired
    public Game getLeagueGame(List<Game> games,
                              DataProvider dataProvider,
                              GameUtils gameUtils) {

        Game game = games.get(0);

        Team homeTeam = game.getHomeTeam();
        dataProvider.getPart(1).forEach(homeTeam::addPlayer);

        Team awayTeam = game.getAwayTeam();
        dataProvider.getPart(2).forEach(awayTeam::addPlayer);

        game.playGame();
        gameUtils.addGameGoals(game);

        return game;
    }
}
