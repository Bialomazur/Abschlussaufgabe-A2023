package model.map;

import model.growable.PlantType;

import java.util.Collections;
import java.util.Set;

public enum BiotopeType {
    GARDEN(Set.of(PlantType.SALAD, PlantType.TOMATO, PlantType.CARROT, PlantType.MUSHROOM)),
    FOREST(Set.of(PlantType.MUSHROOM, PlantType.CARROT)),
    FIELD(Set.of(PlantType.SALAD, PlantType.TOMATO)),
    LARGE_FIELD(Set.of(PlantType.SALAD, PlantType.TOMATO, PlantType.CARROT)),
    LARGE_FOREST(Set.of(PlantType.MUSHROOM, PlantType.CARROT, PlantType.TOMATO));

    private final Set<PlantType> allowedPlants;

    BiotopeType(final Set<PlantType> allowedPlants) {
        this.allowedPlants = allowedPlants;
    }

    public Set<PlantType> getAllowedPlants() {
        return Collections.unmodifiableSet(this.allowedPlants); //TODO: Make sure that using this method is allowed in the exam!
    }
}
