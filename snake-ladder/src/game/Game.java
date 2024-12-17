package game;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;

    public Game(Board board, Queue<Player> players, Dice dice) {
        this.board = board;
        this.players = new LinkedList<>();
        players.forEach((player) -> addPlayer(player));
        this.dice = dice;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
        board.updatePlayerMapping(player, 0);
    }

    private void playTurn(Player player) {
        if (players.peek() != player)
            throw new UnsupportedOperationException(String.format("It's not player %s's turn", player.id));
        players.poll();
        int rolledDiceNumber = dice.rollDice();
        board.play(player, rolledDiceNumber);
        boolean hasPlayerWon = board.hasPlayerWon(player);
        if (!hasPlayerWon)
            players.offer(player);
        else
            System.out.println(String.format("Player %s has won", player.id));
    }

    public void start() {
        System.out.println("***** Game begins ******");
        for (int i = 0; i < 10; i++) {
            playTurn(players.peek());
        }
        System.out.println("***** Game state ******");
        board.draw();
    }
}
