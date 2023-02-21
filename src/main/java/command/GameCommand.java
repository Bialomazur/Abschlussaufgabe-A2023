package command;

import model.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class GameCommand {
    private final Game game;
    private final List<String> arguments = new ArrayList<>();

    private String output = "";


    GameCommand(final Game game, final List<String> args) {
        this.game = game;
        this.arguments.addAll(args);
    }

    protected abstract int getMinArgumentCount();

    protected abstract int getMaxArgumentCount();

    protected List<String> getArguments() {
        return Collections.unmodifiableList(this.arguments); //TODO: Check if package java.util.Collections is allowed
    }

    Game getGame() {
        return this.game;
    }

    protected void setOutput(final String output) {
        this.output = output;
    }

    public String getOutput() {
        return this.output;
    }

    private boolean checkArgumentsCount() {
        return this.arguments.size() >= this.getMinArgumentCount()
                && this.arguments.size() <= this.getMaxArgumentCount();
    }

    private boolean verifyArguments() {
        return this.checkArgumentsCount() && this.verifyArgumentsContent();
    }

    protected abstract boolean verifyArgumentsContent();


    public abstract void execute();
}
