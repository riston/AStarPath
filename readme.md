# Path finder based on A*

## Usage

Currently the Map object is filled from the string based map, but there is no problem to create load from file or
whatever different ways of base map representations.

There are three types of Tiles:
  - Floor - walkable tile
  - Wall - blocks the walking
  - Path - to mark the final path

```java
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

```

The found path should be like this:

```
    xxxxxxxxxxxxxxxxx
    xgx.xgggx.x.....x
    xgggggxg..xgggggx
    x.....xgg.xg....x
    x.....xxg.xg....x
    x.....xgg.xg....x
    x.....xgxxxg....x
    x.....xggggg....x
    xxxxxxxxxxxxxxxxx
```
