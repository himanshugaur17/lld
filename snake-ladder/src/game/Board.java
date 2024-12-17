package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.cell.strategy.LadderMoveStrategy;
import game.cell.strategy.SnakeMoveStrategy;

public class Board {
    List<Cell> cells = new ArrayList<>();
    Map<Player, Cell> playerToCellsMap = new HashMap<>();

    public Board() {
        for (int i = 0; i < 100; i++)
            cells.add(new Cell(i + 1));
    }

    public void addSnakeToCell(int cellValue, int penaltySteps) {
        cells.get(cellValue - 1).moveSteps = penaltySteps;
        cells.get(cellValue - 1).setMoveStrategy(SnakeMoveStrategy.getInstance());
    }

    public void addLadderToCell(int cellValue, int ladderSteps) {
        cells.get(cellValue - 1).moveSteps = ladderSteps;
        cells.get(cellValue - 1).setMoveStrategy(LadderMoveStrategy.getInstance());
    }

    public void updatePlayerMapping(Player player, int cellIndex) {
        cells.get(cellIndex).player = player;
        playerToCellsMap.put(player, cells.get(cellIndex));
    }

    public void play(Player player, int rolledDiceNumber) {
        Cell cell = playerToCellsMap.get(player);
        cell.player = null;
        cell = cells.get(cell.value + rolledDiceNumber - 1);
        while (cell.getMoveStrategy() != null && cell.value != 100) {
            int nextCellIndex = cell.nextCell();
            cell = cells.get(nextCellIndex);
        }
        updatePlayerMapping(player, cell.value - 1);
    }

    public boolean hasPlayerWon(Player player) {
        return playerToCellsMap.get(player).value == 100;
    }

    public void draw() {

        for (int i = 10; i >= 1; i--)
            for (int j = 1; j <= 10; j++) {
                Cell cell = cells.get(i * 10 - j);
                cell.draw();
            }
    }
}
