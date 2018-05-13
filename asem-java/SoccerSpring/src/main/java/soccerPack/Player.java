package soccerPack;

public class Player {
    private String namePlayer;

    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String name) {
        this.namePlayer = namePlayer;
    }

    @Override
    public String toString() {
        return "{" + namePlayer + '}';
    }
}
