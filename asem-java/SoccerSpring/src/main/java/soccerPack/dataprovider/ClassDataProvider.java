package soccerPack.dataprovider;

import soccerPack.Player;

import java.util.ArrayList;
import java.util.List;

public class ClassDataProvider implements DataProvider{

    public List<Player> getPart(int part) {  // 1 || 2
        List<Player> players = listOfPlayers();

        if (part == 1) {
            return players.subList(0, players.size() / 2);
        } else if (part == 2) {
            return players.subList(players.size() / 2, players.size());
        }
        return null;
    }


    private List<Player> listOfPlayers() {
        List<Player> players = new ArrayList<>();
        listOfNames().forEach(name -> players.add(new Player(name)));
        return players;
    }


    private List<String> listOfNames() {
        List<String> players = new ArrayList<String>();
        players.add("Radison Blue");
        players.add("Tyron Tapscott");
        players.add("Lynn Lisenby");
        players.add("Johnathan Jesse");
        players.add("Sebastian Salmon");
        players.add("Raul Roberge");
        players.add("Leslie Lanctot");
        players.add("Luther Leiser");
        players.add("Lyman Losh ");
        players.add("Shelby Steigerwald");
        players.add("Brendan Borges ");
        players.add("Sang Swinger");
        players.add("Denny Damico");
        players.add("Daren Dahn");
        players.add("Francisco Flesher");
        players.add("Elwood Echavarria");
        players.add("Toby Theriot ");
        players.add("Aldo Alcantar");
        players.add("Pedro Peck");
        players.add("Mitchell Mclaughin");
        players.add("Troy Trentham");
        players.add("Jacob John");
        return players;
    }
}
