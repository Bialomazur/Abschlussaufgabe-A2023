package command;

import model.Game;
import model.Player;
import model.growable.PlantType;
import model.map.Barn;

import java.util.List;
import java.util.Map;

public class ShowBarnCommand extends GameCommand {
    private static final int MIN_ARGUMENT_COUNT = 0;
    private static final int MAX_ARGUMENT_COUNT = 0;
    private static final boolean NO_ARGUMENT_CONTENT_VERIFICATION = true;

    ShowBarnCommand(final Game game, final List<String> args) {
        super(game, args);
    }

    @Override
    protected int getMinArgumentCount() {
        return MIN_ARGUMENT_COUNT;
    }

    @Override
    protected int getMaxArgumentCount() {
        return MAX_ARGUMENT_COUNT;
    }

    @Override
    protected boolean verifyArgumentsContent() {
        return NO_ARGUMENT_CONTENT_VERIFICATION;
    }

    @Override
    public void execute() {
        final Player player = this.getGame().getCurrentPlayer();
        final Barn barn = player.getTileMap().getBarn();
        final Map<PlantType, Integer> plantInventory = barn.getPlantInventory();
        final StringBuilder output = new StringBuilder();
    }
}
