package ohtuesimerkki.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerReader implements Reader {

    static final int N_PARTS = 3;
    static final int PART_GOALS = 3;
    static final int PART_ASSISTS = 4;

    private Scanner scanner;

    public PlayerReader(String pageUrl) {
        try {
            URL url = new URL(pageUrl);
            scanner = new Scanner(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(";");

            if (parts.length > N_PARTS) {
                players.add(new Player(parts[0].trim(), parts[1], extractInt(parts[PART_GOALS]), extractInt(parts[PART_ASSISTS])));
            }
        }

        return players;
    }

    private int extractInt(String str) {
        return Integer.parseInt(str.trim());
    }
}
