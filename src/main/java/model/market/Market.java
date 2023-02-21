package model.market;

import model.Player;
import model.growable.PlantType;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Market {
    private final Set<PriceIndicator> priceIndicators = new HashSet<>();

    public Market() {
    }

    public int getGrowablePrice(PlantType plantType) {
        return 0;
    }

    public void addPriceIndicator(PriceIndicator priceIndicator) {
        this.priceIndicators.add(priceIndicator);
    }

    public void buy(PlantType plantType, Player player) {

    }

    public void sell(PlantType plantType, Player player) {

    }

    public void updatePrices() {
        for (final PriceIndicator priceIndicator : this.priceIndicators) {
            //TODO: Update price indicators
        }
    }

}
