package model.time;

import model.log.LogEntry;
import model.map.CultivableTile;
import model.map.TileMap;

import java.util.HashSet;
import java.util.Set;

public class CultivableMapCountdown extends Countdown {
    private static final int POPULATION_INCREASE_LOWER_BOUNDARY = 0;
    private static final int SINGULAR_POPULATION_INCREASE = 1;
    private final TileMap target;

    private final Set<GrowthCountdown> growthCountdowns = new HashSet<>();

    protected CultivableMapCountdown(final int defaultCount, final int countDelta, final TileMap target) {
        super(defaultCount, countDelta);
        this.target = target;
    }

    @Override
    protected int execute() {
        this.scanForNewGrowthCountdowns();
        int totalPopulationIncrease = POPULATION_INCREASE_LOWER_BOUNDARY;

        for (final Countdown countdown : this.growthCountdowns) {
            totalPopulationIncrease += countdown.count();
        }

        if (totalPopulationIncrease == SINGULAR_POPULATION_INCREASE) {
            this.setLog(LogEntry.SINGLE_VEGETABLE_GROWN_SINCE_LAST_TURN.format());
        } else if (totalPopulationIncrease > SINGULAR_POPULATION_INCREASE) {
            this.setLog(LogEntry.MULTIPLE_VEGETABLES_GROWN_SINCE_LAST_TURN.format(totalPopulationIncrease));
        }

        this.clearDeactivatedGrowthCountdowns();
        return totalPopulationIncrease;
    }

    private void scanForNewGrowthCountdowns() {
        final Set<CultivableTile> cultivableTilesWithCountdown = new HashSet<>();
        for (final GrowthCountdown countdown : this.growthCountdowns) {
            cultivableTilesWithCountdown.add(countdown.getTarget());
        }

        for (final CultivableTile cultivableTile : this.target.getCultivableTiles()) {
            final boolean hasNoCountdown = !cultivableTilesWithCountdown.contains(cultivableTile);
            final boolean notFull = !cultivableTile.isFull();
            final boolean notEmpty = !cultivableTile.isEmpty();

            if (hasNoCountdown && notFull && notEmpty) {
                final int roundsToGrow = cultivableTile.getGrowthInterval();
                final GrowthCountdown countdown = new GrowthCountdown(roundsToGrow, 1, cultivableTile);
                this.registerCountdown(countdown);
            }
        }
    }

    private void clearDeactivatedGrowthCountdowns() {
        for (final GrowthCountdown countdown : this.growthCountdowns) {
            if (!countdown.isActive()) {
                this.growthCountdowns.remove(countdown);
            }
        }
    }

    private void registerCountdown(final GrowthCountdown countdown) {
        this.growthCountdowns.add(countdown);
    }
}
