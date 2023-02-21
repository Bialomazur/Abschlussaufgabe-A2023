package command;

import model.Game;

import java.util.List;

public class EndGameCommand extends GameCommand {
    private static final int MIN_ARGUMENT_COUNT = 0;
    private static final int MAX_ARGUMENT_COUNT = 0;
    private static final boolean NO_ARGUMENT_CONTENT_VERIFICATION = true;

    EndGameCommand(final Game game, final List<String> args) {
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
        this.getGame().end();
        //TODO: Build Strings
        //TODO: Add a message
    }
}
