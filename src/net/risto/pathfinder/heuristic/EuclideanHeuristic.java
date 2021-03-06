package net.risto.pathfinder.heuristic;

import net.risto.pathfinder.Tile;

public class EuclideanHeuristic implements Heuristics {

    @Override
    public int distance(Tile a, Tile b) {
        return (int) Math.floor(Math.sqrt(
                Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)
        ));
    }
}
