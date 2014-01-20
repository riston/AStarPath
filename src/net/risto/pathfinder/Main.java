package net.risto.pathfinder;

import net.risto.pathfinder.heuristic.ManhattenHeuristic;

public class Main {

    public static void main(String[] args) {

        String map =
            "xxxxxxxxxxxxxxxxx\n" +
            "x.x.x...x.x.....x\n" +
            "x.....x...x.....x\n" +
            "x.....x...x.....x\n" +
            "x.....xx..x.....x\n" +
            "x.....x...x.....x\n" +
            "x.....x.xxx.....x\n" +
            "x.....x.........x\n" +
            "xxxxxxxxxxxxxxxxx";

        Map tileMap = new Map(map);
        Tile start = new Tile(1, 1, TileType.FLOOR);
        Tile end = new Tile(15, 2, TileType.FLOOR);

        Path path = new Path(tileMap, new ManhattenHeuristic());
        path.search(start, end);
        System.out.println(tileMap);

        map =
            "xxxxxxxxxxxxxxxxx\n" +
            "x...............x\n" +
            "x...............x\n" +
            "x...............x\n" +
            "x...............x\n" +
            "x...............x\n" +
            "x...............x\n" +
            "x...............x\n" +
            "xxxxxxxxxxxxxxxxx";

        long startTime = System.currentTimeMillis();

        tileMap = new Map(map);
        start = new Tile(1, 1, TileType.FLOOR);
        end = new Tile(15, 7, TileType.FLOOR);

        path = new Path(tileMap);
        path.search(start, end);
        System.out.println(tileMap);
        System.out.println(System.currentTimeMillis() - startTime);

    }
}
