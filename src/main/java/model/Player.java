package model;

import model.map.TileMap;

public class Player {
    private int gold;
    private final String name;
    private final int id;
    private final TileMap tileMap = new TileMap();

    public Player(final String name, final int gold, final int id) {
        this.name = name;
        this.gold = gold;
        this.id = id;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(final int gold) {
        this.gold = gold;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public TileMap getTileMap() {
        return this.tileMap;
    }


}
