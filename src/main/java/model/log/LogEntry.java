package model.log;

public enum LogEntry {
    LINE_SEPARATOR("\n"),
    HARVEST("You have harvested %d %s."),
    PLAYERS_TURN("It is %s's turn!"),
    SINGLE_VEGETABLE_GROWN_SINCE_LAST_TURN("1 vegabtale has grown since last turn."),
    MULTIPLE_VEGETABLES_GROWN_SINCE_LAST_TURN("%d vegetables have grown since last turn."),
    MARKET_SOLD(""),
    MARKET_BOUGHT("You have bought a %s for %d gold."), // Same message for Tile and GrowAble.
    BARN_SPOILED("The vegetables in your barn are spoiled."),
    PLAYER_WON("%s has won!"),
    EMPTY_LOG(""),
    PLAYER_INFO_AT_GAME_END("Player %d (%s): %d");

    private final String template;

    LogEntry(final String message) {
        this.template = message;
    }

    public String format(final Object... args) {
        return String.format(this.template, args);
    }


}
