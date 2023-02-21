package command;

import model.Game;

import java.util.List;


/**
 * Class modelling a command that ends the current player's turn.
 *
 * @author uejxk
 * @version 1.0
 * */

public class EndTurnCommand extends GameCommand {
    private static final int MIN_ARGUMENT_COUNT = 0;
    private static final int MAX_ARGUMENT_COUNT = 0;
    private static final boolean NO_ARGUMENT_CONTENT_VERIFICATION = true;

    protected EndTurnCommand(final Game game, final List<String> args) {
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
        return NO_ARGUMENT_CONTENT_VERIFICATION ;
    }


    @Override
    public void execute() {
        this.getGame().endTurn();
    }
}
