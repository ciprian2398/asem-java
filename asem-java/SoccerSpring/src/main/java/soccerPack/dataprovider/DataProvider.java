package soccerPack.dataprovider;

import soccerPack.Player;

import java.util.List;

public interface DataProvider {
    List<Player> getPart(int part);
}
