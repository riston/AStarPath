package net.risto.pathfinder.tests;

import junit.framework.Assert;
import net.risto.pathfinder.Map;
import net.risto.pathfinder.Path;
import net.risto.pathfinder.Tile;
import net.risto.pathfinder.TileType;
import net.risto.pathfinder.heuristic.ManhattenHeuristic;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by rita on 19.01.14.
 */
public class PathTest {


    @Test
    public void testPathSearching() throws Exception {
        String map =
                "xxxxxxxxxxxxxxxxx\n" +
                "x.x.x...........x\n" +
                "x.........x.....x\n" +
                "xxxxxxxxxxxxxxxxx";

        Map tileMap = new Map(map);
        Tile start = new Tile(1, 1, TileType.FLOOR);
        Tile end = new Tile(6, 1, TileType.FLOOR);
        Path path = new Path(tileMap, new ManhattenHeuristic());
//        path.search(start, end);
    }

    @Test
    public void testNoNeighbourFound() throws Exception {
        String map =
                "xxx\n" +
                "x.x\n" +
                "xxx";

        Map tileMap = new Map(map);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        Assert.assertEquals(0, path.possibleNearMoves(new Tile(1, 1, TileType.FLOOR)).size());

    }

    @Test
    public void testSouthNeighbourFound() throws Exception {
        String map =
                "xxx\n" +
                "x.x\n" +
                "x.x\n" +
                "xxx";

        Map tileMap = new Map(map);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        ArrayList<Tile> near = path.possibleNearMoves(new Tile(1, 1, TileType.FLOOR));
        Assert.assertEquals(1, near.size());

        Assert.assertEquals(1, near.get(0).getX());
        Assert.assertEquals(2, near.get(0).getY());

    }

    @Test
    public void testSouthAndNorthNeighbourFound() throws Exception {
        String map =
                "xxx\n" +
                "x.x\n" +
                "x.x\n" +
                "x.x\n" +
                "xxx";

        Map tileMap = new Map(map);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        ArrayList<Tile> near = path.possibleNearMoves(new Tile(1, 2, TileType.FLOOR));
        Assert.assertEquals(2, near.size());

        // North
        Assert.assertEquals(1, near.get(0).getX());
        Assert.assertEquals(1, near.get(0).getY());

        // South
        Assert.assertEquals(1, near.get(1).getX());
        Assert.assertEquals(3, near.get(1).getY());
    }

    @Test
    public void testSouthAndNorthAndEastNeighbourFound() throws Exception {
        String map =
                "xxxx\n" +
                "x..x\n" +
                "x..x\n" +
                "x..x\n" +
                "xxxx";

        Map tileMap = new Map(map);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        ArrayList<Tile> near = path.possibleNearMoves(new Tile(1, 2, TileType.FLOOR));
        Assert.assertEquals(3, near.size());

        // North
        Assert.assertEquals(1, near.get(0).getX());
        Assert.assertEquals(1, near.get(0).getY());

        // South
        Assert.assertEquals(1, near.get(1).getX());
        Assert.assertEquals(3, near.get(1).getY());

        // East
        Assert.assertEquals(2, near.get(2).getX());
        Assert.assertEquals(2, near.get(2).getY());
    }

    @Test
    public void testSouthAndNorthAndEastAndWestNeighbourFound() throws Exception {
        String map =
                "xxxxx\n" +
                "x...x\n" +
                "x...x\n" +
                "x...x\n" +
                "xxxxx";

        Map tileMap = new Map(map);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        ArrayList<Tile> near = path.possibleNearMoves(new Tile(2, 2, TileType.FLOOR));
        Assert.assertEquals(4, near.size());

        // North
        Assert.assertEquals(2, near.get(0).getX());
        Assert.assertEquals(1, near.get(0).getY());

        // South
        Assert.assertEquals(2, near.get(1).getX());
        Assert.assertEquals(3, near.get(1).getY());

        // West
        Assert.assertEquals(3, near.get(2).getX());
        Assert.assertEquals(2, near.get(2).getY());

        // East
        Assert.assertEquals(1, near.get(3).getX());
        Assert.assertEquals(2, near.get(3).getY());
    }

}
