package model.exception;

public class GameStartedWithoutPlayersException extends IllegalStateException{

    public GameStartedWithoutPlayersException() {
        super("The game cannot start without players");
    }
}
