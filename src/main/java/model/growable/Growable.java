package model.growable;


/**
 * class modelling a growable object.
 * <p>
 * This strong degree of abstraction from a mere "vegetable" to a "growable" is essential,
 * in order to allow for the possibility of building on top of the massive diversity in characteristics and behavior
 * inside of a given plant-type in the future.
 * <p>
 * Furthermore given that for instance a mushroom is a fungus, a tomato is a fruit, and a carrot is a root,
 * those organisms are not only different in their appearance, but also in their behavior, and therefore longterm,
 * the requirement for dynamically implemented distinctions between those, isn't merely probable, but inevitable.
 *
 * @author uejxk
 * @version 1.0
 */

public class Growable {
    private final PlantType plantType;
    private int population;
    private static final int GROWTH_FACTOR = 2;

    public void setPopulation(final int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
    }

    public PlantType getPlantType() {
        return this.plantType;
    }

    public Growable(final Growable growable) {
        this.plantType = growable.getPlantType();
        this.population = growable.getPopulation();
    }

    public void grow() {
        this.population *= GROWTH_FACTOR;
    }

    public void reduceAmount(final int amount) {
        this.population -= amount;
    }

    public int getGrowthInterval() {
        return this.plantType.getGrowthInterval();
    }

}
