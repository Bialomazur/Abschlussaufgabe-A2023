package model.map;

import model.growable.Growable;
import model.growable.PlantType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Barn extends Tile {
    private final Set<Growable> growables = new HashSet<>();
    private static final int MIN_UNIT_STORED = 0;
    private static final int DEFAULT_UNIT_STORED = 1;


    public void spoil() {

    }

    public boolean isEmpty() {
        return false;
    }

    public void store(final Growable growable) {
        //TODO: Due to the modelling of Growable, this method is very error-prone!
    }

    //TODO: Make sure that if the player sells multiple growables, ALL of them are FIRST removed from the barn and THEN added to the player's gold amount.
    //TODO: This is to ensure the atomicity of the market transaction, that if an exception is thrown, the player's gold amount is not changed.
    public void remove(final Growable growable, final int amount) {
        //TODO: Due to the modelling of Growable, this method is very error-prone!
    }

    public Map<PlantType, Integer> getPlantInventory() {
        Map<PlantType, Integer> plantInventory = new HashMap<>();
        for (PlantType plantType : PlantType.values()) {
            plantInventory.put(plantType, MIN_UNIT_STORED);
        }

        for (Growable growable : this.growables) {
            PlantType plantType = growable.getPlantType();
            plantInventory.put(plantType, growable.getPopulation());
        }

        return plantInventory;
    }
}
