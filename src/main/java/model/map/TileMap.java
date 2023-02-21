package model.map;

import java.util.HashSet;
import java.util.Set;

public class TileMap {
    private final Barn barn = new Barn(); //TODO: Consider using a collection here for better extensibility
    private final Set<CultivableTile> cultivableTiles = new HashSet<>();

    public void buyCultivableTile(final int x, final int y) {

    }

    public void addCultivableTile(final CultivableTile tile) {
        this.cultivableTiles.add(tile);
    }

    public Tile getCultivableTileAt(final int x, final int y) {
        for (final Tile tile : this.cultivableTiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return tile;
            }
        }
        return null; //TODO: Consider throwing an exception here or returning an empty tile
    }

    // TODO: Make sure to clarify that a shallow copy is needed here!
    public Set<CultivableTile> getCultivableTiles() {
        final Set<CultivableTile> shallowCopy = new HashSet<>();
        shallowCopy.addAll(this.cultivableTiles);
        return shallowCopy;
    }

    public Barn getBarn() {
        return this.barn;
    }

    public void buyTile(final int x, final int y) {
        for (final Tile tile : this.cultivableTiles) {
            if (tile.getX() == x && tile.getY() == y) {
                throw new IllegalArgumentException("Tile at given coordinate already in Possession.");
            }
        }
    }

}
