package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StatisticsTest {

    Reader readerStub = () -> {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri", "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void search() {
        assertEquals("Semenko", stats.search("Semenko").getName());
        assertNull(stats.search("Laine"));
    }

    @Test
    public void team() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void topScorers() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }
}