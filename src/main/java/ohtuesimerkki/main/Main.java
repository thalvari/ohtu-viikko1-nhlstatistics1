package ohtuesimerkki.main;

import ohtuesimerkki.Statistics;

public class Main {

    static final int HOW_MANY = 10;

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReader("http://nhlstatistics.herokuapp.com/players.txt"));
        System.out.println("Philadelphia Flyers");
        for (Player player : stats.team("PHI")) {
            System.out.println(player);
        }
        System.out.println();
        System.out.println("Top scorers");
        for (Player player : stats.topScorers(HOW_MANY)) {
            System.out.println(player);
        }
    }
}
