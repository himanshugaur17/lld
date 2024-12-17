package game.cell.strategy;

import game.Cell;

public class SnakeMoveStrategy implements MoveStrategy {
    private static MoveStrategy snakeMoveStrategy;

    private SnakeMoveStrategy() {

    }

    public static MoveStrategy getInstance() {
        if (snakeMoveStrategy == null) {
            snakeMoveStrategy = new SnakeMoveStrategy();
        }
        return snakeMoveStrategy;
    }

    @Override
    public int move(Cell cell) {
        return cell.value - cell.moveSteps;
    }

    @Override
    public void draw() {
        System.out.print("Snake ");
    }

}
