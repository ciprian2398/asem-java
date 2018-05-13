package soccerPack;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nameTeam;
    private List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public int getTotalPlayers() {
        return players.size();
    }

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String name) {
        this.nameTeam = name;
    }

    @Override
    public String toString() {
        return "{" + nameTeam + '}';
    }
}
