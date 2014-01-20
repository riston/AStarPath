package net.risto.pathfinder;

import net.risto.pathfinder.heuristic.EuclideanHeuristic;
import net.risto.pathfinder.heuristic.Heuristics;

import java.util.*;

public class Path {

    private Tile[][] tiles;

    private Tile end;

    private Heuristics heuristics;

    public Path(Map map, Heuristics heuristics) {
        this.tiles = map.getTiles();
        this.heuristics = heuristics;
    }

    public Path(Map map) {
        this(map, new EuclideanHeuristic());
    }


    public ArrayList<Tile> search(Tile start, Tile end) {
        PriorityQueue<Tile> openQueue = new PriorityQueue<Tile>(100, new Comparator<Tile>() {
            @Override
            public int compare(Tile o1, Tile o2) {
                return o1.f - o2.f;
            }
        });
        this.end = end;

        Set<Tile> closed = new HashSet<Tile>(); // Already evaluated pairs

        start.h = start.distance(end, heuristics);
        start.f = start.g + start.h;
        openQueue.add(start);

        Tile currentPair;
        while (!openQueue.isEmpty()) {
            currentPair = openQueue.poll();

            if (currentPair.equals(end)) {
                end = currentPair;
                break;
            }
            closed.add(currentPair.parent);

            // Go through the closest pairs
            for (Tile neighbor : possibleNearMoves(currentPair)) {

                if (closed.contains(currentPair) || closed.contains(neighbor)) continue;

                neighbor.parent = currentPair;
                openQueue.add(neighbor);

            }
        }

        return constructPath(end);
    }

    private ArrayList<Tile> constructPath(Tile end) {
        ArrayList<Tile> path = new ArrayList<Tile>();

        // No path found
        if (end.parent == null) {
            return path;
        }

        Tile current = end;
        while (current != null) {
            path.add(current);
            tiles[current.getY()][current.getX()].setType(TileType.PATH);

            current = current.parent;
        }

        return path;
    }

    public ArrayList<Tile> possibleNearMoves(Tile current) {
        ArrayList<Tile> foundTiles = new ArrayList<Tile>(4);
        int[][] pairs = {
                { 0, -1 },
                { 0, 1 },
                { 1, 0 },
                { -1, 0 }
        };

        for (int[] pair : pairs) {

            int x = current.getX() + pair[0],
                y = current.getY() + pair[1];

            if (isInBounds(x, y) && tiles[y][x].getType() == TileType.FLOOR) {

                Tile tile = tiles[y][x];

                tile.g = tile.getG(tile);
                tile.h = tile.distance(end, heuristics);
                tile.f = tile.g + tile.h;

                foundTiles.add(tile);
            }
        }

        return foundTiles;
    }

    private boolean isInBounds(int x, int y) {
        return (x >= 0 && x < tiles[0].length) &&
                (y >= 0 && y < tiles.length);
    }

}
