package model.map;

import model.growable.Growable;

public class CultivableTile extends Tile {
    private BiotopeType biotopeType;
    private Growable growable;

    private static final int GROWABLE_PLANTATION_DECREASE = 1;

    public void harvest(final int amount) {
        this.growable.setPopulation(this.growable.getPopulation() - amount);
    }

    public void plant(final Growable growable) {
        final boolean allowed = this.biotopeType.getAllowedPlants().contains(growable.getPlantType());
        final boolean empty = this.growable == null; // TODO: Make sure to erase this null check!

        if (!allowed) {
            throw new IllegalArgumentException("Plant type not allowed on this biotope");
        }

        if (!empty) {
            throw new IllegalArgumentException("Tile is already occupied");
        }

        growable.setPopulation(growable.getPopulation() - GROWABLE_PLANTATION_DECREASE);
        this.growable = growable; //TODO: !!!! Decide whether to implement Prototype here.
    }


    public void grow() {
        //TODO: Verify on forum how the edge case of CAPACITY/2 < growable.amount < CAPACITY should be handled.
        this.growable.setPopulation(this.growable.getPopulation() + 1);
    }

    public boolean isFull() {
        return this.growable.getPopulation() == this.growable.getPopulation();
    }

    public boolean isEmpty() {
        return false;
    }

    public int getPopulation() {
        return this.growable.getPopulation();
    }

    public int getGrowthInterval() {
        return this.growable.getGrowthInterval();
    }


}
