import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import game.Board;
import game.Dice;
import game.Game;
import game.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board();
        addSnakes(board);
        addLadders(board);
        startGame(board, new Dice());
    }
        private static void startGame(Board board, Dice dice) {
        Player player1 = new Player(1, "player1");
        Player player2 = new Player(2, "player2");
        Queue<Player> players = new LinkedList<>(Arrays.asList(player1, player2));
        Game game = new Game(board, players, dice);
        game.start();

    }

    private static void addSnakes(Board board) {
        board.addSnakeToCell(5, -2);
        board.addSnakeToCell(90, -20);
        board.addSnakeToCell(70, -1);
    }

    private static void addLadders(Board board) {
        board.addLadderToCell(3, 7);
        board.addLadderToCell(80, 20);
        board.addLadderToCell(15, 2);
        board.addLadderToCell(17, 5);

    }
}
