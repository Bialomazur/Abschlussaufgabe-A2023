package model;

import model.exception.GameStartedWithoutPlayersException;
import model.market.Market;
import model.time.MasterClock;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final MasterClock masterClock = new MasterClock();
    private final Market market = new Market();
    private final Set<Player> players = new HashSet<>();
    private final int winningGoldAmount;
    private final int startingGoldAmount;

    private static final int PLAYER_ID_INCREMENT = 1;

    public Game(final int startingGoldAmount, final int winningGoldAmount) {
        this.winningGoldAmount = winningGoldAmount;
        this.startingGoldAmount = startingGoldAmount;
    }

    private void init() {
        this.masterClock.setTurnsPerRound(this.players.size());
    }

    private int generatePlayerId() {
        return this.players.size() + PLAYER_ID_INCREMENT;
    }

    public void addPlayer(final String name) {
        this.players.add(new Player(name, this.startingGoldAmount, generatePlayerId()));
    }

    private Set<Player> getPlayersWithWinningGoldAmount() {
        Set<Player> playersWithWinningGoldAmount = new HashSet<>();
        for (final Player player : this.players) {
            if (player.getGold() >= this.winningGoldAmount) {
                playersWithWinningGoldAmount.add(player);
            }
        }
        return playersWithWinningGoldAmount;
    }

    public void start() {
        this.init();
    }

    public void end() {

    }

    //TODO: consider calling this nextTurn() instead for more consistency with nextAction().
    public void endTurn() {
        market.updatePrices();
        this.masterClock.nextTurn();

        if (masterClock.newRoundStarted() && !getPlayersWithWinningGoldAmount().isEmpty()) {
            end();
        }
    }

    public Player getCurrentPlayer() {
        final int currentPlayerId = this.masterClock.getTurn();

        for (final Player player : this.players) {
            if (player.getId() == currentPlayerId) {
                return player;
            }
        }

        throw new GameStartedWithoutPlayersException(); // TODO: Reconsider creating an extra exception for this.
    }

    public void nextAction() {
        this.masterClock.nextAction();
    }
}
