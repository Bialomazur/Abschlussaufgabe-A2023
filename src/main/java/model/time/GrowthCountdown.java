package model.time;

import model.map.CultivableTile;

public class GrowthCountdown extends Countdown {
    private final CultivableTile target;

    protected GrowthCountdown(final int defaultCount, final int countDelta, final CultivableTile target) {
        super(defaultCount, countDelta);
        this.target = target;
    }

    @Override
    protected int execute() {
        // TODO: Verify whether the capacity limit check works as intended!
        final int populationPreGrowth = this.target.getPopulation();

        this.target.grow(); //! Assuming here that due to the countdown still being active, the tile is NOT full.
        this.resetCountdown();
        if (this.target.isFull()) { // TODO: Consider moving ALL activation/deactivation logic to the masterclock.
            this.deactivate();
        }

        return this.target.getPopulation() - populationPreGrowth;
    }

    protected CultivableTile getTarget() {
        return this.target;
    }
}
