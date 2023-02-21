package command;

import model.Game;
import model.Player;

import java.util.List;

public class BuyLandCommand extends GameCommand {
    private static final int MIN_ARGUMENT_COUNT = 2;
    private static final int MAX_ARGUMENT_COUNT = 2;
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;

    BuyLandCommand(final Game game, final List<String> args) {
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
        for (final String coordinate : this.getArguments()) {
            try {
                Integer.parseInt(coordinate);
            } catch (final NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void execute() {
        final int xCoordinate = Integer.parseInt(this.getArguments().get(X_COORDINATE_INDEX));
        final int yCoordinate = Integer.parseInt(this.getArguments().get(Y_COORDINATE_INDEX));
        final Player currentPlayer = this.getGame().getCurrentPlayer();

        //TODO: Figure out how to fulfill the transaction
    }
}
