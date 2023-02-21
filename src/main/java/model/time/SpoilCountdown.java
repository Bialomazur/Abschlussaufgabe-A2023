package model.time;

import model.log.LogEntry;
import model.map.Barn;

public class SpoilCountdown extends Countdown {
    private final Barn target;

    protected SpoilCountdown(final int defaultCount, final int countDelta, final Barn target) {
        super(defaultCount, countDelta);
        this.target = target;
    }

    @Override
    protected boolean shouldActivate() {
        return !this.target.isEmpty();
    }

    @Override
    protected int execute() {
        // spoil barn, reset countdown and deactivate the countdown because afterwards the barn will be empty.
        this.target.spoil();
        this.resetCountdown();
        this.deactivate();
        this.setLog(LogEntry.BARN_SPOILED.format());
        return this.getCurrentCount();
    }
}
