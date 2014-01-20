package net.risto.pathfinder.heuristic;

import net.risto.pathfinder.Tile;

public interface Heuristics {

    public int distance(Tile a, Tile b);
}
