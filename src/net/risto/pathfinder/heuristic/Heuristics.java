package net.risto.pathfinder.heuristic;

import net.risto.pathfinder.Tile;

/**
 * Created by rita on 19.01.14.
 */
public interface Heuristics {

    public int distance(Tile a, Tile b);
}
