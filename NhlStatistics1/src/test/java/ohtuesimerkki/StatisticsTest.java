/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author perkoila
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void loytyyNimella() {
        Player p = stats.search("Semenko");

        assertEquals("Semenko", p.getName());
    }

    @Test
    public void nullJosEiLoydy() {
        Player p = stats.search("Kissa");

        assertNull(p);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        List<Player> l = stats.team("EDM");

        for (Player p : l) {
            if (p.getName().equals("Semenko")) {
                continue;
            } else if (p.getName().equals("Kurri")) {
                continue;
            } else if (p.getName().equals("Gretzky")) {
                continue;
            } else {
                fail();
            }
        }
    }
    
    @Test
    public void tyhjaListaJosEiLoydy() {
        List<Player> l = stats.team("HIV");

        assertEquals(0, l.size());
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        List<Player> l = stats.topScorers(3);
        
        if (!l.get(0).getName().equals("Gretzky")) {
            fail();
        }
        if (!l.get(1).getName().equals("Lemieux")) {
            fail();
        }
        if (!l.get(2).getName().equals("Yzerman")) {
            fail();
        }
    }
}
