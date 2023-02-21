package command;

import model.Game;

import java.util.List;


/**
 * Class modelling a command that flushes the game's event queue and
 * transforms its content to a corresponding String output.
 *
 * @author uejxk
 * @version 1.0
 * */

public class FlushEventQueueCommand extends GameCommand {
    private static final int MIN_ARGUMENT_COUNT = 0;
    private static final int MAX_ARGUMENT_COUNT = 0;
    private static final boolean NO_ARGUMENT_CONTENT_VERIFICATION = true;

    FlushEventQueueCommand(Game game, List<String> args) {
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

    }
}
