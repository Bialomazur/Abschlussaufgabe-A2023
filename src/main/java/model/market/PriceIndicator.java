package model.market;

import model.growable.PlantType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PriceIndicator {
    private final List<Map<PlantType, Integer>> priceRatios = new ArrayList<>();
    private int currentRatioIndex;
    private int salesDeltaDivisor = 2;
    private final PlantType plantType1;
    private final PlantType plantType2;

    public PriceIndicator(final int currentRatioIndex, final PlantType plantType1, final PlantType plantType2) {
        this.currentRatioIndex = currentRatioIndex;
        this.plantType1 = plantType1;
        this.plantType2 = plantType2;
    }

    public void addPriceRatio(final Map<PlantType, Integer> priceRatio) {
        this.priceRatios.add(priceRatio);
    }

    public int getPrice(final PlantType plantType) {
        return this.priceRatios.get(this.currentRatioIndex).get(plantType);
    }

    public void setSalesDeltaDivisor(final int salesDeltaDivisor) {
        this.salesDeltaDivisor = salesDeltaDivisor;
    }

    public void updatePriceRatios(final Map<PlantType, Integer> salesLog) {
        final int plantType1Sales = salesLog.get(this.plantType1);
        final int plantType2Sales = salesLog.get(this.plantType2);
        if (plantType1Sales > plantType2Sales) {
            final int salesDelta = plantType1Sales - plantType2Sales;
            final int indexDelta = salesDelta / this.salesDeltaDivisor;
            this.currentRatioIndex += indexDelta;
        } else if (plantType1Sales < plantType2Sales) {
            this.currentRatioIndex--;
        }

        if (this.currentRatioIndex < 0) {
            this.currentRatioIndex = 0;
        } else if (this.currentRatioIndex >= this.priceRatios.size()) {
            this.currentRatioIndex = this.priceRatios.size() - 1;
        }
    }
}
