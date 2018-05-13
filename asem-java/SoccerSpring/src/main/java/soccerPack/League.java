package soccerPack;

import java.util.ArrayList;
import java.util.List;

public class League {

    public List<Team> createTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(new Team("Real Madrid"));
        teams.add(new Team("Paris Saint Germain"));
        return teams;
    }

    public List<Game> createGame(List<Team> teams) {
        List<Game> games = new ArrayList<Game>();
        games.add(new Game(teams.get(0), teams.get(1)) );
        return games;
    }
}
