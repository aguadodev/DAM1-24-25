package Util;

public class Jugador {
    String username;
    int gamesWon;
    int gamesPlayed;


    public Jugador(String username, int gamesWon, int gamesPlayed) {
        this.username = username;
        this.gamesWon = gamesWon;
        this.gamesPlayed = gamesPlayed;
    }


    public String getUsername() {
        return username;
    }


    public int getGamesWon() {
        return gamesWon;
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }


    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String toString() {
        return username + "       -              " + gamesPlayed + "           -            "
                + gamesWon + "           -           " + (gamesPlayed - gamesWon)
                + "           -          " + getWinRate();
    }


    public String getWinRate() {
        double winRatio = ((double) gamesWon / (gamesPlayed != 0 ? (double) gamesPlayed : 1));
        winRatio *= 100;
        String formattedWinRatio = String.format("%.2f", winRatio);
        return formattedWinRatio + "%";
    }
}
